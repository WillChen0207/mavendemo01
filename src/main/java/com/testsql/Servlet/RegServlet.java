package com.testsql.Servlet;

import com.testsql.Dao.UserDao;
import com.testsql.Service.UserService;
import com.testsql.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

@WebServlet(name = "RegServlet", urlPatterns = "/reg")
public class RegServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;//序列号UID

    public RegServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        String id, String username, String password, String name, String signature, Integer campuscode, Integer authlv
        String id = new String(request.getParameter("ID").getBytes("iso-8859-1"), ("utf-8"));
        String username = new String(request.getParameter("UserName").getBytes("iso-8859-1"), ("utf-8"));
        String password = new String(request.getParameter("Password").getBytes("iso-8859-1"), ("utf-8"));
        String name = new String(request.getParameter("Name").getBytes("iso-8859-1"), ("utf-8"));
        String signature = new String(request.getParameter("Signature").getBytes("iso-8859-1"), ("utf-8"));
        Integer campuscode = Integer.valueOf(request.getParameter("CampusCode"));
        Integer authlv = Integer.valueOf(request.getParameter("AuthLv"));
        User user = new User(id, username, password, name, signature, campuscode, authlv);
        UserService userService = new UserService(new UserDao(user));
        try {
            userService.register();
            request.setAttribute("UserName", username);
            request.setAttribute("ID", id);
            request.getRequestDispatcher("regres.jsp").forward(request, response);
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