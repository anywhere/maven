package com.framework.ssm.web.action.system.resource;

import com.framework.ssm.exception.BussinessException;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:02:55 PM
 * <ul>
 * <li>comment:资源详细信息</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class ResourceDetailAction extends ResourceBaseAction {
    
    protected String exec() {
        resource = resourceService.get(resource.getId());
        // 判断一下id在数据库是否存在
        if (null == resource) {
            throw new BussinessException(CODE_NOT_EXIST, "该资源");
        }
        return SUCCESS;
    }
}