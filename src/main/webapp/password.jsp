<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>陈峥的航班管理系统</title>
    <link rel="stylesheet" href="/css/public.css"/>
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>陈峥的航班管理系统</h1>

    <div class="publicHeaderR">
        <p><span></span><span style="color: #fff21b" >${username}</span> , 欢迎您！</p>
        <a href="/index.jsp">退出</a>
    </div>
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script>
        $(function (){

            $("#submit").click(function (){
                event.preventDefault();
                //接收参数
                var newpwd = $("#newpwd").val();
                var qrpwd =$("#qrpwd").val();
                var username=$("#uname").attr("name");
                if(newpwd!=qrpwd){
                    $("#qrtishi").html("*两次密码输入不一致请检查！")
                }
                else {
                    $("#qrtishi").html("*")
                    $.post("/updatepassword",
                        {
                            "password":newpwd,
                            "username":username
                        }
                        , function (data, status) {
                            $("#updatetishi").html(data);
                        });
                }

            })

        })



    </script>
</header>
<!--时间-->
<!--<section class="publicTime">-->
<!--<span id="time">2015年1月1日 11:11  星期一</span>-->
<!--</section>-->
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表<span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="/hangban/manage">航班信息管理</a></li>
                <li><a href="/usermanage">用户管理</a></li>
                <li><a href="/infomessage">消息通知</a></li>
                <li><a href="/password.jsp">密码修改</a></li>
                <li><a href="/index.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <span id="uname" name=${username}></span>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>密码修改页面</span>
        </div>
        <div class="providerAdd">
            <form>
                <p><span style="color: red">${select_by_id_error}</span> </p>
                <p><span id="updatetishi"></span></p>
                <div class="">
                    <label for="oldpwd">旧密码：</label>
                    <input type="password" name="oldpwd" id="oldpwd"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="newpwd">新密码：</label>
                    <input type="password" name="newpwd" id="newpwd"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="qrpwd">确认密码：</label>
                    <input type="password" name="qrpwd" id="qrpwd"/>
                    <span id="qrtishi">*</span>
                </div>
                <div class="providerAddBtn">
                    <input type="submit" id="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="/js/time.js"></script>

</body>
</html>