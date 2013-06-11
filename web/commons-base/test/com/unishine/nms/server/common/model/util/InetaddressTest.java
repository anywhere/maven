package com.unishine.nms.server.common.model.util;

import java.net.SocketException;

import org.junit.Test;

import com.framework.ssm.util.IPAddressUtil;

public class InetaddressTest {
    
    @Test
    public void testRun() throws SocketException {
        System.out.println(IPAddressUtil.getInetAddress());
    }
}