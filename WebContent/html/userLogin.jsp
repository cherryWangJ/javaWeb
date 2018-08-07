<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<link type="text/css" rel="stylesheet" href="/demoProject/css/reset.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/userLogin.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/amazeui.min.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/amazeui.flat.css">

<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/demoProject/js/amazeui.min.js"></script>
</head>
<script type="text/javascript">
	$(function () {
		$("#submitLogin").on("click",function(){
			var userName = $("#userName").val();
			var userPassword = $("#userPassword").val();
		$.ajax({
			url:"/demoProject/UserLogin",
			type:"post",
			data:{
				"userName" : userName,
				"userPassword":userPassword
			},
			success:function(result){
				console.log(result);
			}
		})
		})
	})
</script>
<body>
<div id="container">
<div id="loginBox">
<header>
	<br>
	<hr>
	<h3>登	录</h3>
	<br>
	<br>
</header>
<section>
	<form method="post" class="am-form">
	<div class="am-g">
      <div class="am-u-sm-3"><label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名</label></div>
      <div class="am-u-sm-9"><input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="用户名"></div>
      </div>
      <br>
      <br>
      <div class="am-g">
      <div  class="am-u-sm-3"><label for="userPassword">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码</label></div>
      <div class="am-u-sm-9"><input class="am-form-field am-round" type="password" name="userPassword" id="userPassword" placeholder="密码"></div>
      </div>
      <br>
      <br>
      <div class="am-cf">
       <input type="submit" name="submit" id="submitLogin" value="登 录" class="am-btn am-btn-success am-round  am-btn-sm am-fl">
      </div>
    </form>

</section>
<footer></footer>
</div>
</div>
</body>
</html>