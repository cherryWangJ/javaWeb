<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>楼栋信息</title>
<style type="text/css">
	#buildMessage {
		margin: 0 auto;
	}
</style>
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		$.ajax({
			url:"/demoProject/BuildInfoServlet?ajaxId=get",
			type:"post",
			success:function(result){
				var json = JSON.parse(result);
				var message = json.message;
				$.each(message,function(index,item) {
					var tr = $("<tr></tr>");
					var buildNo = $("<td></td>").append(item.buildNo).appendTo(tr);
					var buildHeight = $("<td></td>").append(item.buildHeight).appendTo(tr);
					var buildArea = $("<td></td>").append(item.buildArea).appendTo(tr);
					var buildTime = $("<td></td>").append(item.buildTime).appendTo(tr);
					var buildType = $("<td></td>").append(item.buildType).appendTo(tr);
					var btn1 = $("<button>修改</button>").attr({"buildNo":item.buildNo,"buildHeight":item.buildHeight,"buildArea":item.buildArea,
						"buildTime":item.buildTime,"buildType":item.buildType}).addClass("update");
					var btn2 = $("<button>删除</button>").attr({"buildNo":item.buildNo}).addClass("delete");
					var td =$("<td></td>").append(btn1).append(btn2).appendTo(tr);
					tr.appendTo($("#buildMessage"));
				})								
			}
		});
		
		$(document).on("click",".delete",function(){
			var buildNo = $(this).attr("buildNo");
			 $.ajax({
				url:"/demoProject/BuildInfoServlet?ajaxId=remove",
				type:"post",
				data:{
					"buildNo" : buildNo
				},
				success: function(result) {
					console.log(result);
				}
			}) 
		});
		
		$(document).on("click",".update", function() {
			var buildNo = $(this).attr("buildNo");
			$("#myModal").modal('show');
			$("#buildNo").val($(this).attr("buildNo"));
			$("#buildHeight").val($(this).attr("buildHeight"));
			$("#buildArea").val($(this).attr("buildArea"));
			$("#buildTime").val($(this).attr("buildTime"));
			$("#buildType").val($(this).attr("buildType"));
			
		});
		
		$(document).on("click","#submitMessage",function(){
			$.ajax({
				url:"/demoProject/BuildInfoServlet?ajaxId=update",
				type:"post",
				data:
					$("#updateBuildMessage").serialize(),
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
        <table id="buildMessage" class="table table-hover">  
            <tr>  
                <td>  
                    <a href="addBuildMessage.jsp">添加新信息</a>  
                </td>  
            </tr>  
            <tr>  
                <th>楼栋号</th>  
                <th>楼栋高度</th>  
                <th>楼栋面积</th>  
                <th>建成时间</th>  
                <th>楼栋类型</th>            
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
             <form id="updateBuildMessage">
            <div class="modal-body">
            <input class="form-control" type="text" id="buildNo" name="buildNo"><br>
            <input class="form-control" type="text" id="buildHeight" name="buildHeight"><br>
            <input class="form-control" type="text" id="buildArea" name="buildArea"><br>
            <input class="form-control" type="text" id="buildTime" name="buildTime"><br>
            <input class="form-control" type="text" id="buildType" name="buildType"><br>
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