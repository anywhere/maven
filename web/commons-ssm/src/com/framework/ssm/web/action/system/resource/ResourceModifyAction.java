package com.framework.ssm.web.action.system.resource;

import com.framework.ssm.exception.BussinessException;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:02:45 PM
 * <ul>
 * <li>comment:资源修改</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class ResourceModifyAction extends ResourceBaseAction {
    
    public String exec() {
        resourceService.update(resource);
        flag = true;
        return SUCCESS;
    }
    
    public String input() {
        resource = resourceService.get(resource.getId());
        // 判断一下id在数据库是否存在
        if (null == resource) {
            BussinessException e = new BussinessException(CODE_NOT_EXIST, "该资源");
            addError(getMessage(e.getMessage(), e.getArgs()));
            return ERROR;
        }
        return INPUT;
    }
    
}