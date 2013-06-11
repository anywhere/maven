package com.framework.ssm.server.heartbeat;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HeartInfo implements Serializable {
    
    private String name;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}