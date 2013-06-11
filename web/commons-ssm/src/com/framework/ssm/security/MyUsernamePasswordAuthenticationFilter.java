package com.framework.ssm.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.TextEscapeUtils;

import com.framework.ssm.pojo.User;
import com.framework.ssm.service.system.UserService;

/**
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-5-29
 * @description
 * @TODO
 */
public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    public static final String VALIDATE_CODE = "validateCode";
    
    @Resource
    private UserCache userCache;
    
    @Resource
    private UserService userService;
    
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        
        // 校验验证码
        // checkValidateCode(request);
        
        // 获取用户名、密码数据
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        
        // 验证用户账号与密码是否对应
        username = username.trim();
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("User not found!");
        }
        
        // 从缓存里取User
        User loginUser = (User) userCache.getUserFromCache(username);
        // 如果没有缓存，查询
        if (loginUser == null) {
            loginUser = userService.login(username, password);
            if (loginUser == null) {
                throw new AuthenticationServiceException("登录失败，用户名或密码错误"); // 用户名不存在
            }
        } else {
            if (loginUser.getAuthorities().isEmpty()) {
                throw new AuthenticationServiceException("用户没有权限!");
            }
        }
        
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        
        // 允许子类设置详细属性
        setDetails(request, authRequest);
        Authentication auth = this.getAuthenticationManager().authenticate(authRequest);
        // 保存登录相关信息
        request.getSession().setAttribute(SPRING_SECURITY_LAST_USERNAME_KEY, TextEscapeUtils.escapeEntities(username));
        return auth;
    }
    
    protected void checkValidateCode(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String session_code = obtainSessionValidateCode(session);
        String check_code = obtainValidateCodeParameter(request);
        // 让上一次的验证码失效
        session.setAttribute(VALIDATE_CODE, null);
        if (StringUtils.isEmpty(check_code) || !session_code.equalsIgnoreCase(check_code)) {
            throw new AuthenticationServiceException("登录失败，验证码输入错误");
        }
    }
    
    protected String obtainSessionValidateCode(HttpSession session) {
        return ObjectUtils.toString(session.getAttribute(VALIDATE_CODE));
    }
    
    private String obtainValidateCodeParameter(HttpServletRequest request) {
        return ObjectUtils.toString(request.getParameter(VALIDATE_CODE));
    }
    
}