<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加信息</title>
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
    //mySubmit方法用于提交表单，并且在提交之前验证表单数据的格式是否符合要求  
    function mySubmit() {
 		$.ajax({
    		url:"/demoProject/ParkingInfoServlet?ajaxId=post",
    		type:"post",
    		data:$("#addParkingMessage").serialize(),
    		success:function(result){
    			console.log(result)
    		}
    		
    	})
	}
  </script>
<body>
	<h1 align="center">新增信息</h1>
	<div id="container"> 
    <form id="addParkingMessage"  class="form-horizontal">
      <div class="form-group">
    <label for="inputparkingNo3" class="col-md-5 control-label">车位号</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputparkingNo3" placeholder="parkingNo" name="parkingNo">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputparkingArea3" class="col-md-5 control-label">面积</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputparkingArea3" placeholder="parkingArea" name="parkingArea">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputuserName3" class="col-md-5 control-label">用户名</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputuserName3" placeholder="userName" name="userName">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputcarType3" class="col-md-5 control-label">车牌</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputcarType3" placeholder="carType" name="carType">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputcarNumber3" class="col-md-5 control-label">车牌号</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputcarNumber3" placeholder="carNumber" name="carNumber">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputtelPhone3" class="col-md-5 control-label">电话</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputtelPhone3" placeholder="telPhone" name="telPhone">
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