<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>房间信息</title>
</head>
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () {
	$.ajax({
		url:"/demoProject/RoomInfoServlet?ajaxId=get",
		type:"post",
		success: function (result) {
			var json = JSON.parse(result);
			var message = json.message;
			console.log(message);
			$.each(message,function(index,item){
				var tr = $("<tr></tr>");
				var roomNo = $("<td></td>").append(item.roomNo).appendTo(tr);
				var userName = $("<td></td>").append(item.userName).appendTo(tr);
				var buildNo = $("<td></td>").append(item.buildNo).appendTo(tr);
				var roomArea = $("<td></td>").append(item.roomArea).appendTo(tr);
				var roomType = $("<td></td>").append(item.roomType).appendTo(tr);
				var btn1 = $("<button>修改</button>").attr({"roomNo":item.roomNo,"userName":item.userName,
					"buildNo":item.buildNo,"roomArea":item.roomArea,"roomType":item.roomType}).addClass("update");
				var btn2 = $("<button>删除</button>").attr({"roomNo":item.roomNo}).addClass("delete");
				var td = $("<td></td>").append(btn1).append(btn2).appendTo(tr);
				tr.appendTo($("#roomMessage"));
			})						
		}
	});
	
	$(document).on("click",".delete",function(){
		var roomNo = $(this).attr("roomNo");
		$.ajax({
			url:"/demoProject/RoomInfoServlet?ajaxId=remove",
			type:"post",
			data:{
				"roomNo":roomNo
			},
			success: function (result) {
				console.log(result);
			}
		})
	});
	
	$(document).on("click",".update",function(){
		var roomNo = $(this).attr("roomNo");
		$("#myModal").modal('show');
		$("#roomNo").val($(this).attr("roomNo"));
		$("#userName").val($(this).attr("userName"));
		$("#buildNo").val($(this).attr("buildNo"));
		$("#roomArea").val($(this).attr("roomArea"));
		$("#roomType").val($(this).attr("roomType"));		
	});
	
	$(document).on("click","#submitRoomMessage",function(){
		$.ajax({
			url:"/demoProject/RoomInfoServlet?ajaxId=update",
			type:"post",
			data:
				$("#updateRoomMessage").serialize(),
			success: function (result) {
				console.log(result);
			}
		})
	})
})
</script>
<body>
	<h1 align="center"><br></h1><h1 align="center">房间信息</h1>  
        <!-- 用于存放选择的id，然后会随表单提交给服务器处理页面 -->  
        <input type="hidden" name="id">  
        <table id="roomMessage" class="table table-hover">  
            <tr>  
                <td>  
                    <a href="addRoomMessage.jsp">添加新信息</a>  
                </td>  
            </tr>  
            <tr>  
                <th>房间号</th>  
                <th>用户名</th>  
                <th>楼栋号</th>  
                <th>面积</th>  
                <th>类型</th>                    
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
             <form id="updateRoomMessage">
            <div class="modal-body">
            <input class="form-control" type="text" id="roomNo" name="roomNo"><br>
            <input class="form-control" type="text" id="userName" name="userName"><br>
            <input class="form-control" type="text" id="buildNo" name="buildNo"><br>
            <input class="form-control" type="text" id="roomArea" name="roomArea"><br>
            <input class="form-control" type="text" id="roomType" name="roomType"><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submitRoomMessage" data-dismiss="modal">提交更改</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>