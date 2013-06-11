package com.framework.ssm.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.framework.ssm.pojo.User;

public final class AcegiUtils {
    
    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    
    @SuppressWarnings("unchecked")
    public static Collection<GrantedAuthority> getAuthorities() {
        return (Collection<GrantedAuthority>) getAuthentication().getAuthorities();
    }
    
    public static String getCredentials() {
        return (String) getAuthentication().getCredentials();
    }
    
    /**
     * @description 取得当前登录的用户
     * @return
     */
    public static String getCurrentOperator() {
        String username = null;
        Authentication auth = getAuthentication();
        if (null == auth) {
            return username;
        }
        Object principal = auth.getPrincipal();
        if (null == principal) {
            return username;
        }
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
    
    public static User getCurrentUser() {
        User user = null;
        Authentication auth = getAuthentication();
        if (null == auth) {
            return user;
        }
        Object principal = auth.getPrincipal();
        if (null == principal) {
            return user;
        }
        if (principal instanceof User) {
            user = (User) principal;
        }
        return user;
    }
    
    /**
     * @description 判断是否已经登录
     * @return
     */
    public static boolean hasLogin() {
        return getAuthentication() != null;
    }
    
}