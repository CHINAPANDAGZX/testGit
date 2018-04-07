/**
 * 
 */

//$(window).ready(testTable());//此处方法为正在加载，如果未能加载完成，则会出现ID、标签等无法找到

$(function() {//此处方法为全部加载完成，能保证全部ID、标签等都能找到
	search() ;
})

function search() {
//	alert('点击函数触发');
	var card_ID = document.getElementById("Card_ID").value;
	var cardState = document.getElementById("CardState").value;
	var cardPerson = document.getElementById("CardPerson").value;

//	alert('起始卡ID为：'+cardStart_ID+','+'起始卡ID为：'+cardStart_ID+','+'目标卡状态：'+cardState);
	
	$.ajax({
		type:"POST",
		url:"../CardSearch_Servlet?action=cardSearchSearch",
		data:"card_ID=" + card_ID + "&cardState=" + cardState + 
			 "&cardPerson=" + cardPerson,
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
				for(var j=0;j<6;j++){
					var tdNode = trNode.insertCell();
					if(j==0){
						tdNode.innerHTML = a++;
					}else if(j==1){
						tdNode.innerHTML = cardList[i].card_ID;//卡号
					}else if(j==2){
						tdNode.innerHTML = cardList[i].card_State;//卡状态
					}else if(j==3){
						tdNode.innerHTML = cardList[i].card_TakePerson;		//本卡领用人
					}else if(j==4){
						tdNode.innerHTML = cardList[i].patient_Name;       	//病人名字
					}else if(j==5){
						var btnb = document.createElement("input");
						btnb.type = "button";
						btnb.value = "删除";
						btnb.onclick = function(){
							myDelete(this);
						}
						tdNode.appendChild(btnb);
					}
				}
			}
		}
	})
}

function sub() {
//	alert('点击函数触发');
	var cardStart_ID = document.getElementById("CardStart_ID").value;
//	alert('起始卡ID为：'+cardStart_ID);
	$
			.ajax({
				dataType:"text", // 数据类型为json格式
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				type : "POST",
				url : "../CardSearch_Servlet?action=cardCancelSearch",
				statusCode : {
					404 : function() {
						alert('page not found');
					}
				},
				success: function(msg){
//					alert('获取成功' + data);
//		 data.data2[0].j1
					
					//清空表格
					$("#tab tr:not(:first)").html("");
					//写入数据
					var cardList = jQuery.parseJSON(msg);
//					alert(msg);
//					var bodyNode = document.getElementById("myShow");
//					var tabNode = document.createElement("table");
					var tabNode = document.getElementById("myShowtab");
					var a = 1;
					for(var i=0;i<cardList.length;i++){
						var trNode = tabNode.insertRow();
						for(var j=0;j<5;j++){
							var tdNode = trNode.insertCell();
							if(j==0){
								tdNode.innerHTML = a++;
							}else if(j==1){
								tdNode.innerHTML = cardList[i].eCard_ID;
							}else if(j==2){
								tdNode.innerHTML = cardList[i].import_Date;
							}else if(j==3){
								tdNode.innerHTML = cardList[i].eCard_State_Name;
							}else if(j==4){
								var btnb = document.createElement("input");
								btnb.type = "button";
								btnb.value = "删除";
								btnb.onclick = function(){
									myDelete(this);
								}
								tdNode.appendChild(btnb);
							}
						}
					}
//					bodyNode.appendChild(tabNode);
					
				}
			});
}

//覆盖表单提交提交批量入库的操作
function batImportCard(){
//	alert('插入函数运行');
	$.ajax({
		type:"POST",
		url:"../loginServlet?action=insert_Card",
		data:$('#form1').serialize(),
		dataType:"text",
		async:true,	
		success: function(msg){
			if(msg == '批量入库成功') {
		        //result就是servlet返回的数据
		        alert("批量入库成功");
		    }
			
		}
	})
}
//带返回指令的批量插入函数
function batImportCard_CallBack(){
	$.post("../loginServlet?action=insert_Card"+goodsID, function(result){
	    if(result == 'Y') {
	        //result就是servlet返回的数据
	        alert("删除成功");
	    }
	 },"text");//可根据需要选用不同数据类型
}


