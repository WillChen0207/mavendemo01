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
import java.nio.charset.StandardCharsets;

@WebServlet(name = "EditPageServlet", urlPatterns = "/editshow")
public class EditPageServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public EditPageServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String objID = new String(request.getParameter("ObjID").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        LFObject lfObject = new LFObject();
        lfObject.setObjID(objID);
        Rec rec = new Rec(lfObject);
        RecService recService = new RecService(new RecordDao(rec));
        try {
            Rec resRecord = recService.fetchFullRec().getRecord();
            request.setAttribute("recordToEdit", resRecord);
            request.setAttribute("ObjIDEditing", objID);
            request.setAttribute("PosUserID", resRecord.getPosUser());
            request.getRequestDispatcher("edit.jsp").forward(request, response);
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
