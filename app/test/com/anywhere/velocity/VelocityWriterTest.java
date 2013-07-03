package com.anywhere.velocity;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration("classpath:spring/applicationContext-velocity.xml")
public class VelocityWriterTest extends AbstractJUnit4SpringContextTests {
    
    private Logger log = LoggerFactory.getLogger(VelocityWriterTest.class);
    
    @Resource
    private VelocityWriter velocityWriter;
    
    @Test
    public void testCoder() {
        try {
            // Map<String, Object> model = velocityWriter.getModel();
            // model.put("codepackage", "com.unishine.lte");
            // model.put("author", "jinyifeng5969@163.com");
            velocityWriter.mergeTemplate();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            System.exit(0);
        }
    }
    
}