function testTable() {
//	alert('测试显示表格函数触发');
					var myShowGoodlistTitle2 = [ "选择", "编号", "商品名", "起拍价",
							"所属分类", "拍卖状态", "操作" ];
					var myShowGoodlistTitle = [ "选择", "编号", "商品名称", "商品二级分类编号",
							"商品图片", "商品描述", "商品状态", "起拍价", "结束价", "当前价格" ];
					var myShowGoodlist2 = [
							[ 1, "商品1", 5, "测试类", "竞拍中", "购买" ],
							[ 2, "商品2", 5, "测试类", "竞拍中", "购买" ],
							[ 3, "商品3", 5, "测试类", "竞拍中", "购买" ],
							[ 4, "商品4", 5, "测试类", "竞拍中", "购买" ],
							[ 5, "商品5", 5, "测试类", "竞拍中", "购买" ],
							[ 6, "商品6", 5, "测试类", "竞拍中", "购买" ],
							[ 7, "商品7", 5, "测试类", "竞拍中", "购买" ],
							[ 8, "商品8", 5, "测试类", "竞拍中", "购买" ],
							[ 9, "商品9", 5, "测试类", "竞拍中", "购买" ],
							[ 10, "商品10", 5, "测试类", "竞拍中", "购买" ] ];
				
//					var bodyNode = document.getElementsByTagName("div")[1];
					var bodyNode = document.getElementById("myShow");
					var tbNode = document.createElement("table");
					tbNode.setAttribute("background", "blue");
					// tbNode.setAttribute("width","800px");
					// tbNode.setAttribute("height","500px");
					tbNode.setAttribute("border", "1px");

					for (var i = 0; i < myShowGoodlist2.length+1; i++) {
						var trNode = document.createElement("tr");

						trNode.setAttribute("height", "30px");
						trNode.setAttribute("width", "80px");
						trNode.setAttribute("border", "1px");
						if ((i % 2) == 0) {
							trNode.setAttribute("bgcolor", "80FFFF");
						} else {
							trNode.setAttribute("bgcolor", "66B3FF");
						}

						for (var j = 0; j < 10; j++) {
							if (i == 0) {// 添加表头
								var tdNode = document.createElement("td");
								tdNode.setAttribute("width", "120px");
								var textNode = document
										.createTextNode(myShowGoodlistTitle[j]);
								tdNode.appendChild(textNode);
							} else {// 添加标的内容
								var tdNode = document.createElement("td");
								tdNode.setAttribute("width", "120px");
								if (j == 0) {// 创建表格第一列的勾选框
									var checkNode = document
											.createElement("input");
									checkNode.type = "checkbox";
									checkNode.name = "check";
									tdNode.appendChild(checkNode);
								} else {
									var textNode = document
											.createTextNode(myShowGoodlist2[i - 1][j - 1]);
									tdNode.appendChild(textNode);
								}
							}
							trNode.appendChild(tdNode);
						}
						tbNode.appendChild(trNode);
					}
					bodyNode.appendChild(tbNode);

		
}

function del(){
    var input=document.getElementsByTagName("input");
        for(var i=input.length-1; i>=0;i--){
            if(input[i].checked==true){
                //获取td节点
                var td=input[i].parentNode;
                //获取tr节点
                var tr=td.parentNode;
                //获取table
                var table=tr.parentNode;
                //获取tr节点的商品ID号码
                var goodsID = table.rows[i+1].cells[1].innerHTML;
//                alert('删除商品ID为：'+goodsID);
                //将获取到的商品ID排成列表
//                var dArray = new Array();
//                dArray.
                //向后端Servlet传送参数
                $.get("../Goods_Delete_Servlet?goodsID="+goodsID, function(result){
                    if(result == 'Y') {
                        //result就是servlet返回的数据
//                        alert("删除成功");
                    }
                 },"text");//可根据需要选用不同数据类型
                //移除子节点
                table.removeChild(tr);
            }       
        }
}
//创建全选反选函数
function xuanze(type){
    //获取name值
    // var qcheck=document.getElementsByTagName("input");
    var qcheck=document.getElementsByName("check");
    //获取选的按钮
    //全选
    if(type=="qx"){
        for(var i=0;i<=qcheck.length;i++){
            qcheck[i].checked=true;
        }
    }
    //全不选
    if(type=="qbx"){
        for(var i=0;i<=qcheck.length;i++){
        qcheck[i].checked=false;
    	}
    }
    //反选      
    if(type=="fx"){
        for(var i=0;i<=qcheck.length;i++){
            if(qcheck[i].checked){
           		qcheck[i].checked=false;
            }
            else{
            	qcheck[i].checked=true;
            }
        }
    }
}

function useHelp(){
	alert('使用帮助：\n 1、三个选择框都不操作，则默认查询所有数据\n 2、起始卡号都填写则按照卡号进行查询\n 3、选择卡状态则按照卡状态查询\n 4、都填写则将按照所有选择条件查询');
}