package com.cz.Web;

import com.cz.Bean.flight;
import com.cz.Service.Impt.FlightServiceImpt;

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

@WebServlet(urlPatterns = {"/selectFlight"})
public class SelectFlightsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //设置编码
        req.setCharacterEncoding("UTF-8");
        //接受参数

        String destination = req.getParameter("destination");
        String flytime = req.getParameter("flyTime");
        Date date = null;
        try {
            if(!flytime.equals("")) {
                System.out.println(flytime);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                 date = dateFormat.parse(flytime);

            }
        } catch (ParseException e) {
            System.out.println("日期转换失效！");
            throw new RuntimeException(e);
        }
        FlightServiceImpt fsimpt = new FlightServiceImpt();
        //逻辑代码
        if (flytime.isEmpty()&&destination.isEmpty()) {
            List<flight> allflights = fsimpt.getallflights();
            //存值加跳转页面
            req.setAttribute("allFlights",allflights);
            req.getRequestDispatcher("/flyList.jsp").forward(req,resp);
        }
        else if(destination.equals("")){
            List<flight> allflights = fsimpt.getflytimeflights(date);
            //存值加跳转页面
            req.setAttribute("allFlights",allflights);
            req.getRequestDispatcher("/flyList.jsp").forward(req,resp);
        }
        else if(flytime.equals("")){

            System.out.println(destination);
            List<flight> allflights = fsimpt.getdestflights(destination);
            //存值加跳转页面
            req.setAttribute("allFlights",allflights);
            req.getRequestDispatcher("/flyList.jsp").forward(req,resp);
        } else{
            List<flight> allflights = fsimpt.getsomeflights(destination,date);
            //存值加跳转页面
            req.setAttribute("allFlights",allflights);
            req.getRequestDispatcher("/flyList.jsp").forward(req,resp);
        }

    }
}
