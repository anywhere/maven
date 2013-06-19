package com.framework.ssm.web.action.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.framework.ssm.web.action.StrutsAction;

/**
 * 文件上传下载基础action
 * 
 * @author jinyifeng5969@163.com QQ:361612388
 * @since 2013-6-8
 * @description
 * @TODO
 */
@SuppressWarnings("serial")
public abstract class FileAction extends StrutsAction {
    
    // protected static final int BUFFER_SIZE = 16 * 1024;
    
    // 封装上传文件域的属性
    protected File file;
    
    // 封装上传路径的属性
    protected String filePath;
    
    // 封装上传文件名的属性
    protected String fileFileName;
    
    // 封装上传文件类型的属性
    protected String fileContentType;// 文件类型
    
    public File getFile() {
        return file;
    }
    
    public void setFile(File file) {
        this.file = file;
    }
    
    public String getFileContentType() {
        return fileContentType;
    }
    
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }
    
    public String getFileFileName() {
        return fileFileName;
    }
    
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }
    
    public String getFilePath() {
        return ServletActionContext.getServletContext().getRealPath(filePath);
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
    /**
     * 获取文件拓展名
     * <ul>
     * <li>author jinyifeng5969@163.com</li>
     * <li>createDate: 2013-6-19 上午10:51:14</li>
     * <li>comment:</li>
     * <p>
     * </p>
     * </ul>
     * 
     * @param fileName
     * @return
     */
    protected static String getExtention(String fileName) {
        int pos = fileName.lastIndexOf(".");
        return fileName.substring(pos);
    }
    
    /**
     * 获取下载文件名
     * <ul>
     * <li>author jinyifeng5969@163.com</li>
     * <li>createDate: 2013-6-19 上午10:48:18</li>
     * <li>comment:中文名处理</li>
     * <p>
     * </p>
     * </ul>
     * 
     * @return
     */
    public String getDownloadFileName() {
        String download = fileFileName;
        try {
            download = new String(download.getBytes(), "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return download;
    }
    
    /**
     * 关闭文件输入输出流
     * <ul>
     * <li>author jinyifeng5969@163.com</li>
     * <li>createDate: 2013-6-19 上午10:51:47</li>
     * <li>comment:</li>
     * <p>
     * </p>
     * </ul>
     * 
     * @param fos
     * @param fis
     */
    protected void close(FileOutputStream fos, FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("FileInputStream关闭失败");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("FileOutputStream关闭失败");
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 获取下载文件
     */
    public InputStream getTargetFile() {
        return ServletActionContext.getServletContext().getResourceAsStream(file.getPath());
    }
}