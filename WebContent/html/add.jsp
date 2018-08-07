<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
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
    		url:"/demoProject/UserInfoServlet?ajaxId=post",
    		type:"post",
    		data:$("#addMessage").serialize(),
    		success:function(result){
    			console.log(result)
    		}
    		
    	})
	}
  </script>  
<body>
	<h1 align="center">新增信息</h1>
	<div id="container"> 
    <form id="addMessage"  class="form-horizontal">
      <div class="form-group">
    <label for="inputName3" class="col-md-5 control-label">用户名</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputName3" placeholder="userName" name="userName">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-md-5 control-label">密码</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputPassword3" placeholder="userPassword" name="userPassword">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputAge3" class="col-md-5 control-label">年龄</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputAge3" placeholder="Age" name="Age">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputbuildNo3" class="col-md-5 control-label">楼栋号</label>
    <div class="col-md-7">
      <select class="form-control" name="buildNo">
  <option>1</option>
  <option>2</option>
  <option>3</option>
  <option>4</option>
  <option>5</option>
  <option>6</option>
  <option>7</option>
  <option>8</option>
  <option>9</option>
  <option>10</option>
  
</select>
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputroomNo3" class="col-md-5 control-label">房间号</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputroomNo3" placeholder="roomNo" name="roomNo">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputtelPhone3" class="col-md-5 control-label">电话</label>
    <div class="col-md-7">
      <input type="text" class="form-control" id="inputtelPhone3" placeholder="telPhone" name="telPhone">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputuserOrAdmin3" class="col-md-5 control-label">类别</label>
    <div class="col-md-7">
      <select class="form-control" name="userOrAdmin">
  <option>用户</option>
  <option>管理员</option>
</select>
    </div>
  </div>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;		
        <input class="btn btn-success" type="button" value="添加" onclick="mySubmit()">                            
        <input class="btn btn-success" type="button" value="返回"  onclick="myBack()"> 
        <%-- <table align="center" width="50%">  
            <!-- 姓名 -->  
            <tr>  
                <td align="right" width="37%">用户名:</td>  
                <td align="left" width="25%"><input type="text" name="userName" ></td>   
                <td>  
                    <div id="name_msg" align="left"></div>  
                </td>  
            </tr>  
            <!-- 性别 -->  
            <tr>  
                <td align="right">密码:</td>  
                <td align="left" colspan="2"><input type="text" name="userPassword">
              
            </tr>  
            <!-- 年龄 -->  
            <tr>  
                <td align="right">年龄:</td>  
                <td align="left" colspan="2"><select name="Age">  
                <% for(int i=18;i<=50;i++){%>  
                    <option value="<%=i%>" ><%=i%></option>  
                <%} %>  
                </select></td>   
            </tr>  
            <!-- 爱好 -->  
            <tr>  
                <td align="right">楼栋号:</td>  
                <td align="left" colspan="2"><select name="buildNo">
                <% for(int i=1;i<=20;i++){%>  
                    <option value="<%=i%>" ><%=i%></option>  
                <%} %>
                </select>
                <div id="hobby_msg"></div>  
                </td>  
            </tr>  
            <!-- 城市 -->  
            <tr>  
                <td align="right" valign="middle">房间号:</td>
                <td align="left" colspan="2"><input type="text" name="roomNo">  
                
            </tr>  
            <!-- 描述 -->  
            <tr>  
                <td align="right" valign="middle">电话:</td>  
                <td align="left" colspan="2"><input type="text" name="telPhone"></td>  
            </tr>  
            <tr>  
                <td align="right">类别:</td>  
                <td align="left" colspan="2"><input type="radio" name="userOrAdmin" value="用户" checked="checked">用户
                <input type="radio" name="userOrAdmin" value="管理员" />管理员</td>   
            </tr>
            <!-- 按钮 -->  
            <tr>  
                <td align="center" colspan="3">  
                    <input type="button" value="添加" onclick="mySubmit()">  
                          
                    <input type="button" value="返回"  onclick="myBack()">  
                </td>  
            </tr>  
        </table> --%>  
    </form>
    </div>  
</body>
</html>