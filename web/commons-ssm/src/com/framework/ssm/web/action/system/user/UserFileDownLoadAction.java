package com.framework.ssm.web.action.system.user;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.framework.ssm.exception.BussinessException;

/**
 * 文件下载基础action
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-6-8
 * @description
 * @TODO
 */
@SuppressWarnings("serial")
public class UserFileDownLoadAction extends UserQueryAction {
    
    protected String exec() {
        super.exec();
        file = new File(filePath, getFileFileName());
        if (null == ServletActionContext.getServletContext().getResourceAsStream(file.getPath())) {
            throw new BussinessException("文件不存在或已经被删除！");
        }
        return SUCCESS;
    }
    
}