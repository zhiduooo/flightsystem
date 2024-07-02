package com.cz.Web;

import com.cz.Service.Impt.FlightServiceImpt;
import com.cz.Service.Impt.UserServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addUser"})
public class AddUsersServlet extends HttpServlet {
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
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String a = req.getParameter("age");
        String job = req.getParameter("job");

        Integer age = Integer.parseInt(a);
        //逻辑代码
        UserServiceImpt uimpt = new UserServiceImpt();
        boolean b = uimpt.adduser(username,password,email,gender,age,job);
        if(b){
            req.setAttribute("addtishi","航班信息已经成功添加！！");
            req.getRequestDispatcher("/usersAdd.jsp").forward(req,resp);
        }
        else {
            req.setAttribute("addtishi","航班信息添加失败！！");
            req.getRequestDispatcher("/userAdd.jsp").forward(req,resp);
        }


    }
}
