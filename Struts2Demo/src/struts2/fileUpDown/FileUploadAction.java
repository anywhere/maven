package struts2.fileUpDown;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 文件上传下载Action
 * 
 * @author Administrator
 * 
 */
public class FileUploadAction extends ActionSupport
{
    // 文件域属性
    private File upload;
    
    // 文件类型，如果上传一下gif的图片，则uploadContentType值为：image/gif
    private String uploadContentType;
    
    // 文件名
    private String uploadFileName;
    
    // 接受依赖注入的属性
    private String savePath;
    
    // 允许上传的文件的格式，接受依赖注入的属性
    private String allowTypes;
    
    public String getAllowTypes()
    {
        return allowTypes;
    }
    
    // 接受依赖注入的方法
    public void setAllowTypes(String allowTypes)
    {
        this.allowTypes = allowTypes;
    }
    
    // 接受依赖注入的方法
    public void setSavePath(String value)
    {
        this.savePath = value;
    }
    
    // 返回上传文件的保存路径
    private String getSavePath()
        throws Exception
    {
        return ServletActionContext.getServletContext().getRealPath(this.savePath);
    }
    
    public void setUpload(File upload)
    {
        this.upload = upload;
    }
    
    public void setUploadContentType(String uploadContentType)
    {
        this.uploadContentType = uploadContentType;
    }
    
    public void setUploadFileName(String uploadFileName)
    {
        this.uploadFileName = uploadFileName;
    }
    
    public File getUpload()
    {
        return (this.upload);
    }
    
    public String getUploadContentType()
    {
        return (this.uploadContentType);
    }
    
    public String getUploadFileName()
    {
        return (this.uploadFileName);
    }
    
    // 文件过滤
    public String filterType(String[] types)
    {
        String fileType = getUploadContentType();
        for (String type : types)
        {
            if (type.equals(fileType))
            {
                return null;
            }
        }
        return INPUT;
    }
    
    @Override
    public String execute()
        throws Exception
    {
        System.out.println("===========");
        // 代码实现文件过滤
        String filterResult = filterType(this.getAllowTypes().split(","));
        if (filterResult != null)
        {
            ActionContext.getContext().put("typeError", "您要上传的文件类型不正确！");
            return filterResult;
        }
        
        String filePath = this.getSavePath() + "\\" + this.getUploadContentType();
        
        File file = new File(filePath);
        
        if (!file.exists())
        {
            // 创建目录，如果父目录不存在，则也会创建
            file.mkdirs();
        }
        System.out.println("======="+filePath + "\\" + this.getUploadFileName());
        // 以服务器的保存地址及原有文件名创建文件上传输出流
        FileOutputStream out = new FileOutputStream(filePath + "\\" + this.getUploadFileName());
        // 以上传的文件创建一个上传流
        FileInputStream input = new FileInputStream(this.getUpload());
        // 将上传文件的内容写入服务器
        byte[] buf = new byte[1024];
        int len = 0;
        while ((len = input.read(buf)) > 0)
        {
            out.write(buf, 0, len);
        }
        input.close();
        out.close();
        
        return SUCCESS;
    }
}
