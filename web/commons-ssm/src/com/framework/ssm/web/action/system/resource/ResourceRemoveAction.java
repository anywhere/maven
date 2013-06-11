package com.framework.ssm.web.action.system.resource;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:02:18 PM
 * <ul>
 * <li>comment:资源删除</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class ResourceRemoveAction extends ResourceBaseAction {
    
    protected String exec() {
        resourceService.delete(resource.getId());
        return SUCCESS;
    }
}