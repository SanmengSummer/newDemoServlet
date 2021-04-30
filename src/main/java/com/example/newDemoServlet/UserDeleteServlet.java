package com.example.newDemoServlet;

import com.example.newDemoServlet.dao.UserDao;
import com.example.newDemoServlet.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = request.getParameter("userId");


        UserDao userDao = new UserDao();
        int result = userDao.delete(userId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (result == 1)
            writer.println("<fort style ='fort-color:red;fort-size:40'>成功删除一条数据</fort>");
        else writer.println("<fort style ='fort-color:red;fort-size:40'>失败了</fort>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
