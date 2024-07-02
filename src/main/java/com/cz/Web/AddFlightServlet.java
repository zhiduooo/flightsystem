package com.cz.Web;

import com.cz.Bean.flight;
import com.cz.Service.Impt.FlightServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/addFlight"})
public class AddFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //接受参数
        String flyID = req.getParameter("flyId");
        String flyDesc = req.getParameter("flyDesc");
        String destination = req.getParameter("destination");
        String flyTime = req.getParameter("flyTime");

        //逻辑代码
        FlightServiceImpt fsimpt = new FlightServiceImpt();
       boolean b = fsimpt.addflight(flyID,flyDesc,destination,flyTime);
       if(b){
            req.setAttribute("addtishi","航班信息已经成功添加！！");
            req.getRequestDispatcher("/flyAdd.jsp").forward(req,resp);
       }
       else {
           req.setAttribute("addtishi","航班信息添加失败！！");
           req.getRequestDispatcher("/flyAdd.jsp").forward(req,resp);
       }

    }
}
