<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <form action="Register.do">
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
  				<td><s:text name="age"/></td>
  				<td><input type="age" name="age"/></td>
  			</tr>
  			<tr>
  				<td><s:text name="birthDate"/></td>
  				<td><input type="birthDate" name="birthDate"/></td>
  			</tr>
  			<tr>
  				<td colspan="2"><input type="submit" value="<s:text name='register'/>"/></td>
  				
  			</tr>
    	</table>
    </form>
  </body>
</html>
