package com.testsql.Servlet;

import com.testsql.Dao.RecordDao;
import com.testsql.Service.RecService;
import com.testsql.pojo.LFObject;
import com.testsql.pojo.Rec;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "ObjPage", urlPatterns = "/objpage")
public class ObjPageServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;//序列化UID

    public ObjPageServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String objID = request.getParameter("ObjID");
        String objName = request.getParameter("ObjName");
        String className = request.getParameter("ClassName");
        LFObject lfObject = new LFObject();
        lfObject.setObjID(objID);
        lfObject.setObjName(objName);
        lfObject.setClassName(className);
        RecService recService = new RecService(new RecordDao(new Rec(lfObject)));
        try {
            lfObject = recService.getObjectInfo();
            request.setAttribute("ObjID", lfObject.getObjID());
            request.setAttribute("ObjName", lfObject.getObjName());
            request.setAttribute("ClassName", lfObject.getClassName());
            request.getRequestDispatcher("objpage.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("error.jsp");
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}