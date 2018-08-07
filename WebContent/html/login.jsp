<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录注册</title>
<link type="text/css" rel="stylesheet" href="/demoProject/css/reset.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/login.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/bootstrap.min.css">

<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#submit1").on("click",function(){
		var adminName1 = $("#adminName1").val();
		var passWord1 = $("#passWord1").val();
		$.ajax({
			url:"/demoProject/login",
			type:"post",
			data:{
				"adminName1" : adminName1,
				"passWord1" : passWord1
			},
			success: function(result) {
				console.log(result);
				if(result == 'ok'){
					alert('登录成功');
					setTimeout(function() {
						window.location.href="index.jsp";
					}, 1000);
				}
				else {
					alert()
				}
			}
		})
	})
	$("#adminName").blur(function() {
		var adminName = $("adminName").val();
		$.ajax({
			url:"/demoProject/Ajax",
			type:"post",
			data:{
				"adminName":adminName
			},
			success: function(result) {
				$("#checkName").html(result);
			}
		})
	})
	$("#submit").on("click",function(){
		var adminName = $("#adminName").val();
		var passWord = $("#passWord").val();
		 $.ajax({
			url:"/demoProject/register",
			type:"post",
			data:{
				"adminName" : adminName,
				"passWord" : passWord		
			},
			success: function(result) {
				console.log(result);
				if(result =="ok"){
				alert("注册成功!");
				setTimeout(function (){
					window.location.reload();
				}, 1000);
			  }
				else{
					alert("注册失败，请重新注册!");
				}
			}
		})
	})
})
</script>
</head>
<body>
<section id="container">
	<div id="loginRegister">
		<div id="checkBox">
<ul id="myTab" class="nav nav-tabs">
	<li class="active">
		<a href="#login" data-toggle="tab">登录</a>
	</li>
	<li>
		<a href="#register" data-toggle="tab">注册</a>
	</li>
</ul>
<div id="myTabContent" class="tab-content">
	<div class="tab-pane fade in active" id="login"> 
		<div class="form-group">
    <label for="inputEmail3" class="col-md-4 control-label">用户名:</label>
    <div class="col-md-8">
      <input id="adminName1" class="form-control" placeholder=" userName">
    </div>
    </div>
  <br><br><br>
   <div class="form-group">
    <label for="inputPassword3" class="col-md-4 control-label">密    码:</label>
    <div class="col-md-8">
      <input id="passWord1" type="password" class="form-control"  placeholder=" passWord">
    </div>
  </div>
  <br><br><br>
  <div class="form-group">
    <div class="col-sm-offset-4 col-md-8">
      <button type="submit" class="btn btn-default" id="submit1">登   录</button>
    </div>
  </div>
		</div>
	<div class="tab-pane fade" id="register">
		<div class="form-group">
    <label for="inputEmail3" class="col-md-4 control-label">用户名:</label>
    <div class="col-md-8">
      <input type="text" class="form-control" id="adminName" placeholder=" userName">
      <span id="checkName"></span>
    </div>
  </div>
  <br><br><br>
   <div class="form-group">
    <label for="inputPassword3" class="col-md-4 control-label">密    码:</label>
    <div class="col-md-8">
      <input type="password" class="form-control" id="passWord" placeholder=" passWord">
    </div>
  </div>
  <br><br><br>
  <div class="form-group">
    <div class="col-sm-offset-4 col-md-8">
      <button id="submit" type="submit" class="btn btn-default">注   册</button>
    </div>
  </div>
		</div>
</div>
	</div>
		</div>
</section>
</body>
</html>