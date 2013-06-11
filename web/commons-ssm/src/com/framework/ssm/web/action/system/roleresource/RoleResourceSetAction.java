package com.framework.ssm.web.action.system.roleresource;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserCache;

import com.framework.ssm.exception.BussinessException;
import com.framework.ssm.pojo.Resources;
import com.framework.ssm.pojo.User;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:03:46 PM
 * <ul>
 * <li>comment:角色资源关联修改</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class RoleResourceSetAction extends RoleResourceBaseAction {
    
    private String msg;
    
    private String resourceTree;
    
    private String selectedResource;
    
    @Autowired
    private UserCache userCache;
    
    public String exec() {
        if (StringUtils.isEmpty(role.getId())) {
            LOG.debug("role is null!");
            throw new BussinessException(CODE_IS_EMPTY);
        }
        String[] resources = selectedResource.split(",");
        roleService.setResources(role.getId(), resources);
        
        // 根据当前修改的角色，将所有与这个角色相关的用户缓存删除
        List<User> list = userService.queryByRoleId(role.getId());
        for (User users : list) {
            if (null != userCache.getUserFromCache(users.getUsername())) {
                userCache.removeUserFromCache(users.getUsername());
            }
        }
        // 更新会话
        // detailsService.loadUserByUsername("admin");
        // session.getAttribute("");
        // UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        // .getPrincipal();
        // SecurityContextHolder.getContext().setAuthentication(SecurityContextHolder.getContext().getAuthentication());
        return SUCCESS;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public String getResourceTree() {
        return resourceTree;
    }
    
    public String input() {
        // Map<String, List<Resources>> resList = new HashMap<String, List<Resources>>();
        list = resourceService.select();
        for (Resources r : list) {
            r.setUrl("");
        }
        rrlist = resourceService.queryByRoleId(role.getId());
        // Gson gson = new Gson();
        // resList.put("list", list);
        // resList.put("rrlist", rrlist);
        // resourceTree = gson.toJson(resList);
        return INPUT;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setSelectedResource(String selectedResource) {
        this.selectedResource = selectedResource;
    }
    
}