<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>管理员注册页面</title>

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
	<nav class="navbar navbar-inverse">
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
			<a class="navbar-brand" href="pageShift.action?req=home"><span class="glyphicon glyphicon-home"></span> 首页</a>
<%-- 			<a class="navbar-brand" href=<%=basepath+"/login.action?user.name=home" %>><span --%>
<%-- 				class="glyphicon glyphicon-home"></span> 首页</a> --%>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="pageShift.action?req=login">登录</a></li>
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
					管理员注册
				</h1>
				<p>
					注册之后登录，可以使用更多功能
				</p>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
		<font color="white">
			<form class="form-horizontal"  method="post" onsubmit="return myFunction()" 
			 enctype="multipart/form-data" action="registerAction.action" name="myform">
<%-- 			   action="<%=basepath%>/upload.action"--%>
<!-- 				 <label>要注册的用户ID:</label> -->
<!-- 				 <input id="user.ID" name="user.ID"/> -->
				<div class="form-group">
				 <label  class="col-sm-4 control-label">要注册的用户名:</label>
				 <div class="col-sm-4">
				 	<input class="form-control" id="username" name="user.user_name"  onblur="check_name()" />
				 </div>
				 <font color="red"><span  id="ename_msg"></span></font>
				</div>	
				
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">密码:</label>
				 	<div class="col-sm-4">
				 	<input type="password" class="form-control" id="pwd" name="user.user_psw"/>
				 	</div>
				 </div>
				 
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">重复密码:</label>
				 	<div class="col-sm-4">
				 		 <input type="password" class="form-control" id="" name=""/>
				 	</div>
				 </div>
				 
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">性别:</label>
				 	<div class="col-sm-4">
				 		<input type="radio" value="男" name="user.user_sex">男</input>
				 		<input type="radio" value="女" name="user.user_sex">女</input>
				 	</div>
				 </div>
				 
				  <div class="form-group">
				 	<label  class="col-sm-4 control-label">学历:</label>
				 	<div class="col-sm-4">
				 		<select class="form-control" name="user.user_education">
  							<option value ="小学及以下">小学及以下</option>
  							<option value ="初中">初中</option>
  							<option value="高中">高中</option>
  							<option value="本科">本科</option>
  							<option value="硕士">硕士</option>
  							<option value="博士及以上">博士及以上</option>
						</select>
				 	</div>
				 </div>
				 
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">职业:</label>
				 	<div class="col-sm-4">
				 		<select class="form-control" name="user.user_career">
  							<option value ="学生">学生</option>
  							<option value ="其他">"其他"</option>
						</select>
				 	</div>
				 </div>
				 
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">手机号:</label>
				 	<div class="col-sm-4">
  							 <input class="form-control" id="" name="user.user_phone"/>
				 	</div>
				 </div>
				
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">电子邮箱:</label>
				 	<div class="col-sm-4">
  						<input class="form-control" id="" name="user.user_Email"/>
				 	</div>
				 </div>
				 
				 <div class="form-group">
				 	<label  class="col-sm-4 control-label">请选择要上传的文件:</label>
				 	<div class="col-sm-4">
  							 <s:file name="myfileone"></s:file>
				 	</div>
				 </div>
				
				 
				 <div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						
						 <button type="submit" class="btn btn-default">注册</button>
						 <button type="button" class="btn btn-default">返回</button>
					</div>
				</div>
			</form>
		</font>

		</div>
		<div class="col-md-2 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
		<div class="col-md-4 column">
			<h2>
				Heading
			</h2>
			<p>
				Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.
			</p>
			<p>
				 <a class="btn" href="#">View details »</a>
			</p>
		</div>
	</div>
</div>
<!-- 	下部内容结束 -->

</nav>

</body>
</html>