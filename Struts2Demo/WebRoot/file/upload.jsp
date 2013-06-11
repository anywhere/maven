<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!-- Struts2有时与EL表达式有冲突，isELIgnored=false设置为不忽略EL表达式 -->
<%@ page isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>利用拦截器实现文件过滤</title>
	</head>
	<body>
		<!-- 以下是代码过滤使用这个提示错误信息 -->
		${typeError }
		
		<!-- 以下是使用拦截器实现文件过滤 -->
		<s:fielderror></s:fielderror>
		
		<form action="FileUpLoad.do" method="post" enctype="multipart/form-data">
		  	选择文件：<input type="file" name="upload" /><br>
			<input value="上传" type="submit" />
		</form>
		
		<a href="FileDownLoad.do">文件下载</a>
	</body>
</html>
