package com.framework.ssm.server.heartbeat;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class HeartBeatClient extends QuartzJobBean {
    
    private static final Logger log = LoggerFactory.getLogger(HeartBeatClient.class);
    
    private String name = "HeartBeat";
    
    private String address = "192.168.0.22";
    
    private int port = 25535;
    
    private int interval = 2 * 1000;
    
    private Socket socket = null;
    
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        new HeartBeat().start();
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPort(int port) {
        this.port = port;
    }
    
    public void setInterval(int interval) {
        this.interval = interval;
    }
    
    public class HeartBeat extends Thread {
        
        ObjectOutputStream out;
        
        public void run() {
            try {
                socket = new Socket(InetAddress.getByName(address), port);
                log.info("Hearbeat started ok.");
                for (;;) {
                    out = new ObjectOutputStream(socket.getOutputStream());
                    HeartInfo obj = new HeartInfo();
                    // TODO heartbeat instance data
                    obj.setName(name);
                    out.writeObject(obj);
                    out.flush();
                    log.debug(name + " Hearbeat send success.");
                    Thread.sleep(interval);
                }
            } catch (Exception e) {
                log.error(name + "Hearbeat error.", e);
            }
        }
        
    }
    
}