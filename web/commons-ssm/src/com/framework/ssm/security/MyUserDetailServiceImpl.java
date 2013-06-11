package com.framework.ssm.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.framework.ssm.pojo.Resources;
import com.framework.ssm.pojo.Roles;
import com.framework.ssm.pojo.User;
import com.framework.ssm.service.system.UserService;

/**
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-5-29
 * @description 项目实现的用户查询服务,将用户信息查询出来
 * @TODO
 */
// 2
@Component("userDetailService")
public class MyUserDetailServiceImpl implements UserDetailsService {
    
    @Resource
    private UserCache userCache;
    
    @Resource
    private UserService userService;
    
    // 登录验证
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从缓存里取User
        User loginUser = (User) userCache.getUserFromCache(username);
        // 如果没有缓存，查询
        if (loginUser == null) {
            loginUser = new User();
            loginUser.setUsername(username);
            // 这里应该可以不用再查了
            User user = userService.findUser(loginUser);
            if (null == user) {
                throw new UsernameNotFoundException(username);
            }
            
            Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
            
            boolean enables = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;
            
            // PasswordEncoder encoder = (PasswordEncoder) new Md5PasswordEncoder();
            // users.setPassword(encoder.encode(users.getPassword()));
            // 封装成spring security的user
            loginUser = new User(user.getId(), user.getUsername(), user.getPassword(), user.getDisplayname(), enables,
                    user.getMsisdn(), user.getEmail(), user.getLastLoginTime(), user.getLoginFaildTims(),
                    user.getDateOfExpiry(), user.getCreateDate(), user.getRoles(), accountNonExpired,
                    credentialsNonExpired, accountNonLocked, grantedAuths);
            // userdetail.setResources(resources);
        }
        // } else {
        if (loginUser.getAuthorities().isEmpty()) {
            throw new AuthenticationServiceException("用户没有权限!");
        }
        // }
        
        return loginUser;
    }
    
    /**
     * 取得用户的权限
     */
    private Set<GrantedAuthority> obtionGrantedAuthorities(User user) {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
        for (Roles role : user.getRoles()) {
            for (Resources res : role.getResources()) {
                authSet.add(new SimpleGrantedAuthority(res.getName()));
            }
        }
        return authSet;
    }
    
}