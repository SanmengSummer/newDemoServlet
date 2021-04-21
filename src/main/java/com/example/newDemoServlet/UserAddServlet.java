package com.example.newDemoServlet;

import com.example.newDemoServlet.dao.UserDao;
import com.example.newDemoServlet.entity.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserAddServlet", value = "/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String userName, password, sex, email;
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        Users users = new Users(userName, password, sex, email);
        response.setContentType("text/html;charset=utf-8");
        int result = userDao.add(users);
        PrintWriter writer = response.getWriter();
        if (result == 1)
            writer.println("<fort style ='fort-color:red;fort-size:40'>成功插入一条数据</fort>");
        else writer.println("<fort style ='fort-color:red;fort-size:40'>失败了</fort>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
