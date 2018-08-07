<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台管理系统</title>
<link type="text/css" rel="stylesheet" href="/demoProject/css/reset.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/font-awesome.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/font-change.css">
<link type="text/css" rel="stylesheet" href="/demoProject/css/test.css">

<script type="text/javascript" src="/demoProject/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/demoProject/js/bootstrap.min.js"></script>
</head>
<body>
<header id="header">
	<nav class="navbar navbar-inverse navbar-fixed-top">
              <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" >
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                      <a class="navbar-brand" href="">山水名都欢迎您！</a>
                </div>                            
              </div>
        </nav>
</header>
<div id="bodySection">
<section id="leftSection">
	<div class="container-fluid">
            <div class="row-fluie">
                <div class="col-sm-3 col-md-2 sidebar">        
                    <ul class="nav nav-sidebar">
                        <!-- 一级菜单 -->
                        <li class="active"><a href="#userMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                            <i class="fa fa-user"></i>&nbsp; 用户信息管理 <span class="sr-only">(current)</span></a>
                        </li> 
                        <!-- 二级菜单 -->
                        <!-- 注意一级菜单中<a>标签内的href="#……"里面的内容要与二级菜单中<ul>标签内的id="……"里面的内容一致 -->
                        <ul id="userMeun" class="nav nav-list collapse menu-second">
                            <li><a href="###" onclick="showAtRight('userMessage.jsp')"><i class="fa fa-users"></i> 用户信息</a></li>
                        </ul>
                         
                        <li><a href="#buildMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                            <i class="fa fa-globe"></i>&nbsp; 楼栋信息管理 <span class="sr-only">(current)</span></a>
                        </li> 
                        <ul id="buildMeun" class="nav nav-list collapse menu-second">
                            <li><a href="###" onclick="showAtRight('buildMessage.jsp')"><i class="fa fa-list-alt"></i> 楼栋信息</a></li>
                        </ul>
                        
                        <li><a href="#roomMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                            <i class="fa fa-file-text"></i>&nbsp; 房屋信息管理 <span class="sr-only">(current)</span></a>
                        </li> 
                        <ul id="roomMeun" class="nav nav-list collapse menu-second">
                            <li><a href="###" onclick="showAtRight('roomMessage.jsp')" ><i class="fa fa-list"></i> 房屋信息</a></li>
                        </ul>
                        
                        <li><a href="#parkingMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                            <i class="fa fa-file-text"></i>&nbsp; 停车信息管理 <span class="sr-only">(current)</span></a>
                        </li> 
                        <ul id="parkingMeun" class="nav nav-list collapse menu-second">
                            <li><a href="###" onclick="showAtRight('parkingMessage.jsp')" ><i class="fa fa-list"></i> 车位信息</a></li>
                        </ul> 
                        
                        <li><a href="#chargeMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                            <i class="fa fa-file-text"></i>&nbsp; 收费信息管理 <span class="sr-only">(current)</span></a>
                        </li> 
                        <ul id="chargeMeun" class="nav nav-list collapse menu-second">
                            <li><a href="###" onclick="showAtRight('chargeMessage.jsp')" ><i class="fa fa-list"></i> 收费信息</a></li>
                        </ul>
                        
                         <li><a href="#repairMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                            <i class="fa fa-file-text"></i>&nbsp; 报修信息管理 <span class="sr-only">(current)</span></a>
                        </li> 
                        <ul id="repairMeun" class="nav nav-list collapse menu-second">
                            <li><a href="###" onclick="showAtRight('repairMessage.jsp')" ><i class="fa fa-list"></i> 报修信息</a></li>
                        </ul> 
                        
                        <li><a href="#complainMeun" class="nav-header menu-first collapsed" data-toggle="collapse">
                            <i class="fa fa-file-text"></i>&nbsp; 投诉信息管理 <span class="sr-only">(current)</span></a>
                        </li> 
                        <ul id="complainMeun" class="nav nav-list collapse menu-second">
                            <li><a href="###" onclick="showAtRight('complainMessage.jsp')" ><i class="fa fa-list"></i> 投诉信息</a></li>
                        </ul>                        
                    </ul>                    
                </div>
            </div>
        </div>
