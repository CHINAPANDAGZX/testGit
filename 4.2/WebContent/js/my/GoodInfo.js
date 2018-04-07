/**
 * 
 */

function sub() {
//	alert('点击函数触发');
	$
			.ajax({
				dataType : "json", // 数据类型为json格式
				contentType : "application/x-www-form-urlencoded; charset=utf-8",
				type : "POST",
				url : "TestServlet2",
				statusCode : {
					404 : function() {
						alert('page not found');
					}
				},
				success : function(data, textStatus) {
//					alert('获取成功' + data);

					$("#sp")
							.html(
									"<table border='1'><tr><td>序号</td><td>姓名</td><td>年龄</td><td>自建1</td><td>自建2</td><td>自建3</td></tr>"
											+ "<tr><td>"
											+ data.data2[0].j0
											+ "</td><td>"
											+ data.data2[0].j1
											+ "</td><td>"
											+ data.data2[0].j2
											+ "</td>"
											+ "<tr><td>"
											+ data.data2[1].j0
											+ "</td><td>"
											+ data.data2[1].j1
											+ "</td><td>"
											+ data.data2[1].j2
											+ "</td></tr></table>");

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

					var json = data.data2;
					for(var i=0,l=json.length;i<l;i++){
						var j=0;
						for(var key in json[i]){
							myShowGoodlist2[i][j]=json[i][key];
							j=j+1;
						}
					}
					var bodyNode = document.getElementsByTagName("div")[1];
					var tbNode = document.createElement("table");
					tbNode.setAttribute("background", "blue");
					// tbNode.setAttribute("width","800px");
					// tbNode.setAttribute("height","500px");
					tbNode.setAttribute("border", "1px");

					for (var i = 0; i < 11; i++) {
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

			});
}
