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
import java.util.ArrayList;

@WebServlet(name = "UserInfoServlet", urlPatterns = "/user")
public class UserInfoServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;//序列化UID

    public UserInfoServlet() { super(); }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        UserService userService = new UserService(new UserDao(new User()));
        Integer order = Integer.valueOf(request.getParameter("order"));
        try {
            ArrayList<User> userList = userService.fetchAll(order);
            request.getSession().setAttribute("userinfoList", userList);
            request.getRequestDispatcher("user.jsp").forward(request, response);
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