package com.testsql.Servlet;

import com.testsql.Dao.UserDao;
import com.testsql.Service.UserService;
import com.testsql.pojo.Cipher;
import com.testsql.pojo.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LogServlet", urlPatterns = "/logcheck")
public class LogServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;//序列号UID
    public LogServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = new String(request.getParameter("ID").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String password = new String(request.getParameter("Password").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        User user = new User();
        user.setUserID(id);
        user.setPassword(password);
        UserService userService = new UserService(new UserDao(user));
        try {
            if (userService.logcheck()) {
                user = userService.getUserById();
                request.getSession().setAttribute("UserName",user.getUserName());
                request.getSession().setAttribute("UserID", user.getUserID());
                request.getSession().setAttribute("AuthLv", user.getAuthLv());
                request.getRequestDispatcher("logres.jsp").forward(request, response);
            }
            else {
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp");
            e.printStackTrace();
        }

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
