<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投诉信息</title>
</head>
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(function () {
		$.ajax({
			url:"/demoProject/ComplainInfoServlet?ajaxId=get",
			type:"post",
			success:function(result){
				var json = JSON.parse(result);
				var message = json.message;
				console.log(message);
				$.each(message,function(index,item){
					var tr = $("<tr></tr>");
					var complainNo = $("<td></td>").append(item.complainNo).appendTo(tr);
					var complainName = $("<td></td>").append(item.complainName).appendTo(tr);
					var complainTime = $("<td></td>").append(item.complainTime).appendTo(tr);
					var complainContent = $("<td></td>").append(item.complainContent).appendTo(tr);
					var btn1 = $("<button>修改</button>").attr({"complainNo":item.complainNo,"complainName":item.complainName,"complainTime":item.complainTime,
						"complainContent":item.complainContent}).addClass("update");
					var btn2 = $("<button>删除</button>").attr({"complainNo":item.complainNo}).addClass("delete");
					var td =$("<td></td>").append(btn1).append(btn2).appendTo(tr);
					tr.appendTo($("#complainMessage"));
					
				})
			}
			
		});
		
		$(document).on("click",".delete",function(){
			var complainNo = $(this).attr("complainNo");
			$.ajax({
				url:"/demoProject/ComplainInfoServlet?ajaxId=remove",
				type:"post",
				data:{
					"complainNo":complainNo
				},
				success:function(result){
					console.log(result);
				}
			})
		})
		
		$(document).on("click",".update", function() {
			var complainNo = $(this).attr("complainNo");
			$("#myModal").modal('show');
			$("#complainNo").val($(this).attr("complainNo"));
			$("#complainName").val($(this).attr("complainName"));
			$("#complainTime").val($(this).attr("complainTime"));
			$("#complainContent").val($(this).attr("complainContent"));			
		});
		
		$(document).on("click","#submitComplainMessage",function(){
			$.ajax({
				url:"/demoProject/ComplainInfoServlet?ajaxId=update",
				type:"post",
				data:
					$("#updateComplainMessage").serialize(),
				success:function(result){
					console.log(result);
				}
			})
		})
	})
</script>
<body>

<h1 align="center"><br></h1><h1 align="center">楼栋信息</h1>  
        <!-- 用于存放选择的id，然后会随表单提交给服务器处理页面 -->  
        <input type="hidden" name="id">  
        <table id="complainMessage" class="table table-hover">  
            <tr>  
                <td>  
                    <a href="addComplainMessage.jsp">添加新信息</a>  
                </td>  
            </tr>  
            <tr>  
                <th>投诉遍号</th>  
                <th>投诉人</th>  
                <th>投诉事件</th>  
                <th>投诉事件</th>            
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
             <form id="updateComplainMessage">
            <div class="modal-body">
            <input class="form-control" type="text" id="complainNo" name="complainNo"><br>
            <input class="form-control" type="text" id="complainName" name="complainName"><br>
            <input class="form-control" type="text" id="complainTime" name="complainTime"><br>
            <input class="form-control" type="text" id="complainContent" name="complainContent"><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="submitComplainMessage" data-dismiss="modal">提交更改</button>
            </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div> 
</body>
</html>