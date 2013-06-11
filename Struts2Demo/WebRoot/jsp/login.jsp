<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'login.jsp' starting page</title>

  </head>
  
  <body>
    <!-- autocomplete关闭IE的自带联想功能 -->
  	<form action="springTest.do" method="post" autocomplete="off">
  		<table>
  			<tr>
  				<td><s:text name="userName"/></td>
  				<td><input type="text" name="userName"/></td>
  			</tr>
  			<tr>
  				<td><s:text name="password"/></td>
  				<td><input type="password" name="password"/></td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="<s:text name='login'/>"/></td>
  				<!--td><input type="button" value="<s:text name='register'/>" onClick="regist();"/></td-->
  			</tr>
  		</table>
  	</form>
  </body>
</html>
