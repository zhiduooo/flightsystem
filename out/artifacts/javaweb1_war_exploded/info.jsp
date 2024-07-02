<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>陈峥的航班管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>陈峥的航班管理系统</h1>

    <div class="publicHeaderR">
        <p><span></span><span style="color: #fff21b"> ${username}</span> , 欢迎您！</p>
        <a href="index.jsp">退出</a>
    </div>
</header>
<!--时间-->
<!--<section class="publicTime">-->
<!--<span id="time">2015年1月1日 11:11  星期一</span>-->
<!--</section>-->
<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="/hangban/manage">航班信息管理</a></li>
                <li><a href="/usermanage">用户管理</a></li>
                <li><a href="/infomessage">消息通知</a></li>
                <li><a href="password.jsp">密码修改</a></li>
                <li><a href="index.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>消息通知页面</span>
        </div>
        <br>
        <span style="color: #0c89de;margin-left: 40%"><b>消息通知</b></span>
        <br>
    <c:forEach items="${allmessages}" var="m" >
        <div style="color: #7aaed4"><pr style="margin-left: 10%">${m.message_body}</pr></div>
       <div style="color: #7aaed4"><pr style="margin-left: 40%">${m.m_date}</pr></div>
    </c:forEach>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>
</body>
</html>