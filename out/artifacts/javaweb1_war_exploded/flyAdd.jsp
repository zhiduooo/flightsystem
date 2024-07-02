<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<!--主体内容-->
<section class="publicMian ">
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
            <span>航班信息管理 >> 航班新增页面</span>
        </div>
        <div class="providerAdd">
            <form action="/addFlight" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
<%--                <div class="">--%>
<%--                    <label for="flightId">序号：</label>--%>
<%--                    <input type="text" name="flightId" id="flightId"/>--%>
<%--                    <span>请输入序号</span>--%>
<%--                </div>--%>
                <div>
                    <label for="flyId">航班编号：</label>
                    <input type="text" name="flyId" id="flyId" required/>
                    <span >请输入航班编号</span>
                </div>
                <div>
                    <label for="flyDesc">航班：</label>
                    <input type="text" name="flyDesc" id="flyDesc" required"/>
                    <span>*请输入航班</span>

                </div>
                <div>
                    <label for="destination">航班目的地：</label>
                    <input type="text" name="destination" id="destination" required/>
                    <span>*请输入航班目的地</span>
                </div>
                <div>
                    <label for="flyTime">航班起飞时间：</label>
                    <input type="text" name="flyTime" id="flyTime" required/>
                    <span>*请输入航班起飞时间</span>
                </div>
                <span style="margin-left: 170px">${addtishi}</span>
                <div class="providerAddBtn">
                    <input type="submit" class="save" id="saveflyt" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>


<footer class="footer">
</footer>
<script src="js/time.js"></script>
<script src="js/js.js"></script>
<script src="/js/jquery.js"></script>

</body>
</html>