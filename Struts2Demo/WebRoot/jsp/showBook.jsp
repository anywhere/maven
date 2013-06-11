<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'showBook.jsp' starting page</title>
	</head>
	<body>
		<table border="1" width="360">
			<caption>
				<s:text name="bookPageTitle" />
			</caption>
			<!-- 类似于books这些属性值被保存到struts.valueStack的请求属性里，内置查找books功能 
  			准备说：迭代输出ValueStack中的books对象，其中status是迭代的序号
  		-->
			<s:iterator value="books" status="index">
				<tr>
					<!-- 判断序号是否为奇数 -->
					<s:if test="#index.odd == true">
						<tr style="background-color: #cccccc">
					</s:if>
					<s:else>
						<tr>
					</s:else>
					<td>
						<s:text name="bookName" />
					</td>
					<td>
						<s:property />
					</td>
				</tr>
			</s:iterator>

		</table>
	</body>
</html>
