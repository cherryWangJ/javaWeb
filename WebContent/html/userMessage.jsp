<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户信息</title>
</head>
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function() {
	$.ajax({
		url:"/demoProject/UserInfoServlet?ajaxId=get",
		type:"POST",
		success:function(result){
			var json = JSON.parse(result);
			console.log(result);
			var message = json.message;
			$.each(message,function(index,item){
				var tr = $("<tr></tr>");
				var user_Id = $("<td></td>").append(item.user_Id).appendTo(tr);
				var userName = $("<td></td>").append(item.userName).appendTo(tr);
				var userPassword = $("<td></td>").append(item.userPassword).appendTo(tr);
				var age = $("<td></td>").append(item.age).appendTo(tr);
				var buildNo = $("<td></td>").append(item.buildNo).appendTo(tr);
				var roomNo = $("<td></td>").append(item.roomNo).appendTo(tr);
				var telPhone = $("<td></td>").append(item.telPhone).appendTo(tr);
				var userOrAdmin = $("<td></td>").append(item.userOrAdmin).appendTo(tr);
				var btn1 = $("<button>修改</button>").attr({"userId":item.user_Id,"userName":item.userName,"userPassword":item.userPassword,
					"age":item.age,"buildNo":item.buildNo,"roomNo":item.roomNo,"telPhone":item.telPhone,"userOrAdmin":item.userOrAdmin}).addClass("update");
				var btn2 = $("<button>删除</button>").attr({"userId":item.user_Id}).addClass("delete");
				var td =$("<td></td>").append(btn1).append(btn2).appendTo(tr);
				tr.appendTo($("#userMessage"));
			})
		}
	});
	
	$(document).on("click",".delete",function(){
		var userId = $(this).attr("userId");
		$.ajax({
			url:"/demoProject/UserInfoServlet?ajaxId=remove",
			type:"post",
			data:{
				"userId":userId
			},
			success: function(result) {
				console.log(result);
			}
		})
	});
	
	$(document).on("click",".update",function(){
		var userId = $(this).attr("userId");
		$("#myModal").modal('show');
		$("#userName").val($(this).attr("userName"));
		$("#userPassword").val($(this).attr("userPassword"));
		$("#age").val($(this).attr("age"));
		$("#buildNo").val($(this).attr("buildNo"));
		$("#roomNo").val($(this).attr("roomNo"));
		$("#telPhone").val($(this).attr("telPhone"));
		$("#userOrAdmin").val($(this).attr("userOrAdmin"));
		$("#userId").val($(this).attr("userId"));
		 
	})
	$(document).on("click","#submitMessage",function(){
		$.ajax({
			url:"/demoProject/UserInfoServlet?ajaxId=update",
			type:"post",
			data:
				$("#updateMessage").serialize(),
			success: function(result) {
				console.log(result);
			}
		})
	})
})
   </script>
<body>
	<h1 align="center"><br></h1><h1 align="center">用户信息</h1>  
        <!-- 用于存放选择的id，然后会随表单提交给服务器处理页面 -->  
        <input type="hidden" name="id">  
        <table id="userMessage" class="table table-hover">  
            <tr>  
                <td>  
                    <a href="add.jsp">添加新信息</a>  
                </td>  
            </tr>  
            <tr>  
                <th>编号</th>  
                <th>用户名</th>  
                <th>密码</th>  
                <th>年龄</th>  
                <th>楼栋号</th>  
                <th>房间号</th>  
                <th>电话</th>
                <th>类别</th>  
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
             <form id="updateMessage">
            <div class="modal-body">
            <input class="form-control" type="text" id="userName" name="userName"><br>
            <input class="form-control" type="text" id="userPassword" name="userPassword"><br>
            <input class="form-control" type="text" id="age" name="age"><br>
            <input class="form-control" type="text" id="buildNo" name="buildNo"><br>
            <input class="form-control" type="text" id="roomNo" name="roomNo"><br>
            <input class="form-control" type="text" id="telPhone" name="telPhone"><br>
            <input class="form-control" type="text" id="userOrAdmin" name="userOrAdmin"><br>
            <input class="form-control" type="text" id="userId" name="userId">            
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