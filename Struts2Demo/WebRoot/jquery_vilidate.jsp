<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Jquery_vilidate</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <script src="js/jquery_vilidate/jquery.validate.js" type="text/javascript"></script>
      	<script src="js/jquery-1.6.1.js" type="text/javascript"></script>
     <script type="text/javascript">
     $.validator.setDefaults({
		submitHandler: function() { alert("submitted!"); }
		});
     	$(document).ready(function(){
      		$("#signupForm").validate({
		rules: {
			username: {
				required: true,
				minlength: 2
			},
			password: {
				required: true,
				minlength: 5
			},
			confirm_password: {
				required: true,
				minlength: 5,
				equalTo: "#password"
			},
			email: {
				required: true,
				email: true
			},
			topic: {
				required: "#newsletter:checked",
				minlength: 2
			},
			agree: "required"
		},
		messages: {
			username: {
				required: "Please enter a username",
				minlength: "Your username must consist of at least 2 characters"
			},
			password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long"
			},
			confirm_password: {
				required: "Please provide a password",
				minlength: "Your password must be at least 5 characters long",
				equalTo: "Please enter the same password as above"
			},
			email: "Please enter a valid email address",
			agree: "Please accept our policy"
		}
	});
      	});
     </script>
  </head>
  
  <body>
  <form id="signupForm"  method="post" class="" action="">
  	<input type="text" name="username"><br>
  	<input type="text" name="password"><br>
  	<input type="text" name="confirm_password"><br>
  	<input type="text" name="email"><br>
  	<input type="text" name="agree"><br>
  	<input type="submit" value="提交">
  </form>
  </body>
</html>
