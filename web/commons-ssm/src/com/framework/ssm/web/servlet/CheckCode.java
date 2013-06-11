package com.framework.ssm.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.framework.ssm.util.ImageUtils;

@SuppressWarnings("serial")
public class CheckCode extends HttpServlet {
    
    // 验证码中允许出现的字符串
    private static final String DEFAULT_ALLOW_VALIDATE_STRING = "0123456789abcdefghijklmnopqrstuvwxyz";
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpeg");
        ServletOutputStream output = response.getOutputStream();
        String validateCode = ImageUtils.validateCode(output, DEFAULT_ALLOW_VALIDATE_STRING);
        request.getSession(true).setAttribute("validateCode", validateCode);
        response.flushBuffer();
    }
    
}