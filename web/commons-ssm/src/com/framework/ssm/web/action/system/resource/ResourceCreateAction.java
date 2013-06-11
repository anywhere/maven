package com.framework.ssm.web.action.system.resource;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:03:11 PM
 * <ul>
 * <li>comment:资源创建</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class ResourceCreateAction extends ResourceBaseAction {
    
    protected String exec() {
        resourceService.insert(resource);
        flag = true;
        return SUCCESS;
    }
    
}