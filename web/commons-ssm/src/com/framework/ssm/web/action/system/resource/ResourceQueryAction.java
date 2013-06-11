package com.framework.ssm.web.action.system.resource;

import java.util.ArrayList;

import com.framework.ssm.pojo.Resources;
import com.google.gson.Gson;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:02:35 PM
 * <ul>
 * <li>comment:资源查询</li>
 * <ul>
 */
@SuppressWarnings("serial")
public class ResourceQueryAction extends ResourceBaseAction {
    
    protected String exec() {
        list = resourceService.select();
        if (null == list) {
            LOG.warn("ResourceList is null");
            list = new ArrayList<Resources>();
        }
        Gson gson = new Gson();
        json = gson.toJson(list);
        return LIST;
    }
    
}