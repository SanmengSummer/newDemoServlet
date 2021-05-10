package com.example.newDemoServlet;

import com.example.newDemoServlet.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", value = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String userName, password;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        response.setContentType("text/html;charset=utf-8");
        int result = userDao.login(userName,password);
        if (result == 1)
            response.sendRedirect("/newDemoServlet_war_exploded/index.html");
        else response.sendRedirect("/newDemoServlet_war_exploded/login_error.html");

    }
}
