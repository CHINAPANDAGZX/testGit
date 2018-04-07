/**
 * 
 */

//$(window).ready(testTable());//此处方法为正在加载，如果未能加载完成，则会出现ID、标签等无法找到

$(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
	search();
	useGetRequest();
})

var applyVerifyPersonID;
var applyVerifyPersonName;
var myDate = new Date();//获取系统当前时间

function search() {
//	alert('搜索函数启动');
	var applyPerson = document.getElementById("applyPerson").value;
	var verifyState = document.getElementById("verifyState").value;
	var applyDate_Begin = document.getElementById("applyDate_Begin").value;
	var applyDate_End = document.getElementById("applyDate_End").value;
//	alert('获得日期'+testDate);
//	alert('起始卡ID为：'+cardStart_ID+','+'起始卡ID为：'+cardStart_ID+','+'目标卡状态：'+cardState);
	
	$.ajax({
		type:"POST",
		url:"../CardSearch_Servlet?action=cardVerifySearch",
		data:"applyPerson=" + applyPerson + "&verifyState=" + verifyState + 
			 "&applyDate_Begin=" + applyDate_Begin + "&applyDate_End=" + applyDate_End,
		dataType:"text",
		async:true,	
		success: function(msg){
			//清空表格
			$("#myShowtab tr:not(:first)").html("");
			//写入数据
			var cardList = jQuery.parseJSON(msg);
//			var arrayList = JSON.parse(msg);
//			var arrayList = JSON.stringify(msg);
//			alert(msg);
			var tabNode = document.getElementById("myShowtab");
			var a = 1;
			for(var i=0;i<cardList.length;i++){
				var trNode = tabNode.insertRow();
				for(var j=0;j<10;j++){
					var tdNode = trNode.insertCell();
					if(j==0){
						tdNode.innerHTML = a++;
					}else if(j==1){
						tdNode.innerHTML = cardList[i].applyDate;//申请时间
					}else if(j==2){
						tdNode.innerHTML = cardList[i].applyPerson;//申请人
					}else if(j==3){
						tdNode.innerHTML = cardList[i].applyCardNumber;		//申请数量
					}else if(j==4){
						tdNode.innerHTML = cardList[i].applyVerifyPerson;	//审核人
					}else if(j==5){
						tdNode.innerHTML = cardList[i].applyVerifyDate;		//审核时间
					}else if(j==6){
						tdNode.innerHTML = cardList[i].applyVerifyState;	//申请状态
					}else if(j==7){
						var btnb = document.createElement("input");
						btnb.type = "button";
						btnb.id = "button"+i;
						btnb.value = "直接审批";
						btnb.onclick = function(){
							cardApply_Verify(this,cardList);
//							myDelete(this);
							
						}
						var btnb1 = document.createElement("input");
						btnb1.type = "button";
						btnb1.id = "button1"+i;
						btnb1.value = "弹窗审批";
						btnb1.onclick = function(){
//							getApplyID(this,cardList);
//							myDelete(this);
							
						}
//						<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">查看</button>	
						var btnb2 = document.createElement("input");
						btnb2.setAttribute('data-toggle',"modal");
						btnb2.setAttribute('data-target',"#myModal1");
						btnb2.type = "button";
						btnb2.id = "button2"+i;
						btnb2.value = "查看";
						btnb2.onclick = function(){
							updatemyModal1(this,cardList);
//							myDelete(this);
							
						}
						tdNode.appendChild(btnb);
//						tdNode.appendChild(btnb1);
//						tdNode.appendChild(btnb2);
					}
				}
			}
		}
	})
}


//截取从URL传来的参数
function GetRequest() {   
	   var url = location.search; //获取url中"?"符后的字串   
	   var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) {   
	         theRequest[strs[i].split("=")[0]]=decodeURI(strs[i].split("=")[1]);   
	      }   
	   }   
	   return theRequest;   
}  

