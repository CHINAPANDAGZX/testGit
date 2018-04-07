<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    <h2>我的信息</h2>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head> 
  
  <body>
     	<br>
     	我的名称：<s:property value="user.user_name"/><br>
     	我的积分：<s:property value="user.user_point"/>分<br>
     	我的等级：<s:property value="user.user_grade"/><br>
     	我的头像：<s:property value="user.user_avatarURL"/><br>
     	我的性别：<s:property value="user.user_sex"/><br>
     	我的学历：<s:property value="user.user_education"/><br>
     	我的职业：<s:property value="user.user_career"/><br>
     	我的手机：<s:property value="user.user_phone"/><br>
     	我的邮箱：<s:property value="user.user_Email"/><br>
     	
    
     	
  </body>
</html>
