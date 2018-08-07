<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>车位信息</title>
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function () {
		$.ajax({
			url:"/demoProject/ParkingInfoServlet?ajaxId=get",
			type:"post",
			success:function(result){
				var json = JSON.parse(result);		
				var message = json.message;
				console.log(message);
				$.each(message,function(index,item){
					var tr = $("<tr></tr>");
					var parkingNo = $("<td></td>").append(item.parkingNo).appendTo(tr);
					var parkingArea = $("<td></td>").append(item.parkingArea).appendTo(tr);
					var userName = $("<td></td>").append(item.userName).appendTo(tr);
					var carType = $("<td></td>").append(item.carType).appendTo(tr);
					var carNumber = $("<td></td>").append(item.carNumber).appendTo(tr);
					var telPhone = $("<td></td>").append(item.telPhone).appendTo(tr);
					var btn1 = $("<button>修改</button>").attr({"parkingNo":item.parkingNo,"parkingArea":item.parkingArea,
						"userName":item.userName,"carType":item.carType,"carNumber":item.carNumber,"telPhone":item.telPhone}).addClass("update");
					var btn2 = $("<button>删除</button>").attr({"parkingNo":item.parkingNo}).addClass("delete");
					var td = $("<td></td>").append(btn1).append(btn2).appendTo(tr);
					tr.appendTo("#parkingMessage");
				})
			}
		});
		
		$(document).on("click",".delete",function(){
			var parkingNo = $(this).attr("parkingNo");
			$.ajax({
				url:"/demoProject/ParkingInfoServlet?ajaxId=remove",
				type:"post",
				data:{
					"parkingNo":parkingNo,
				},
				success: function (result) {
					console.log(result);
				}
			})
		});
		
		$(document).on("click",".update",function(){
			var parkingNo = $(this).attr("parkingNo");
			$("#myModal").modal('show');
			$("#parkingNo").val($(this).attr("parkingNo"));
			$("#parkingArea").val($(this).attr("parkingArea"));
			$("#userName").val($(this).attr("userName"));
			$("#carType").val($(this).attr("carType"));
			$("#carNumber").val($(this).attr("carNumber"));
			$("#telPhone").val($(this).attr("telPhone"));
		})
		$(document).on("click","#submitParkingMessage",function(){
			$.ajax({
				url:"/demoProject/ParkingInfoServlet?ajaxId=update",
				type:"post",
				data:
					$("#updateParkingMessage").serialize(),
				success: function (result) {
					console.log(result);
				}
			})
		})
	})
</script>
</head>
<body>
	<h1 align="center"><br></h1><h1 align="center">用户信息</h1>  
        <!-- 用于存放选择的id，然后会随表单提交给服务器处理页面 -->  
        <input type="hidden" name="id">  
        <table id="parkingMessage" class="table table-hover">  
            <tr>  
                <td>  
                    <a href="addParkingMessage.jsp">添加新信息</a>  
                </td>  
            </tr>  
            <tr>  
                <th>车位号</th>  
                <th>车位面积</th>  
                <th>用户名</th>  
                <th>车牌</th>  
                <th>车牌号</th>  
                <th>电话</th>                
                <th>操作</th>  
            </tr>             
        </table> 
        <!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改信息</h4>
            </div>
             <form id="updateParkingMessage">
            <div class="modal-body">
            <input class="form-control" type="text" id="parkingNo" name="parkingNo"><br>
            <input class="form-control" type="text" id="parkingArea" name="parkingArea"><br>
            <input class="form-control" type="text" id="userName" name="userName"><br>
            <input class="form-control" type="text" id="carType" name="carType"><br>
            <input class="form-control" type="text" id="carNumber" name="carNumber"><br>
            <input class="form-control" type="text" id="telPhone" name="telPhone"><br>            
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submitParkingMessage" data-dismiss="modal">提交更改</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 
</body>
</html>