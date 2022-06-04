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

@WebServlet(name = "DeleteUserServlet", urlPatterns = "/deluser")
public class DeleteUserServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;//序列号UID

    public DeleteUserServlet(){
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("ID");
        User user = new User();
        user.setUserID(id);
        UserService userService = new UserService(new UserDao(user));
        try {
            userService.delete();
            request.getRequestDispatcher("deluserres.jsp").forward(request, response);
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