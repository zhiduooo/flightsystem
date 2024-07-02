<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 陈峥的航班管理系统</title>
    <link rel="stylesheet" href="/css/style.css"/>
    <script>
            function judge() {
                var pwd = document.getElementById("mima").value;
                var qpwd = document.getElementById("querenmima").value;
                if (pwd != qpwd) {
                    var judge = document.getElementById("judge");
                    judge.innerHTML = "两次密码输入的不一致！！"
                    document.getElementById("mima").value="";
                     document.getElementById("querenmima").value="";
                } else {
                    var judge = document.getElementById("judge");
                    judge.innerHTML = "";
                }
            }


    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>陈峥的航班管理系统</h1>
    </header>
    <section class="registerCont">
        <form class="registerForm" action="/register" method="post">


            &nbsp;&nbsp;&nbsp;用户名：<input id="user" type="text" name="username" placeholder="用户名：" required/>
            <br><br>
            &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;性别：<input id="woman" type="radio" name="gender" value="女" placeholder="gender" required/>女
             <input id="man" type="radio" name="gender"  value="男" placeholder="gender" required/>男
            <br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码：<input id="mima" type="password" name="password" placeholder="密码：" required/>
            <br><br>
                确认密码：<input id="querenmima" type="password" name="qpassword" placeholder="确认密码："  onblur="judge()" required/>
            <span id="judge" style="color: red;"></span>
            <br><br>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮箱：<input id="email" type="email" name="email" placeholder="email" required/>
            <br><br>

            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年龄：<input id="age" type="int" name="age" placeholder="age" required/>

            <br><br>

            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;职位：
                <input id="yuangong" type="radio" name="job" placeholder="job" value="1" required/>员工
                <input id="jingli" type="radio" name="job" placeholder="job" value="2" required/>经理
                <input id="manager" type="radio" name="job" placeholder="job"  value="3" required/>管理员

            <br><br>
            <p><span style="color: chocolate"> &nbsp; &nbsp; &nbsp; &nbsp;${trueregister}</span> </p>
            <p><span style="color: red">  &nbsp; &nbsp; &nbsp; &nbsp;${falseregister}</span> </p>
            <p><span  id="tishi" style="color: red"> </span> </p>
            <br><br>
            <div class="subBtn">
                <input type="submit" value="注册" />
                <input type="reset" value="重置"/>
                <br>
            </div>
        </form>
    </section>
</section>
</body>
</html>