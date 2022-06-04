package com.testsql.Servlet;

import com.testsql.Dao.RecordDao;
import com.testsql.Service.RecService;
import com.testsql.pojo.LFObject;
import com.testsql.pojo.Rec;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "DeleteObjServlet", urlPatterns = "/delete")
public class DeleteObjServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;//序列号UID

    public DeleteObjServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String objID = request.getParameter("ObjID");
        LFObject lfObject = new LFObject();
        lfObject.setObjID(objID);

        RecService recService = new RecService(new RecordDao(new Rec(lfObject)));
            try {
                recService.delete();
                request.getRequestDispatcher("delobjres.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.getRequestDispatcher("error.jsp");
            }

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
