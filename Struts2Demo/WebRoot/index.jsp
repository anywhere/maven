<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>登录页面</title>
	</head>
	<body>
		<s:form action="Login">
			<s:textfield label="用户名" name="userName" />
			<s:password name="password" label="密码" />
			<s:submit value="登录" />
		</s:form>
	</body>
</html>