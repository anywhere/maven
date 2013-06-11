package com.framework.ssm.web.action.system.role;

import java.util.List;

import com.framework.ssm.util.StringUtil;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:00:25 PM
 * <ul>
 * <li>comment: 角色删除</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class RoleRemoveAction extends RoleBaseAction {
    
    private String id;
    
    protected String exec() {
        List<String> list = StringUtil.string2List(id);
        roleService.deleteBatch(list);
        return LIST;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
}