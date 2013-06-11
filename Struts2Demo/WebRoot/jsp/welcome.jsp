<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- Struts2有时与EL表达式有冲突，isELIgnored=false设置为不忽略EL表达式 -->
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'welcome.jsp' starting page</title>
  </head>
  
  <body>&nbsp; 
  	${requestScope.hello }
  
    <!-- 针对messageRecource_zh_CN文件的方式1 -->
    <s:text name="succTip">
    	<s:param>${sessionScope.userInfo}</s:param>
    </s:text>
    
    <!-- 针对messageRecource_zh_CN文件的方式2 -->
    <!-- <s:text name="succTip"></s:text>   --> 
    
    
    <!-- 在struts.xml文件中为bookAction配置了命名空间使用如下 
    <a href="book/book.do"><s:text name="viewLink"/></a>-->
    
    <!-- 在struts.xml文件中为bookAction未配置了命名空间使用如下 -->
    <a href="book.do"><s:text name="viewLink"/></a>
    
    <a href="file/upload.jsp">上传文件下载</a>
    
    <br>
    Struts2的Ajax测试
    <a href="ajaxPage/testAjaxTheme.jsp">测试AJAx，使用Ajax模版</a>
     <br>
    使用JSON实现AJAX
    <a href="JSONAjax/first.jsp">测试AJAx，使用Ajax模版</a>
    <br><br>
    <s:debug></s:debug>
  </body>
</html>