//使用方法
function useGetRequest() {   
	var Request = new Object();
	Request = GetRequest();
//	var TEST1, TESTN;
//	TEST1 = Request["TEST1"];
//	TESTN = Request["TESTN"];
	var test = Request["userID"];
	var test2 = Request["userName"];
	applyVerifyPersonID = test;
	applyVerifyPersonName = test2;
//	alert("接收到传来的员工ID："+test+"接收到传来的员工名字："+test2);
//	alert("newApplyPersonID："+applyVerifyPersonID);
}


function getApplyID(buttonID,cardList){
//	alert("获取审批ID函数启动");
	var tdNode=$(buttonID).parent();
	var trNode=tdNode.parent();
	var idd=trNode.children().eq(0).html();
	var i = idd - 1;
	//获取点击的申请序号
	var applyID = cardList[i].applyID;
	//获取点击的申请卡数量
	var applyCardNumber = cardList[i].applyCardNumber;
//	alert("要审批的申请ID"+applyID);
	return [applyID,applyCardNumber];
	
	   
}


//提交申请卡表单审批
function cardApply_Verify(buttonID,cardList){
//	alert('提交申请卡表单审批函数运行');
	var applyID = getApplyID(buttonID,cardList)[0];
	var applyCardNumber = getApplyID(buttonID,cardList)[1];
	var newApplyVerifyPerson = applyVerifyPersonID;
//	var newApplyPerson = document.getElementById("newApplyPerson").value;
//	var verifyState = document.getElementById("verifyState").value;
//	var newApplyVerifyDate = document.getElementById("newApplyDate").value;

//	var newApplyVerifyDate = ""+myDate.getFullYear()+"-"+myDate.getMonth()+"-"+myDate.getDate();
//	alert(newApplyVerifyDate);
//	var newApplyVerifyCardNumber = document.getElementById("newApplyCardNumber").value;
//	alert('applyID:'+applyID+'newApplyVerifyPerson:'+newApplyVerifyPerson+',applyCardNumber:'+applyCardNumber);
	$.ajax({
		type:"POST",
//		url:"",
		url:"../CardImport_Servlet?action=update_ApplyVerify",
		data:"applyID=" + applyID + 
			 "&newApplyVerifyPerson=" + newApplyVerifyPerson + 
			 "&applyCardNumber=" + applyCardNumber,
		dataType:"text",
		async:true,	
		success: function(msg){
			if(msg == "true\r\n") {
		        //result就是servlet返回的数据
		        alert("提交审批成功");
		        search();
		    }else if(msg == "false\r\n") {
		        //result就是servlet返回的数据
		        alert("提交审批失败");
		    }
			
		}
	});
	
}
//更新查看按钮弹出来的模态框内容
function updatemyModal1(buttonID,cardList){
	var i = getApplyID(buttonID, cardList);
//	alert("要审批的申请ID" + applyID);
	var personNameNode = document.getElementById("modal_apply_personName");
	var DateNode = document.getElementById("modal_apply_Date");
	var cardNumberNode = document.getElementById("modal_apply_cardNumber");
	var verifyPerson = document.getElementById("modal_apply_VerifyPerson");
	var verifyDateNode = document.getElementById("modal_apply_VerifyDate");
	var cardIDNode = document.getElementById("modal_apply_cardID");
	
	personNameNode.innerHTML = cardList[i].applyPerson;		//申请人名
	DateNode.innerHTML = cardList[i].applyDate;		//申请日期
	cardNumberNode.innerHTML = cardList[i].applyCardNumber;		//申请数量
	verifyPerson.innerHTML = cardList[i].applyVerifyDate;		//审核人名
	verifyDateNode.innerHTML = cardList[i].applyVerifyDate;		//审核时间
	cardIDNode.innerHTML = cardList[i].applyVerifyDate;		//领用卡号
//	alert("更新完成");
}
function useHelp(){
	alert('使用帮助：\n 1、三个选择框都不操作，则默认查询所有数据\n 2、起始卡号都填写则按照卡号进行查询\n 3、选择卡状态则按照卡状态查询\n 4、都填写则将按照所有选择条件查询');
}

//执行一个laydate实例，日期控件用，非常重要,起始日期
laydate.render({
	elem : '#applyDate_Begin' //指定元素
});
//同上截止日期
laydate.render({
	elem : '#applyDate_End' //指定元素
});
