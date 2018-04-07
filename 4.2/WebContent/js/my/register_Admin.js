//标记用户名是否被使用的全局变量
var flag_name = true;

//验证输入的用户名函数
function check_name(){
 	var name = $("#username").val();
//	var name = document.getElementById("user.name").value;
	//校验name是否为空
// 	alert(name);
	if(name == ""){
		$("#ename_msg").text("用户名不能为空!");
		return;
	}
	//异步检查是否重复
//	$.post("checkName.action",{
//		"ename" : name
//	},function(data){
//		//回调函数的参数就是返回info属性
//		var info = data;
//		//根据返回值设置提示信息
//		if(info.success){
//			//验证通过，设置提示信息
//			$("#ename_msg").text(info.message);
//		}else{
//			$("#ename_msg").text(info.message);
//		}
//	});
	$.ajax({
		type : "post",
		url : "4.2/checkName.action",//需要用来处理ajax请求的action,excuteAjax为处理的方法名，JsonAction为action名
		data : {//设置数据源
			"ename" : name
		//这里不要加","  不然会报错，而且根本不会提示错误地方
		},
		dataType : "json",//设置需要返回的数据类型
		success : function(data) {
			//回调函数的参数就是返回info属性
			var info = data;
			//根据返回值设置提示信息
			if(info.success){
				//验证通过，设置提示信息
				$("#ename_msg").text(info.message);
				 flag_name = true;
			}else{
				$("#ename_msg").text(info.message);
				flag_name = false;
			}
		},
		error : function() {
			alert("系统异常，请稍后重试！");
		}//这里不要加","
	});
}

//提交验证
function myFunction() {
	if(flag_name){
		return true;
	}else{
		alert("该用户名已经被使用！");
		return false;
	}
	
}