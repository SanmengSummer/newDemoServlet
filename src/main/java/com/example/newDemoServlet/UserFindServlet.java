package com.example.newDemoServlet;

import com.example.newDemoServlet.dao.UserDao;
import com.example.newDemoServlet.entity.Users;
import com.example.newDemoServlet.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "UserFindServlet", value = "/UserFindServlet")
public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        List<Users> all = userDao.findAll();
//        String userName, password, sex, email;
//        userName = request.getParameter("userName");
//        password = request.getParameter("password");
//        sex = request.getParameter("sex");
//        email = request.getParameter("email");
//        Users users = new Users(userName, password, sex, email);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<table border='2' align='center'>");
        writer.print("<tr>");
        writer.print("<td>用户编号</td>");
        writer.print("<td>用户姓名</td>");
        writer.print("<td>用户密码</td>");
        writer.print("<td>用户性别</td>");
        writer.print("<td>用户邮箱</td>");
        writer.print("</tr>");
        for (Users users:all) {
            writer.print("<tr>");
            writer.print("<td>"+users.getUserId()+"</td>");
            writer.print("<td>"+users.getUserName()+"</td>");
            writer.print("<td>"+users.getPassWord()+"</td>");
            writer.print("<td>"+users.getSex()+"</td>");
            writer.print("<td>"+users.getEmail()+"</td>");
            writer.print("</tr>");
        }
        writer.print("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
