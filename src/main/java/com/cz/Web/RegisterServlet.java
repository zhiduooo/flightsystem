package com.cz.Web;

import com.cz.Bean.users;
import com.cz.Service.Impt.UserServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //指定编码
        req.setCharacterEncoding("UTF-8");
        //获取参数
        String username = req.getParameter("username");
        String gender = req.getParameter("gender");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String age = req.getParameter("age");
        String job = req.getParameter("job");
        //调用逻辑层
        Integer age1 = Integer.parseInt(age);
        users u = new users();
        u.setPassword(password);
        u.setUsername(username);
        u.setEmali(email);
        u.setAge(age1);
        u.setGender(gender);
        u.setJob(job);
        UserServiceImpt userServiceImpt = new UserServiceImpt();
        boolean b = userServiceImpt.register(u);
        if(b){
            req.setAttribute("trueregister","您已注册成功！");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }
        else{
            req.setAttribute("falseregister","抱歉注册失败！");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }
        //存值跳转页面



    }
}
