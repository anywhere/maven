<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
    <head>
        <title>上传成功</title>
    </head>
    <body>
        上传成功!<br>
		文件为：<img src="<s:property value="'../upload/' + uploadContentType + '/'+ uploadFileName"/>"/><br>
    </body>
</html>
