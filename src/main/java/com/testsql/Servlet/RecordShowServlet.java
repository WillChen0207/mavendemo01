package com.testsql.Servlet;

import com.testsql.Dao.RecordDao;
import com.testsql.Service.RecService;
import com.testsql.pojo.Rec;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.util.ArrayList;

@WebServlet(name = "RecordShowServlet", urlPatterns = "/recshow")
public class RecordShowServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public RecordShowServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        RecService recService = new RecService(new RecordDao(new Rec()));
        try {
            ArrayList<Rec> recordList = recService.fetchAll();
            if (!recordList.isEmpty()) {
                request.getSession().setAttribute("recordList", recordList);
                request.getRequestDispatcher("rec.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}