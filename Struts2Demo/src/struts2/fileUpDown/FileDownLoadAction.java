package struts2.fileUpDown;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownLoadAction extends ActionSupport
{
    private String inputPath;
    
    public String getInputPath()
    {
        return inputPath;
    }
    
    public void setInputPath(String inputPath)
    {
        this.inputPath = inputPath;
    }
    
    /*
     * 下载用的Action应该返回一个InputStream实例， 该方法对应在result里的inputName属性值为targetFile
     */
    public InputStream getTargetFile()
        throws Exception
    {
        System.out.println(inputPath);
        return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
    }
    
    public String execute()
        throws Exception
    {
        return SUCCESS;
    }
}
