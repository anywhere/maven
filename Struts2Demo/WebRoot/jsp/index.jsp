<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'index.jsp' starting page</title>
	<script>
		function regist()
		{
			var targetForm = document.forms[0];
			//方法1，解释为：调用Login类(Action)中的register方法
			targetForm.action = "Login!register.do";
			
			//方法2，解释为：直接调用Register类(Action)，根据Register所属的Action标签中的method属性调用哪个方法
			//targetForm.action = "Register.do";
			
			targetForm.submit();
		}
		
		function langSelecter_onChanged()
		{
			document.forms[0].submit();
		}
	</script>
	<!-- 要使用树控件或者日期控件，必项加入以下一行代码，导入Ajax主题的controlheader.ftl模版 -->
	<sx:head parseContent="true"/>
  </head>
  
  <body>
  
  	<!-- 从系统中获取设置的语言 -->
  	<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
	<!-- 加载系统支持国际化的语言种类的 JavaBean -->
	<s:bean id="locales" name="language.Locales">
		<s:param name="current"  value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE"/>
	</s:bean>

	<!-- autocomplete关闭IE的自带联想功能 -->
  	<form action="Login.do" method="post" autocomplete="off">
  		<table>
  			<tr>
  				<td><s:text name="用户名"/></td>
  				<td><input type="text" name="userName"/></td>
  			</tr>
  			<tr>
  				<td><s:text name="密码"/></td>
  				<td><input type="password" name="password"/></td>
  			</tr>
  			<tr>
  				<td><s:text name="languag"/></td>
  				<td>
  					<!-- 生成系统支持语言的下拉框 -->
  					<s:select label="Language" 
			        list="#locales.locales" listKey="value" listValue="key"
			        value="#SESSION_LOCALE"
			        name="request_locale" id="langSelecter" 
			        onchange="langSelecter_onChanged()" theme="simple"/>
  				</td>
  			</tr>
  			<tr>
  				<td><input type="submit" value="<s:text name='login'/>"/></td>
  				<td><a href="register.jsp"><s:text name='register'/></a></td>
  				<td><input type="button" value="<s:text name='register'/>" onClick="regist();"/></td>
  			</tr>
  		</table>
  	</form>
  	<s:form action="Login.do" method="post">
		<s:textfield label="用户名" name="userName" />
		<s:password label="密码" name="password" />
		<s:submit value="登录" />
	</s:form>
  	查看Spring与String2整合,跳转到jsp/login.jsp
  	<a href="jsp/login.jsp">Spring与String2整合</a> 	
  	<br><br>
  	<s:checkboxlist label="checkboxlist使用list集合,复选框" list="{'aa','bb','cc','dd'}" name="book" value="{'aa'}"></s:checkboxlist>
  	<br><br>
  	<s:checkboxlist label="checkboxlist使用map集合,复选框" list="#{1:'11',2:'22',3:'33',4:'44'}" listKey="key" listValue="value" name="book" value="{1}"></s:checkboxlist>
  	<br><br>
  	<s:combobox label="combobox使用list集合,可选可输,不能指定listKey与listValue标签" theme="css_xhtml" list="{'aaa','bbb'}" name="bb"></s:combobox>
  	
  	<!--   validate="true"
    <s:form action="Login">
    	<s:textfield name="userName" key="userName"></s:textfield>
    	<s:password name="password" key="password"></s:password>
    	<s:submit key="login"></s:submit>
    </s:form>
    -->
    
    <br><br>
    
    <!-- 使用Struts2的树控件,theme:引用主题模版 showGrid:是否显示树下的线 showRootGrid:是否显示根节点的线 -->
    <sx:tree label="计算机图书" id="book" 
		showRootGrid="true" showGrid="true" treeSelectedTopic="treeSelected">
	    <sx:treenode label="李刚" id="yeeku">
	        <sx:treenode label="Spring2.0宝典" id="spring"/>
	        <sx:treenode label="轻量级J2EE企业应用实战" id="lightweight"/>
	        <sx:treenode label="基于J2EE的Ajax宝典" id="ajax"/>
	    </sx:treenode>
	    <sx:treenode label="David" id="David">
	        <sx:treenode label="JavaScript: The Definitive Guide" id="javascript"/>
	    </sx:treenode>
	    <sx:treenode label="Johnson" id="Johnson">
	        <sx:treenode label="Expert One-on-One J2EE Design and Development" id="j2ee"/>
	    </sx:treenode>
	</sx:tree>
	
	 <br><br>
	 日期选择部件，指定toggleType属性,且指定value="today"<br>
    <sx:datetimepicker name="date" label="购买日期" toggleType="explode" value="today"/><hr>
	日期选择部件，指定了format属性<br>
    <sx:datetimepicker name="date" label="购买日期" displayFormat="yyyy年MM月dd日"/><hr>
	日期选择部件，指定了weekStartsOn属性(指定哪一天才是一周的第一天)<br>
    <sx:datetimepicker name="date" label="购买日期" displayFormat="yyyy年MM月dd日" weekStartsOn="2"/><hr>
	时间选择部件<br>
	<sx:datetimepicker label="选择出发时间'" name="start" type="time" value="13:00"/><hr>
	<br><br>
	<h3>使用s:updownselect生成可上下移动选项的下拉选择框</h3>
		<!-- 使用简单集合来生成可上下移动选项的下拉选择框 -->
		<s:updownselect name="a" label="请选择您喜欢的图书" labelposition="top"
			moveUpLabel="向上移动"
			list="{'Spring2.0宝典' , '轻量级J2EE企业应用实战' , 'JavaScript: The Definitive Guide'}"/>
		<!-- 使用简单Map对象来生成可上下移动选项的下拉选择框 
			 且使用emptyOption="true"增加一个空选项-->
		<s:updownselect name="b" label="请选择您想选择出版日期" labelposition="top"
			moveDownLabel="向下移动"
			list="#{'Spring2.0宝典':'2006年10月' , '轻量级J2EE企业应用实战':'2007月4月' , '基于J2EE的Ajax宝典':'2007年6月'}"
			listKey="key"
			emptyOption="true"
			listValue="value"/>
		<s:bean name="service.BookService" id="bs"/>
		<!-- 使用集合里放多个JavaBean实例来可上下移动选项的生成下拉选择框 -->
		<s:updownselect name="c" label="请选择您喜欢的图书的作者" labelposition="top"
			selectAllLabel="全部选择" multiple="true"
			list="#bs.books"
			listKey="author"
			listValue="name"/>
		
		<br><br>
		<!-- 使用Map对象来生成下拉选择框的选项组 -->
<s:select label="选择您喜欢的图书"
           name="book"
           list="#{'Spring2.0宝典':'李刚','轻量级J2EE企业应用实战':'李刚','基于J2EE的Ajax宝典':'李刚'}"
		   listKey="value"
		   listValue="key">
   <s:optgroup label="Rod Johnson"
           list="#{'Expert One-on-One J2EE Design and Development':'Johnson'}"
		   listKey="value"
		   listValue="key"/>
   <s:optgroup label="David Flanagan"
           list="#{'JavaScript: The Definitive Guide':'David'}"
		   listKey="value"
		   listValue="key"/>
</s:select>

<br><br>
	Tab标签<br><br>
	<sx:tabbedpanel id="panel" label="页签" doLayout="true" cssStyle="width:400px;height:200px">
		<sx:div id="left" label="第一个页签" theme="ajax">
			<h3>第一个页签   bbbbbbbbbb</h3>
		</sx:div>
		<sx:div id="middle" label="第二个页签" theme="ajax">
			<h3>第二个页签   cccccccccccccc</h3>
		</sx:div>
	</sx:tabbedpanel>
	
	
  </body>
</html>
