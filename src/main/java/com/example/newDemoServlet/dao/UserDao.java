package com.example.newDemoServlet.dao;


import com.example.newDemoServlet.entity.Users;
import com.example.newDemoServlet.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {

    private PreparedStatement statement;
    private Connection conn;
    int result = 0;
    public int add(Users users) {
        try {
            String sql = "insert into users(userName,password,sex,email) values(?,?,?,?)";
            conn = JdbcUtils.getConn();
            statement =  conn.prepareStatement(sql);
            statement.setString(1, users.getUserName());
            statement.setString(2, users.getPassWord());
            statement.setString(3, users.getSex());
            statement.setString(4, users.getEmail());
            result = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
