package com.cz.Web;

import com.cz.Bean.flight;
import com.cz.Service.Impt.FlightServiceImpt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hangban/selectFlightById"})
public class SelectFlightByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //获取参数
        String fid = req.getParameter("id");
        Integer id = Integer.parseInt(fid);
        //逻辑代码，调用业务逻辑层
        FlightServiceImpt fsimpt = new FlightServiceImpt();
        flight flt = fsimpt.getflightbyid(id);
        if(flt != null){
            //存值
            req.setAttribute("flight",flt);
            //跳转页面
            req.getRequestDispatcher("/flyUpdate.jsp").forward(req,resp);

        }
        else{
            req.setAttribute("select_by_id_error","未找到该条航班信息！！");
            req.getRequestDispatcher("/flyUpdate.jsp").forward(req,resp);
        }



    }
}
