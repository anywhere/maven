package com.anywhere.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreemarkerTest extends TestCase {
    
    public void testFreemarker01() throws Exception {
        String dir = "D:/service/GitHub/app/app/file";
        
        Configuration cfg = new Configuration();
        
        // 从什么地方加载模板文件
        cfg.setDirectoryForTemplateLoading(new File(dir));
        
        // 加载模板
        Template template = cfg.getTemplate("test01.ftl");
        
        // 定义数据
        Map root = new HashMap();
        root.put("stringvalue", "世界你好");
        
        // 定义输出
        Writer out = new FileWriter(dir + "/test01_out.txt");
        
        template.process(root, out);
        
        out.flush();
        out.close();
    }
    
}