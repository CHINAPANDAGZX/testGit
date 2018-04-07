/**
 * 
 */
 $(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
//        	createCode();
 })
 var code ; //在全局定义验证码    
 var checkCode = false; //验证码全局标志位变量
          


//function createCode() {
//	code = "";
//	var codeLength = 4;// 验证码的长度
//	var checkCode = document.getElementById("code");
//	var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
//			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
//			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');// 随机数
//	for (var i = 0; i < codeLength; i++) {// 循环操作
//		var index = Math.floor(Math.random() * 36);// 取得随机数的索引（0~35）
//		code += random[index];// 根据索引取得随机数加到code上
//	}
//	checkCode.value = code;// 把code值赋给验证码
//}
// 校验验证码
//function validate() {
//	var inputCode = document.getElementById("checkID").value.toUpperCase(); // 取得输入的验证码并转化为大写
//	if (inputCode.length <= 0) { // 若输入的验证码长度为0
//		alert("请输入验证码！"); // 则弹出请输入验证码
//	} else if (inputCode != code) { // 若输入的验证码与产生的验证码不一致时
//		alert("验证码输入错误！@_@"); // 则弹出验证码输入错误
//		createCode();// 刷新验证码
//		document.getElementById("checkID").value = "";// 清空文本框
//	} else { // 输入正确时
//	// alert("验证码正确!"); //则弹出验证码输入错误
//		checkCode = true;
//	}
//}  
//校验用户名是否为纯英文
function check_username() {
	var str = $("#user_name").val().trim();
	var re = /^[A-Za-z]{0,15}$/; 
	var result = null;
	var str_length = str.length;
	if((str_length==0)){
		alert("用户名不能为空！");
	}else{
		result =  re.test(str);
//		alert("result:"+result);
		if ( re.test(str))
			return true;
		else
			alert("用户名必须是长度在15以内的纯字母！");
	}
	return false;
}
    
       
        
// 提交/取消分配权限的函数
function login() {
// alert('提交/取消分配权限的函数触发');
// er_id; // 角色ID
// given_m_id; // 要赋予的权限菜单编号暂存
// ungiven_m_id; // 要取消的权限菜单编号暂存
// alert('申请员工ID为：'+newApplyPersonID);
// alert('得到的菜单ID为：'+m_id);
// var m_id;
//	var apply;
	var userID = document.getElementById("userID").value;
	var password = document.getElementById("password").value;
//	var checkID = document.getElementById("checkID").value;
	validate();
	if(checkCode){
		$.ajax({
			type:"POST",
			url:"../Login_Admin_Servlet",
			data:"userID=" + userID + 
					"&password=" + password,
			dataType:"text",
			async:true,	
			success: function(msg){
//				if(msg.trim() == 'true') {
//			        //result就是servlet返回的数据
//			        alert("登录成功");
//			    }else{
//			    	alert("登录失败");
//			    	
//			    }
			}
		});
	}
	
}