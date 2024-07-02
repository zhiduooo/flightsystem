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
            <span>航班信息管理 >> 用户新增界面</span>
        </div>
        <div class="providerAdd">
            <form action="/addUser" method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <%--                <div class="">--%>
                <%--                    <label for="flightId">序号：</label>--%>
                <%--                    <input type="text" name="flightId" id="flightId"/>--%>
                <%--                    <span>请输入序号</span>--%>
                <%--                </div>--%>
                <div>
                    <label for="flyId">用户名：</label>
                    <input type="text" name="username" id="flyId" required/>
                    <span >请输入用户名</span>
                </div>
                <div>
                    <label for="flyDesc">密码：</label>
                    <input type="text" name="password" id="flyDesc" required/>
                    <span>*请输入密码</span>

                </div>
                <div>
                    <label for="destination">邮箱：</label>
                    <input type="text" name="email" id="destination" required/>
                    <span>*请输入邮箱</span>
                </div>
                <div>
                    <label for="flyTime">性别：</label>
                    <input type="text" name="gender" id="flyTime" required/>
                    <span>*请输入性别</span>
                </div>
                <div>
                    <label for="age">年龄：</label>
                    <input type="text" name="age" id="age" required/>
                    <span>*请输入年龄</span>
                </div>
                <div>
                    <label for="job">职位：</label>
                    <input type="text" name="job" id="job" required/>
                    <span>*请输入职位</span>
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