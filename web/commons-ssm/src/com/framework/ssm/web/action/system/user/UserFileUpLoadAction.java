package com.framework.ssm.web.action.system.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.framework.ssm.web.action.file.FileAction;

/**
 * 文件下载基础action
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-6-8
 * @description
 * @TODO
 */
@SuppressWarnings("serial")
public class UserFileUpLoadAction extends FileAction {
    
    protected String exec() throws Exception {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            // 建立文件输出流
            // System.out.println(getFilePath());
            // 设置目标文件
            File toFile = new File(getFilePath(), getFileFileName());
            if (!toFile.getParentFile().exists())
                toFile.getParentFile().mkdirs();
            // System.out.println(toFile.getAbsolutePath());
            fos = new FileOutputStream(toFile);
            // 建立文件上传流
            fis = new FileInputStream(getFile());
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            // System.out.println("文件上传失败");
            LOG.info("文件上传失败");
            e.printStackTrace();
        } finally {
            close(fos, fis);
        }
        return SUCCESS;
    }
    
}