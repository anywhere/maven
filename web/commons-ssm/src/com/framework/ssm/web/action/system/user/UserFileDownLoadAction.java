package com.framework.ssm.web.action.system.user;

import java.io.File;

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
        return SUCCESS;
    }
    
}