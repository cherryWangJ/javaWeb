<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>收费信息</title>
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(function () {
		$.ajax({
			url:"/demoProject/ChargeInfoServlet?ajaxId=get",
			type:"post",
			success:function(result){
				var json = JSON.parse(result);
				var message = json.message;
				console.log(message);
				$.each(message,function(index,item){
					var tr = $("<tr></tr>");
					var chargeNo = $("<td></td>").append(item.chargeNo).appendTo(tr);
					var chargeName = $("<td></td>").append(item.chargeName).appendTo(tr);
					var chargeNumber = $("<td></td>").append(item.chargeNumber).appendTo(tr);
					var chargeUser = $("<td></td>").append(item.chargeUser).appendTo(tr);
					var chargeTime = $("<td></td>").append(item.chargeTime).appendTo(tr);
					var chargeContent = $("<td></td>").append(item.chargeContent).appendTo(tr);
					var btn1 = $("<button>修改</button>").attr({"chargeNo":item.chargeNo,"chargeName":item.chargeName,"chargeNumber":item.chargeNumber,
						"chargeUser":item.chargeUser,"chargeTime":item.chargeTime,"chargeContent":item.chargeContent}).addClass("update");
					var btn2 = $("<button>删除</button>").attr({"chargeNo":item.chargeNo}).addClass("delete");
					var td =$("<td></td>").append(btn1).append(btn2).appendTo(tr);
					tr.appendTo($("#chargeMessage"));

				})
			}
		});
		
		$(document).on("click",".delete",function(){
			var chargeNo = $(this).attr("chargeNo");
			$.ajax({
				url:"/demoProject/ChargeInfoServlet?ajaxId=remove",
				type:"post",
				data:{
					"chargeNo":chargeNo
				},
				success: function (result) {
					console.log(result);
				}
			})
		});
		
		$(document).on("click",".update",function(){
			var chargeNo = $(this).attr("chargeNo");
			$("#myModal").modal('show');
			$("#chargeNo").val($(this).attr("chargeNo"));
			$("#chargeName").val($(this).attr("chargeName"));
			$("#chargeNumber").val($(this).attr("chargeNumber"));
			$("#chargeUser").val($(this).attr("chargeUser"));
			$("#chargeTime").val($(this).attr("chargeTime"));
			$("#chargeContent").val($(this).attr("chargeContent"));
		});
		
		$(document).on("click","#submitMessage",function(){
			$.ajax({
				url:"/demoProject/ChargeInfoServlet?ajaxId=update",
				type:"post",
				data:
					$("#updateChargeMessage").serialize(),
				success:function(result){
					console.log(result);
				}
			})
		})
	})
</script>
<body>
	<h1 align="center"><br></h1><h1 align="center">收费信息</h1>  
        <!-- 用于存放选择的id，然后会随表单提交给服务器处理页面 -->  
        <input type="hidden" name="id">  
        <table id="chargeMessage" class="table table-hover">  
            <tr>  
                <td>  
                    <a href="addChargeMessage.jsp">添加新信息</a>  
                </td>  
            </tr>  
            <tr>  
                <th>费用编号</th>  
                <th>费用名称</th>  
                <th>费用数目</th>  
                <th>交费人</th>  
                <th>交费时间</th>
                <th>备注</th>            
                <th>操作</th>  
            </tr>             
        </table>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改信息</h4>
            </div>
             <form id="updateChargeMessage">
            <div class="modal-body">
            <input class="form-control" type="text" id="chargeNo" name="chargeNo"><br>
            <input class="form-control" type="text" id="chargeName" name="chargeName"><br>
            <input class="form-control" type="text" id="chargeNumber" name="chargeNumber"><br>
            <input class="form-control" type="text" id="chargeUser" name="chargeUser"><br>
            <input class="form-control" type="text" id="chargeTime" name="chargeTime"><br>
            <input class="form-control" type="text" id="chargeContent" name="chargeContent"><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submitMessage" data-dismiss="modal">提交更改</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>  
</body>
</html>