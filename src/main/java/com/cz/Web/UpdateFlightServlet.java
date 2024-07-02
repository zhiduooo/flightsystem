package com.cz.Web;

import com.cz.Service.Impt.FlightServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/updateflight"})
public class UpdateFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //设置编码
        req.setCharacterEncoding("UTF-8");
        //接受参数
        String fid = req.getParameter("flightId");
        String flyID = req.getParameter("flyId");
        String flyDesc = req.getParameter("flyDesc");
        String destination = req.getParameter("destination");
        String flyTime = req.getParameter("flyTime");
        Integer id = Integer.parseInt(fid);
        //逻辑代码
        FlightServiceImpt flightServiceImpt = new FlightServiceImpt();
        boolean b = flightServiceImpt.updateflight(id,flyID,flyDesc,destination,flyTime);
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
