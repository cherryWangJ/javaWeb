<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	#container {
		width: 600px;
		height: 500px;
		float: none;  
    	display: block;  
    	margin-left: auto;  
    	margin-right: auto;  
	}
</style>
<title>添加信息</title>
</head>
<link type="text/css" rel="stylesheet" href="/demoProject/css/bootstrap.min.css">
<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript">  
    function myBack(){  
        //将浏览器导航为index.jsp,location.href属性可以更改当前浏览器地址栏的内容  
        location.href="index.jsp";  
        //window.location.href="index.jsp";  
    }
    
    function mySubmit() {
		$.ajax({
			url:"/demoProject/ComplainInfoServlet?ajaxId=post",
			type:"post",
			data: $("#addComplainMessage").serialize(),
			success: function (result) {
				console.log(result)
			}
		})
	}
</script>
<body>
	<h1 align="center">新增信息</h1>
	<div id="container"> 
    <form id="addComplainMessage"  class="form-horizontal">
      <div class="form-group">
    <label for="inputcomplainNo3" class="col-md-5 control-label">投诉编号</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputcomplainNo3" placeholder="complainNo" name="complainNo">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputcomplainName3" class="col-md-5 control-label">投诉人</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputcomplainName3" placeholder="complainName" name="complainName">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputcomplainTime3" class="col-md-5 control-label">投诉时间</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputcomplainTime3" placeholder="complainTime" name="complainTime">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputcomplainContent3" class="col-md-5 control-label">投诉描述</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputcomplainContent3" placeholder="complainContent" name="complainContent">
    </div>
  </div>
  
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
        <input class="btn btn-success" type="button" value="添加" onclick="mySubmit()">
        <input class="btn btn-success" type="button" value="返回"  onclick="myBack()">
        </form>
    </div>
</body>
</html>