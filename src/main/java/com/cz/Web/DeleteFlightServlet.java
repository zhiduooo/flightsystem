package com.cz.Web;

import com.cz.Service.Impt.FlightServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hangban/deleteFlightById"})
public class DeleteFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String id = req.getParameter("id");

        Integer id1 = Integer.parseInt(id);
        FlightServiceImpt flightServiceImpt = new FlightServiceImpt();
        boolean b = flightServiceImpt.deleteflight(id1);
        if(b){
            System.out.println("删除成功！");
            req.getRequestDispatcher("/hangban/manage").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
