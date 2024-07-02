package com.cz.Web;

import com.cz.Bean.message;
import com.cz.Service.Impt.MessageServiceImpt;
import com.cz.Service.MessageService;
import com.mysql.cj.protocol.Message;
import com.mysql.cj.protocol.x.XMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/infomessage"})
public class SelectMessagesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageServiceImpt mimpt = new MessageServiceImpt();
        List<message> allmessages = mimpt.getallmessages();
        System.out.println(allmessages);
        req.setAttribute("allmessages",allmessages);
        req.getRequestDispatcher("/info.jsp").forward(req,resp);

    }
}
