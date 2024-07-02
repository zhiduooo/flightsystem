package com.cz.Web;

import com.cz.Bean.users;
import com.cz.Service.Impt.UserServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("UTF-8");
        //1.接受参数
       String username = req.getParameter("username");
       String password = req.getParameter("password");

       //调用业务逻辑（创建对象，调取方法）
        UserServiceImpt userServiceImpt = new UserServiceImpt();
        users u = userServiceImpt.login(username,password);
       // System.out.println(u+"hhhh");
       // System.out.println(u.getUsername());
        //跳转页面
        if(u!=null){
            req.getSession().setAttribute("username",u.getUsername());
            req.getRequestDispatcher("welcome.jsp").forward(req,resp);

        }
        else {
            req.getSession().setAttribute("error","用户名或者密码不正确");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }
}
