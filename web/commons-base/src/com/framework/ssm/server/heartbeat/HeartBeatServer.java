package com.framework.ssm.server.heartbeat;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.framework.ssm.util.IPAddressUtil;

public class HeartBeatServer extends QuartzJobBean {
    
    private static final Logger log = LoggerFactory.getLogger(HeartBeatServer.class);
    
    private static final String DEFAULT_IP = IPAddressUtil.getInetAddress();
    
    private static final int DEFAULT_PORT = 25535;
    
    private String address = DEFAULT_IP;
    
    private int port = DEFAULT_PORT;
    
    private ServerSocket serverSocket;
    
    Object obj = new Object();
    
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        serverSocket = startListenUserReport(port);
        if (serverSocket == null) {
            log.warn("创建ServerSocket失败！");
            return;
        }
        log.info("Hearbeat Server started OK.");
        for (;;) {
            try {
                Socket client = serverSocket.accept();
                synchronized (obj) {
                    new Client(client).start();
                }
            } catch (Exception e) {
                log.info("Client Hearbeat socket accept fail.", e);
            }
        }
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setPort(int port) {
        this.port = port;
    }
    
    /**
     * 创建一个ServerSocket来侦听用户心跳包请求
     * 
     */
    private ServerSocket startListenUserReport(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(address, port));
            return serverSocket;
        } catch (IOException e) {
            if (serverSocket != null) {
                if (!serverSocket.isClosed()) {
                    try {
                        serverSocket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        return serverSocket;
    }
    
    class Client extends Thread {
        
        private Socket socket;
        
        public Client(Socket socket) {
            this.socket = socket;
        }
        
        public void run() {
            try {
                for (;;) {
                    ObjectInput in = new ObjectInputStream(socket.getInputStream());
                    HeartInfo entity = (HeartInfo) in.readObject();
                    // TODO 解析心跳包
                    log.info("Receive Hearbeat " + entity.getName());
                }
            } catch (Exception e) {
                log.info("Client Hearbeat package read fail.", e);
            }
        }
    }
}
