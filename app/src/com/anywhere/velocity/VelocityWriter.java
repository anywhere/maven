package com.anywhere.velocity;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class VelocityWriter {
    
    /** slf4j实例 */
    private Logger log = LoggerFactory.getLogger(getClass());
    
    private String filename;
    
    private String templateLocation; // 注入的velocity模块
    
    private String encoding = "UTF-8";
    
    private Map<String, Object> model = new HashMap<String, Object>();
    
    @Resource
    private VelocityEngine velocityEngine;
    
    public void mergeTemplate() throws Exception {
        File file = new File(filename);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        FileWriterWithEncoding writer = new FileWriterWithEncoding(file, encoding);
        VelocityEngineUtils.mergeTemplate(velocityEngine, templateLocation, encoding, model, writer);
        writer.flush();
    }
    
    public String mergeTemplateIntoString() {
        return VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateLocation, encoding, model);
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public void setTemplateLocation(String templateLocation) {
        this.templateLocation = templateLocation;
    }
    
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
    
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }
    
    public Map<String, Object> getModel() {
        return model;
    }
    
}