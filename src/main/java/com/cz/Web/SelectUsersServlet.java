package com.cz.Web;

import com.cz.Bean.flight;
import com.cz.Bean.users;
import com.cz.Service.Impt.FlightServiceImpt;
import com.cz.Service.Impt.UserServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = {"/selectusers"})
public class SelectUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //接受参数

        String username = req.getParameter("username");
        String a = req.getParameter("age");
        UserServiceImpt uimpt = new UserServiceImpt();
        //逻辑代码
        if (username.isEmpty()&&a.isEmpty()) {
            List<users> allusers = uimpt.getallusers();
            //存值加跳转页面
            req.setAttribute("allusers",allusers);
            req.getRequestDispatcher("/userList.jsp").forward(req,resp);
        }
        else if(!username.equals("")){
            List<users> allusers = uimpt.getusernameusers(username);
            //存值加跳转页面
            req.setAttribute("allusers",allusers);
            req.getRequestDispatcher("/userList.jsp").forward(req,resp);
        }
        else if(!a.equals("")){
            Integer age = Integer.parseInt(a);
            List<users> allusers = uimpt.getageusers(age);
            //存值加跳转页面
            req.setAttribute("allusers",allusers);
            req.getRequestDispatcher("/userList.jsp").forward(req,resp);
        } else{
            Integer age = Integer.parseInt(a);
            List<users> allusers = uimpt.getsomeusers(username,age);
            //存值加跳转页面
            req.setAttribute("allusers",allusers);
            req.getRequestDispatcher("/userList.jsp").forward(req,resp);
        }

    }
}
