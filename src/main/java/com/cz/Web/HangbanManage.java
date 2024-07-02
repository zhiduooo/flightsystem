package com.cz.Web;

import com.cz.Bean.flight;
import com.cz.Service.FlightService;
import com.cz.Service.Impt.FlightServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/hangban/manage"})
public class HangbanManage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //接受参数
        // 调用业务逻辑代码（创建对象，调用方法获取返回值）
        FlightServiceImpt fsimpt = new FlightServiceImpt();
        List<flight> allflights = fsimpt.getallflights();
        //存值加跳转页面
        req.setAttribute("allFlights",allflights);
        req.getRequestDispatcher("/flyList.jsp").forward(req,resp);
    }
}
