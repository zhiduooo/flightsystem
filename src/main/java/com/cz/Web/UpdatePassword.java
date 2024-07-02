package com.cz.Web;

import com.cz.Service.Impt.UserServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updatepassword"})
public class UpdatePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String password = req.getParameter("password");
       String username = req.getParameter("username");
       System.out.println(password+"   "+username);
        UserServiceImpt uimpt = new UserServiceImpt();
        Boolean b = uimpt.updatepassword(password,username);
        System.out.println(b);
        if(b){
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("保存成功！！");
        }
        else {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("保存失败！！");
        }
    }
}
