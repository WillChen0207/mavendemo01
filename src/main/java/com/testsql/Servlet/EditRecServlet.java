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

@WebServlet(name = "EditRecServlet", urlPatterns = "/edit")
public class EditRecServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;

    public EditRecServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        LFObject lfObject = new LFObject();
        lfObject.setObjID(String.valueOf(request.getSession().getAttribute("ObjID")));
        lfObject.setObjName(new String(request.getParameter("ObjName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        lfObject.setDescription(new String(request.getParameter("Description").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
        lfObject.setMatched(Integer.valueOf(request.getParameter("Matched")));
        lfObject.setClassID(Integer.valueOf(request.getParameter("ClassID")));
        Rec rec = new Rec(lfObject);
        rec.setPosUser(String.valueOf(request.getSession().getAttribute("PosUser")));
        rec.setLFType(Integer.valueOf(request.getParameter("LFType")));
        rec.setPosCampus(Integer.valueOf(request.getParameter("PosCampus")));
        RecService recService = new RecService(new RecordDao(rec));
        try {
            recService.edit();
            request.getRequestDispatcher("editres.jsp").forward(request, response);
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
