package com.framework.ssm.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.framework.ssm.pojo.Resources;
import com.framework.ssm.service.system.ResourceService;
import com.framework.ssm.service.system.RoleService;

// 1 加载资源与权限的对应关系
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    
    @Autowired
    private ResourceService resourceService;
    
    @Autowired
    private RoleService roleService;
    
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }
    
    // 返回所请求资源所需要的权限
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        loadResourceDefine();
        String requestUrl = ((FilterInvocation) object).getRequest().getServletPath();
        return resourceMap.get(requestUrl);
    }
    
    // 加载所有资源与权限的关系
    private void loadResourceDefine() {
        if (resourceMap == null) {
            resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
            List<Resources> resources = resourceService.select();
            for (Resources resource : resources) {
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                // 以权限名封装为Spring的security Object
                ConfigAttribute configAttribute = new SecurityConfig(resource.getName());
                configAttributes.add(configAttribute);
                resourceMap.put(resource.getUrl(), configAttributes);
            }
        }
        // Set<Entry<String, Collection<ConfigAttribute>>> resourceSet = resourceMap.entrySet();
        // Iterator<Entry<String, Collection<ConfigAttribute>>> iterator = resourceSet.iterator();
        
        // if (resourceMap == null) {
        // resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
        // List<Roles> roleList = this.roleDao.findAll();
        // // 通过数据库中的信息设置，resouce和role
        // for (Roles role : roleList) {
        // Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
        // //以权限名封装为Spring的security Object
        // ConfigAttribute ca = new SecurityConfig(role.getName());
        // atts.add(ca);
        // List<Resource> resourceList = resourceDao.findResourceByRoleId(role.getId());
        // // 把资源放入到spring security的resouceMap中
        // for (Resource resource : resourceList) {
        // resourceMap.put(resource.getUrl(), atts);
        // }
        // }
        // }
    }
    
    public boolean supports(Class<?> clazz) {
        return true;
    }
    
}
