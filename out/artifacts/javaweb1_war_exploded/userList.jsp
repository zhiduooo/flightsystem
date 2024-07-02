<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8">
  <title>陈峥的航班管理系统</title>
  <link rel="stylesheet" href="css/style.css"/>
  <link rel="stylesheet" href="css/public.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
  <h1>陈峥的航班管理系统</h1>
  <div class="publicHeaderR">
    <p><span></span><span style="color: #fff21b"> ${username}</span> , 欢迎您！</p>
    <a href="index.jsp">退出</a>
  </div>
  <script type="text/javascript" src="/js/jquery.js"></script>
  <script>
    $(function () {
      $('.removeBill').click(function () {
        var id = $(this).attr('id'); // 获取当前点击的删除按钮的id属性值
        $('#removeBi').css('display', 'block'); // 显示删除确认框
        $('#yes').attr('href', '/deleteUserById?id=' + id); // 设置确定按钮的链接地址
      });

      $('#no').click(function () {
        $('#removeBi').css('display', 'none'); // 隐藏删除确认框
      });
    });

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
        <li id="active"><a href="/hangban/manage">航班信息管理</a></li>
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
      <span>用户管理页面</span>
    </div>
    <div class="search">
      <form action="/selectusers" method="post">
        <span>用户名：</span>
        <input type="text" name="username" placeholder="请输入用户名"/>

        <span>用户年龄：</span>
        <input  type="text" name="age" placeholder="请输入用户年龄"/>

        <input width="10px" type="submit" value="查询"/>
      </form>
      <a href="userAdd.jsp">添加用户</a>
    </div>

    <!--账单表格 样式和供应商公用-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
      <tr class="firstTr">
        <th width="10%">用户编号</th>
        <th width="10%">用户名</th>
        <th width="10%">密码</th>
        <th width="10%">邮箱</th>
        <th width="10%">性别</th>
        <th width="10%">年龄</th>
        <th width="10%">职位</th>
        <th width="30%">操作</th>

      </tr>
      <c:forEach items="${allusers}" var="user" >
        <tr align="center">
            <%--<td>${brand.id}</td>--%>
          <td>${user.userid}</td>
          <td>${user.username}</td>
          <td>${user.password}</td>
          <td>${user.emali}</td>
              <td>${user.gender}</td>
              <td>${user.age}</td>
          <td>${user.job}</td>
          <td>
            <a href="/selectUserById?id=${user.userid}"><img src="/img/xiugai.png" alt="修改" title="修改"/></a>
            <a id="${user.userid}" name="" class="removeBill"><img src="/img/schu.png" alt="删除" title="删除"/></a>
          </td>
        </tr>

      </c:forEach>
    </table>
  </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeBi">
  <div class="removerChid">
    <h2>提示</h2>
    <div class="removeMain">
      <p>你确定要删除该用户信息吗？</p>
      <a href="#" id="yes">确定</a>
      <a href="#" id="no">取消</a>
    </div>
  </div>
</div>

<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
</body>
</html>