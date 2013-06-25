package com.anywhere.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.Test;
import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.alibaba.druid.pool.DruidDataSource;
import com.jolbox.bonecp.BoneCPDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@ContextConfiguration("classpath:spring/applicationContext-jdbc.xml")
public class ConnectionPoolTest extends AbstractJUnit4SpringContextTests {
    
    private static Logger log = LoggerFactory.getLogger(ConnectionPoolTest.class);
    
    @Resource
    private DataSource tomcat_jdbc;
    
    @Resource
    private BoneCPDataSource bonecp;
    
    @Resource
    private ComboPooledDataSource c3p0;
    
    @Resource
    private BasicDataSource commons_dbcp;
    
    @Resource
    private DruidDataSource druid;
    
    @Resource
    private ProxoolDataSource proxool;
    
    @Test
    public void testTomcatJdbc() throws Exception {
        Connection conn = tomcat_jdbc.getConnection();
        query(conn);
    }
    
    @Test
    public void testBonecp() throws Exception {
        Connection conn = bonecp.getConnection();
        query(conn);
    }
    
    @Test
    public void testC3p0() throws Exception {
        Connection conn = c3p0.getConnection();
        query(conn);
    }
    
    @Test
    public void testCommonsDbcp() throws Exception {
        Connection conn = commons_dbcp.getConnection();
        query(conn);
    }
    
    @Test
    public void testDruid() throws Exception {
        Connection conn = druid.getConnection();
        query(conn);
    }
    
    @Test
    public void testProxool() throws Exception {
        Connection conn = proxool.getConnection();
        query(conn);
    }
    
    private void query(Connection conn) throws Exception {
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from node where id=1");
        while (rs.next()) {
            String name = rs.getString(3);
            System.out.println(name);
        }
        rs.close();
        statement.close();
        conn.close();
    }
}