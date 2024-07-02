package com.cz.Web;


import com.cz.Bean.users;
import com.cz.Service.Impt.UserServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/usermanage"})
public class UsersManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        // 调用业务逻辑代码（创建对象，调用方法获取返回值）
        UserServiceImpt uimpt = new UserServiceImpt();
        List<users> allusers = uimpt.getallusers();
        //存值加跳转页面
        req.setAttribute("allusers",allusers);
        req.getRequestDispatcher("/userList.jsp").forward(req,resp);
    }
}
