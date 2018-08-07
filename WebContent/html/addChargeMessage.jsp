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
<title>添加新信息</title>
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
			url:"/demoProject/ChargeInfoServlet?ajaxId=post",
			type:"post",
			data:$("#addChargeMessage").serialize(),
			success: function (result) {
				console.log(result);
			}
			
		})
	}
</script>
<body>
	<h1 align="center">新增信息</h1>
	<div id="container"> 
    <form id="addChargeMessage"  class="form-horizontal">
    
    <div class="form-group">
    <label for="inputchargeNo3" class="col-md-5 control-label">费用编号</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputchargeNo3" placeholder="chargeNo" name="chargeNo">
    </div>
  </div>
  
      <div class="form-group">
    <label for="inputchargeName3" class="col-md-5 control-label">费用名称</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputchargeName3" placeholder="chargeName" name="chargeName">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputchargeNumber3" class="col-md-5 control-label">费用数目</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputchargeNumber3" placeholder="chargeNumber" name="chargeNumber">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputchargeUser3" class="col-md-5 control-label">交费人</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputchargeUser3" placeholder="chargeUser" name="chargeUser">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputchargeTime3" class="col-md-5 control-label">交费时间</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputchargeTime3" placeholder="chargeTime" name="chargeTime">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputchargeContent3" class="col-md-5 control-label">备注</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputchargeContent3" placeholder="chargeContent" name="chargeContent">
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