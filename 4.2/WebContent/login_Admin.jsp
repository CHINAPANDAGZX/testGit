<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head >
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页面</title>

<script type="text/javascript" charset="UTF-8" src="js/jquery-3.3.1.js" ></script>

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" > </link>  
<script type="text/javascript" charset="UTF-8" src= "js/bootstrap.js"></script>
<script type="text/javascript" charset="UTF-8" src= "js/my/Login_Admin.js"></script>
<%-- <script type="text/javascript" charset="UTF-8" src=<%=basepath+"/js/npm.js" %>></script> --%>

<script type="text/javascript" language="javascript">
	//刷新验证码图片
	function change(image) {
		//改变img的src即可，由于该URL并没有变化，因此追加动态参数伪装成变化的URL。
		image.src = "createImage.action?date=" + new Date().getTime();
		
	}
	
</script>

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
<%-- 			<a class="navbar-brand" href=<%="login.action?user.name=home" %>><span class="glyphicon glyphicon-home"></span> 首页</a> --%>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">

			<ul class="nav navbar-nav">
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="pageShift.action?req=register">注册</a></li>
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
					管理员登录
				</h1>
				<p>
					登录之后成为新世界的卡密
				</p>
			</div>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-8 column">
			<font color="white">
			<form class="form-horizontal" role="form" action="loginAdmin.action" method="post">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-4 control-label">用户名</label>
					<div class="col-sm-4">
						<input class="form-control"  id="admin_name" name="admin.a_name" onblur="check_username()"/>
					</div>
					
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-4 control-label">密码</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="admin.pwd" name="admin.a_psw"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-4 control-label">验证码</label>
						<div class="col-sm-4"> 
							<input class="form-control" id="verifyCode" name="verifyCode"/> 
							<img alt="验证码" src="createImage.action" title="点击更换" onclick="change(this);">
						</div>  
<!--             			<input type = "text" id = "input"/>     -->
            			 
<!--            			 	<input type = "button" value = "验证" onclick = "validate()"/>   -->
       			 
       			 </div>    
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
<!-- 							 <label><input type="checkbox" name="autologin" value="ok"/>记住我</label> -->
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-4">
						 <button type="submit" class="btn btn-default">登录</button>
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