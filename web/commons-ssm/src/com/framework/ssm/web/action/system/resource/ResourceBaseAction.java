package com.framework.ssm.web.action.system.resource;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import com.framework.ssm.pojo.Resources;
import com.framework.ssm.service.system.ResourceService;
import com.framework.ssm.web.action.StrutsAction;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @author jinyifeng
 * @email jinyifeng5969@163.com
 * @version create time Jul 9, 2012 4:03:24 PM
 * <ul>
 * <li>comment:资源操作基础Action</li>
 * <ul>
 */
@SuppressWarnings("serial")
public abstract class ResourceBaseAction extends StrutsAction {
    
    protected boolean flag;
    
    protected Resources resource;
    
    @Resource
    protected ResourceService resourceService;
    
    public String check() throws UnsupportedEncodingException {
        // 对字段进行校验和过滤
        if (StringUtils.isNotEmpty(resource.getName())) {
            Resources resources = resourceService.findResource(resource);
            flag = null == resources;
        }
        return SUCCESS;
    }
    
    public String order() {
        if (json.length() > 2) {
            List<Resources> list = new ArrayList<Resources>(0);
            Gson gson = new Gson();
            Type type = new TypeToken<List<Resources>>() {}.getType();
            List<Resources> resources = gson.fromJson(json, type);
            // 从数据库查出所有的数据
            Map<String, Resources> map = resourceService.queryAllMap();
            for (Resources res : resources) {
                Resources resource = map.get(res.getId());
                if ((null != resource) && (resource.getCurrentOrder() != res.getCurrentOrder())) {
                    Resources r = new Resources();
                    r.setId(res.getId());
                    r.setCurrentOrder(res.getCurrentOrder());
                    list.add(r);
                }
            }
            resourceService.update(list);
        }
        return SUCCESS;
    }
    
    public void setResource(Resources resource) {
        this.resource = resource;
    }
    
    public Resources getResource() {
        return resource;
    }
    
    public boolean isFlag() {
        return flag;
    }
    
}