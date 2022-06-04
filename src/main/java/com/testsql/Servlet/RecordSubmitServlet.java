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
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RecordSubmitServlet", urlPatterns = "/recsub")
public class RecordSubmitServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;//序列号UID

    public RecordSubmitServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String objid = new String(request.getParameter("ObjID").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer lftype = Integer.valueOf(new String(request.getParameter("LFType").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        Integer poscampus = Integer.valueOf(new String(request.getParameter("PosCampus").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        String objname = new String(request.getParameter("ObjName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String description = new String(request.getParameter("Description").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Integer classid = Integer.valueOf(new String(request.getParameter("ClassID").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        String posuser = request.getSession().getAttribute("UserID").toString();

        LFObject lfObject = new LFObject();
        lfObject.setObjName(objname);
        lfObject.setDescription(description);
        lfObject.setMatched(0);
        lfObject.setClassID(classid);
        lfObject.setObjID(objid);// Must be placed here due to ClassID required in setObjID()

        Rec record = new Rec(lfObject, posuser, lftype, null, poscampus);
        RecService recService = new RecService(new RecordDao(record));
        try {
            if (!recService.existCheck()) {
                recService.submit();
            } else {
                recService.match();
            }

            request.getRequestDispatcher("postres.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
            e.printStackTrace();
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}