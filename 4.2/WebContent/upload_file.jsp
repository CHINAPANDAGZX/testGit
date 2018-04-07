<%@ page language="java" contentType="text/html; charset=UTF-8" import="Bean.*,java.lang.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head >
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文档上传页面</title>

<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" > </link>  
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src= "js/my/register_Admin.js"></script>
<%-- <script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/npm.js" %>></script> --%>

<script type='text/javascript'>  

</script> 

<style type="text/css">
	
</style> 	
	
</head>
<body>
<!-- 	<nav class="navbar navbar-inverse"> -->
<!-- 	头部导航栏开始 -->
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="login.action?user.name=home"><span
				class="glyphicon glyphicon-home"></span> 首页</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">登录</a></li>
				<li><a href="#">帮助</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">备用菜单 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
	<!-- 	头部导航栏结束 -->

<!-- 	下部内容开始 -->
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="jumbotron">
				<h1>
					上传文档
				</h1>
				<p>
					用户贡献上传文档可获得更多积分
				</p>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
		<font color="black">
			<!-- 	上传表格开始 -->
			<form class="form-horizontal"  method="post" onsubmit="" 
			theme="simple" enctype="multipart/form-data" action="uploadAction.action">
<%-- 			   action="<%=basepath%>/upload.action"--%>
<!-- 				 <label>要注册的用户ID:</label> -->
<!-- 				 <input id="user.ID" name="user.ID"/> -->
				<div class="form-group">
				 <label  class="col-sm-4 control-label">文档标题:</label>
				 <div class="col-sm-4">
<%-- 				  	<label  class="col-sm-4 control-label">用户ID：<s:property value="session.user.user_id"/></label> --%>
<%-- 				  	<label  class="col-sm-4 control-label">用户名称：<s:property value="session.user.user_name"/></label> --%>
<%-- 				 	<input class="form-control"  value="<s:property value="session.user.user_name"/>">  --%>
					<input type="hidden" class="form-control" id="doc_userID" name="doc.d_up_userid" value="<s:property value="session.user.user_id"/>"/>
				 	<input class="form-control" id="docname" name="doc.d_name"  onblur="" />
<!-- 				 	<input class="form-control" id="username" name="user.user_name"  onblur="check_name()" /> -->
				 </div>
				 <font color="red"><span  id="ename_msg"></span></font>
				</div>	
				
				<div class="form-group">
				 <label  class="col-sm-4 control-label">文档简介:</label>
				 <div class="col-sm-4"> 
				 	<textarea id="docdescription" name="doc.d_description" cols="30" rows="3" style="resize:none "></textarea>
				 </div>
				 <font color="red"><span  id="ename_msg"></span></font>
				</div>
				 
				  <div class="form-group">
				 	<label  class="col-sm-4 control-label">下载该文档所需积分:</label>
				 	<div class="col-sm-4">
				 		<select class="form-control" name="doc.d_dlpoint">
  							<option value ="5">5分</option>
  							<option value ="10">10分</option>
  							<option value ="15">15分</option>
  							<option value ="20">20分</option>
  							<option value ="25">25分</option>
  							<option value ="30">30分</option>
						</select>
				 	</div>
				 </div>
				 
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">请选择要上传的文档:</label>
				 	<div class="col-sm-4">
  							 <s:file name="myfileone"></s:file>
				 	</div>
				 </div>
				
				 
				 <div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						 <button type="submit" class="btn btn-default">提交</button>
						 <button type="button" class="btn btn-default">返回</button>
					</div>
				</div>
			</form>
			<!-- 	上传表格结束 -->
		</font>

		</div>
		<div class="col-md-2 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
	
</div>
<!-- 	下部内容结束 -->

<!-- </nav> -->

</body>
</html>