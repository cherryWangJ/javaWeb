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
			url:"/demoProject/BuildInfoServlet?ajaxId=post",
			type:"post",
			data:$("#addBuildMessage").serialize(),
    		success:function(result){
    			console.log(result);
    		}
		})
	}
</script>
<body>
<h1 align="center">新增信息</h1>
	<div id="container"> 
    <form id="addBuildMessage"  class="form-horizontal">
      <div class="form-group">
    <label for="inputbuildNo3" class="col-md-5 control-label">楼栋号</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputbuildNo3" placeholder="buildNo" name="buildNo">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputbuildHeight3" class="col-md-5 control-label">楼栋高度</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputbuildHeight3" placeholder="buildHeight" name="buildHeight">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputbuildArea3" class="col-md-5 control-label">建筑面积</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputbuildArea3" placeholder="buildArea" name="buildArea">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputbuildTime3" class="col-md-5 control-label">建成时间</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputbuildTime3" placeholder="buildTime" name="buildTime">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputtelbuildType3" class="col-md-5 control-label">类别</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputtelbuildType3" placeholder="buildType" name="buildType">
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