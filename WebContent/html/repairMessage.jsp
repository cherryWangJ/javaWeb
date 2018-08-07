<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>报修信息</title>
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(function () {
		$.ajax({
			url:"/demoProject/RepairInfoServlet?ajaxId=get",
			type:"post",
			success: function (result) {
				var json = JSON.parse(result);
				var message = json.message;
				console.log(message);
				$.each(message,function(index,item){
					var tr = $("<tr></tr>");
					var repairNo = $("<td></td>").append(item.repairNo).appendTo(tr);
					var repairName = $("<td></td>").append(item.repairName).appendTo(tr);
					var buildNo = $("<td></td>").append(item.buildNo).appendTo(tr);
					var roomNo = $("<td></td>").append(item.roomNo).appendTo(tr);
					var repairTime = $("<td></td>").append(item.repairTime).appendTo(tr);
					var repairContent = $("<td></td>").append(item.repairContent).appendTo(tr);
					var btn1 = $("<button>修改</button>").attr({"repairNo":item.repairNo,"repairName":item.repairName,"buildNo":item.buildNo,
						"roomNo":item.roomNo,"repairTime":item.repairTime,"repairContent":item.repairContent}).addClass("update");
					var btn2= $("<button>删除</button>").attr({"repairNo":item.repairNo}).addClass("delete");
					var td =$("<td></td>").append(btn1).append(btn2).appendTo(tr);
					tr.appendTo($("#buildMessage"));
				})	
			}
		});
		
		$(document).on("click",".delete",function(){
			var repairNo = $(this).attr("repairNo");
			 $.ajax({
				url:"/demoProject/RepairInfoServlet?ajaxId=remove",
				type:"post",
				data:{
					"repairNo":repairNo
				},
			success: function (result) {
				console.log(result);
				}
			})
		})
		
		$(document).on("click",".update", function() {
			var repairNo = $(this).attr("repairNo");
			$("#myModal").modal('show');
			$("#repairNo").val($(this).attr("repairNo"));
			$("#repairName").val($(this).attr("repairName"));
			$("#buildNo").val($(this).attr("buildNo"));
			$("#roomNo").val($(this).attr("roomNo"));
			$("#repairTime").val($(this).attr("repairTime"));
			$("#repairContent").val($(this).attr("repairContent"));			
		});
		
		$(document).on("click","#submitMessage",function(){
			$.ajax({
				url:"/demoProject/BuildInfoServlet?ajaxId=update",
				type:"post",
				data:
					$("#updateRepairMessage").serialize(),
				success:function(result){
					console.log(result);
				}
			})
		})
	})
</script>
<body>
	<h1 align="center"><br></h1><h1 align="center">报修信息</h1>  
        <!-- 用于存放选择的id，然后会随表单提交给服务器处理页面 -->  
        <input type="hidden" name="id">  
        <table id="buildMessage" class="table table-hover">  
            <tr>  
                <td>  
                    <a href="addRepairMessage.jsp">添加新信息</a>  
                </td>  
            </tr>  
            <tr>  
                <th>报修编号</th>  
                <th>报修人</th>  
                <th>楼栋号</th>  
                <th>房间号</th>  
                <th>报修时间</th>
                <th>报修内容</th>            
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
             <form id="updateRepairMessage">
            <div class="modal-body">
            <input class="form-control" type="text" id="repairNo" name="repairNo"><br>
            <input class="form-control" type="text" id="repairName" name="repairName"><br>
            <input class="form-control" type="text" id="buildNo" name="buildNo"><br>
            <input class="form-control" type="text" id="roomNo" name="roomNo"><br>
            <input class="form-control" type="text" id="repairTime" name="repairTime"><br>
            <input class="form-control" type="text" id="repairContent" name="repairContent"><br>
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