</section>
<section id="rightSection">
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                    <h2 class="page-header"><i class="fa fa-cog fa-spin"></i>&nbsp;后台
                    <small>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎使用山水名都信息后台管理系统</small></h2>
                        
                        <!-- 载入左侧菜单指向的jsp（或html等）页面内容 -->
                          <div id="content">
               
                               <h4>                    
                                   我是控制台首页
                               </h4>                                 
                              
                          </div>  
                </div> 
</section>
</div>

<script type="text/javascript">
        
        /*
         * 对选中的标签激活active状态，对先前处于active状态但之后未被选中的标签取消active
         * （实现左侧菜单中的标签点击后变色的效果）
         */
        $(document).ready(function () {
            $('ul.nav > li').click(function (e) {
                //e.preventDefault();    加上这句则导航的<a>标签会失效
                $('ul.nav > li').removeClass('active');
                $(this).addClass('active');
            });
        });
        
        /*
         * 解决ajax返回的页面中含有javascript的办法：
         * 把xmlHttp.responseText中的脚本都抽取出来，不管AJAX加载的HTML包含多少个脚本块，我们对找出来的脚本块都调用eval方法执行它即可
         */
        function executeScript(html)
        {
            
            var reg = /<script[^>]*>([^\x00]+)$/i;
            //对整段HTML片段按<\/script>拆分
            var htmlBlock = html.split("<\/script>");
            for (var i in htmlBlock) 
            {
                var blocks;//匹配正则表达式的内容数组，blocks[1]就是真正的一段脚本内容，因为前面reg定义我们用了括号进行了捕获分组
                if (blocks = htmlBlock[i].match(reg)) 
                {
                    //清除可能存在的注释标记，对于注释结尾-->可以忽略处理，eval一样能正常工作
                    var code = blocks[1].replace(/<!--/, '');
                    try 
                    {
                        eval(code) //执行脚本
                    } 
                    catch (e) 
                    {
                    }
                }
            }
        }
        
        /*
         * 利用div实现左边点击右边显示的效果（以id="content"的div进行内容展示）
         * 注意：
         *   ①：js获取网页的地址，是根据当前网页来相对获取的，不会识别根目录；
         *   ②：如果右边加载的内容显示页里面有css，必须放在主页（即例中的index.jsp）才起作用
         *   （如果单纯的两个页面之间include，子页面的css和js在子页面是可以执行的。 主页面也可以调用子页面的js。但这时要考虑页面中js和渲染的先后顺序 ）
        */
        function showAtRight(url) {
            var xmlHttp;
            
            if (window.XMLHttpRequest) {
                // code for IE7+, Firefox, Chrome, Opera, Safari
                xmlHttp=new XMLHttpRequest();    //创建 XMLHttpRequest对象
            }
            else {
                // code for IE6, IE5
                xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
        
            xmlHttp.onreadystatechange=function() {        
                //onreadystatechange — 当readystate变化时调用后面的方法
                
                if (xmlHttp.readyState == 4) {
                    //xmlHttp.readyState == 4    ——    finished downloading response
                    
                    if (xmlHttp.status == 200) {
                        //xmlHttp.status == 200        ——    服务器反馈正常            
                        
                        document.getElementById("content").innerHTML=xmlHttp.responseText;    //重设页面中id="content"的div里的内容
                        executeScript(xmlHttp.responseText);    //执行从服务器返回的页面内容里包含的JavaScript函数
                    }
                    //错误状态处理
                    else if (xmlHttp.status == 404){
                        alert("出错了☹   （错误代码：404 Not Found），……！"); 
                        /* 对404的处理 */
                        return;
                    }
                    else if (xmlHttp.status == 403) {  
                        alert("出错了☹   （错误代码：403 Forbidden），……"); 
                        /* 对403的处理  */ 
                        return;
                    }
                    else {
                        alert("出错了☹   （错误代码：" + request.status + "），……"); 
                        /* 对出现了其他错误代码所示错误的处理   */
                        return;
                    }   
                } 
                    
              }
            
            //把请求发送到服务器上的指定文件（url指向的文件）进行处理
            xmlHttp.open("GET", url, true);        //true表示异步处理
            xmlHttp.send();
        }        
        </script>
</body>
</html>