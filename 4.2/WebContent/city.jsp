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
    
    <title>测试拉取数据页面</title>
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
     	以下是从action类中拉取数据测试：
     	<br>
     	1、直接显示属性：<s:property value="Sproperty"/>----${Sproperty }<br>
     	2、直接显示对象属性：<s:property value="customer.cname"/>----${customer.cname }<br>
     	3、显示集合或数组某元素值：<s:property value="customer.travelCities[0]"/><br>
     	4、显示map:<s:property value="map.shanghai"/><br>
     	5、显示执行表达式计算：<s:property value="customer.cname!=null"/><br>
     	6、显示执行方法：<s:property value="customer.cname.length()"/><br>
     	7、显示不访问action创建的临时集合：<s:property value="{1,2,3}"/><br>
<!--      	有问题的地方 -->
     	8、显示不访问action创建临时集合：<s:property value="#{'bj':'北京','sh':'上海'}"/><br>
     	9、输出栈顶内容：<s:property /><br>
<!--      	有问题的地方 -->
     	10、输出context对象：<s:property value="#xwork.NullHandler.createNullObjects"/><br>
     	
     	演示s:iterator1<br>
     	<s:iterator var="s" value="customer.travelCities" status="st">
     		<s:property value="#st.index"/>:<s:property value="s"/><br>
     	</s:iterator>
     	<br>
     	
     	演示s:iterator2<br>
     	<s:iterator begin="1" end="5" step="1" var="k">
     		<s:property value="#k"/><br>
     	</s:iterator>
     	<br>
     	
     	----------------<br>
     	context对象：<s:property value="#k"/><br>
     	----------------<br>
     	
     	<%--1.表单标签 --%>
<%--      	<s:form action="#" method="post" theme="simple"> --%>
<!--      		多选框标签 -->
<!--      		1)根据OGNL(list属性值)创建的Map生成一组checkbox，其中Map的key生成checkbox的value值，Map的value生成checkbox的label值 -->
<!--      		2)根据OGNL(name属性值->customer.travelCities)取值来与生成checkbox的value比较，若与哪个checkbox的value值一致，则将其勾选 -->
<!--      		<br> 1-->
<%--      		<s:checkboxlist list="cities" name="customer.travelCities" listKey="code" listValue="name"></s:checkboxlist> --%>
     		<br>
<%--      		<s:checkboxlist name="travelCities" list="#{'01':'北京','02':'上海','03':'广州','04':'钓鱼岛' }"></s:checkboxlist> --%>

<!-- 			单选框标签 -->
<%--      	</s:form> --%>
     	
  </body>
</html>
