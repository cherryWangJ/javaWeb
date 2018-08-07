<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户首页</title>
<link type="text/css" rel="stylesheet" href="/demoProject/css/reset.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/userIndex.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/amazeui.min.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/amazeui.flat.css">

<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/demoProject/js/amazeui.min.js"></script>
</head>
<script type="text/javascript">
	$(function () {
		$("#submitUser").on("click",function(){
			var userName = $("#userName").val();
			$.ajax({
				url:"/demoProject/UserInfoServlet?ajaxId=find",
				type:"post",
				data:{
					"userName":userName
				},
				success:function(result){
					var json = JSON.parse(result);
					var message = json.message;
					console.log(message);
				}
			})
		})
	})
</script>
<body data-spy="scroll" data-target="#myScrollspy" data-offset="20">
<header>
	<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#"></a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">首页</a></li>
            <li><a href="#">用户查询</a></li>
            <li><a href="#">底部</a></li>
        </ul>
    </div>
    <button type="button" class="btn btn-success navbar-btn">退出</button>
    </div>
</nav>
</header>
<section>
<div id="Carousel">
<div id="leftCarousel">
	<div id="myCarousel" class="carousel slide">
    <!-- 轮播指标 -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>   
    <div class="carousel-inner">
        <div class="item active">
            <img src="/demoProject/image/1.jpg" alt="First slide">
        </div>
        <div class="item">
            <img src="/demoProject/image/2.jpg" alt="Second slide">
        </div>
        <div class="item">
            <img src="/demoProject/image/3.jpg" alt="Third slide">
        </div>
        <div class="item">
            <img src="/demoProject/image/4.jpg" alt="Fourth slide">
        </div>
        <div class="item">
            <img src="/demoProject/image/5.jpg" alt="Five slide">
        </div>
    </div>
</div>
</div>
<div id="rightNews">
<div id="newsContainer">
	<label id="newsTitle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;社区新闻</label>
	<hr>
	<div id="news">普福社区 党群心连心 入学咨询我帮您</div>
	<br>
	<div id="news">笕新社区 消防演练进幼儿园 萌娃体验火灾逃生</div>
	<br>
	<div id="news">常青苑社区 浓情五月天 感恩母亲节</div>
	<br>
	<div id="news">红五月社区 让爱的教育打开二胎家庭的幸福之门</div>
	<br>
	<a href="#" id="jumpNews">更多新闻>></a>
</div>
</div>
</div>
	<div class="container">
	<div class="row">
		<nav class="col-sm-3" id="myScrollspy">
			<div class="container-fluid"> 
			<div class="container-fluid"> 
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a href="#section1">用户信息</a></li>
				<li><a href="#section2">房屋信息</a></li>
				<li><a href="#section3">车位信息</a></li>
				<li><a href="#section4">报修</a></li>
				<li><a href="#section5">投诉</a></li>
				
			</ul>
			</div>	
			</div>		
		</nav>
		<div class="col-sm-9">
			<div id="section1" class="am-g">
			<br>
			<br>
			<br>    
				<div class="col-md-4">
				 <form class="navbar-form navbar-left" role="search">
            		<div class="form-group">
                <input type="text" class="form-control" placeholder="Search" name="userName" id="userName">
            </div>
            <button type="submit" id="submitUser" class="btn btn-success btn-submit">提交</button>
        </form>
				 </div>
  				 <div class="col-md-8">
  				 	<table class="am-table am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
    <thead>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>年龄</th>
             <th>楼栋号</th>
              <th>房间号</th>
               <th>电话</th>
                <th>类别</th>           
        </tr>
    </thead>
    <tbody>
    	<tr>
            <th>王坚</th>
            <th>1995</th>
            <th>22</th>
             <th>8</th>
              <th>810</th>
               <th>18827388464</th>
                <th>用户</th>           
        </tr>
    </tbody>
</table>
  				 </div>
			</div>
			<div id="section2"> 
				<br>
				<br>
				<br>    
  				 <div class="col-md-8">
  				 	<table class="am-table am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
    <thead>
        <tr>
            <th>房间号</th>
            <th>用户名</th>
            <th>楼栋号</th>
             <th>面积</th>
              <th>类型</th>                        
        </tr>
    </thead>
    <tbody>
    	<tr>
            <th>312</th>
            <th>li</th>
            <th>3</th>
             <th>100</th>
              <th>三室一厅</th>                        
        </tr>
    </tbody>  
</table>
  				 </div>
  				 <div class="col-md-4">
				 <form class="navbar-form navbar-left" role="search">
            		<div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-success btn-submit">提交</button>
        </form>
				 </div>				
			</div>        
			<div id="section3">         
				<br>
				<br>
				<br>    
				<div class="col-md-4">
				 <form class="navbar-form navbar-left" role="search">
            		<div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-success btn-submit">提交</button>
        </form>
				 </div>
  				 <div class="col-md-8">
  				 	<table class="am-table am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
    <thead>
        <tr>
            <th>收费名称</th>
            <th>金额</th>
            <th>交费人</th>
             <th>交费时间</th>
              <th>备注</th>            
        </tr>
    </thead>
    <tbody>
    	<tr>
            <th>水电</th>
            <th>100</th>
            <th>李四</th>
             <th>2018-02-05</th>
              <th>未交费</th>            
        </tr>
    </tbody>
</table>
  				 </div>
				
			</div>
			<div id="section4">
			<br>
			<form method="post" class="am-form">        
				<div id="repair">
				<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名：</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="用户名">
  						</div>
  					</div>
  					<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;楼栋号：</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="楼栋号">
  						</div>
  					</div>
  					<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;房间号：</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="房间号">
  						</div>
  					</div>
  					<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="时间">
  						</div>
  					</div>
  					<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="备注">
  						</div>
  					</div>
  					<br>
  					<button type="submit" class="am-btn am-btn-success am-btnSubmit">提交</button>
				</div>
			</form>
			</div>
			<div id="section5">         
				<br>
			<form method="post" class="am-form">        
				<div id="repair">
  					<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;投诉人</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="房间号">
  						</div>
  					</div>
  					<br>
  					<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="时间">
  						</div>
  					</div>
  					<br>
  					<div class="am-g">
					<div class="am-u-sm-3">
					<label for="userName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：</label>						
						</div>
  					<div class="am-u-sm-9">
  					<input class="am-form-field am-round" type="text" name="userName" id="userName" placeholder="备注">
  						</div>
  					</div>
  					<br>
  					<button type="submit" class="am-btn am-btn-success am-btnSubmit">提交</button>
				</div>
			</form>
			
			</div>      			
		</div>
	</div>
</div>
</section>
<footer>
版权归@王小坚所有
<button data-am-smooth-scroll class="am-btn am-btn-success am-round slidTop">滚动到顶部</button>
</footer>
</body>
</html>