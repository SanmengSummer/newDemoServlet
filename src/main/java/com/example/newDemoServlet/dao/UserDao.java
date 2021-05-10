package com.example.newDemoServlet.dao;


import com.example.newDemoServlet.entity.Users;
import com.example.newDemoServlet.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private PreparedStatement statement;
    private Connection conn;
    int result = 0;

    public int add(Users users) {
        try {
            String sql = "insert into users(userName,password,sex,email) values(?,?,?,?)";

            if (conn == null) conn = JdbcUtils.getConn();
            statement = conn.prepareStatement(sql);
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

    public List<Users> findAll() {
        ArrayList<Users> list = new ArrayList<>();
        try {
            String sql = "select * from users";
            if (conn == null) conn = JdbcUtils.getConn();
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("userId");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                String sex = resultSet.getString("sex");
                String email = resultSet.getString("email");
                Users users = new Users(userId, userName, password, sex, email);
                list.add(users);
                System.out.println(userName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                conn.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public int delete(String userId) {
        try {
            String sql = "delete  from users where userId=?";
            if (conn == null) conn = JdbcUtils.getConn();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, Integer.valueOf(userId));
            result = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                conn.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public int login(String name, String psw) {
        ResultSet resultSet = null;
        try {
            String sql = "select count(*) from users where userName=? and password=?";
            if (conn == null) conn = JdbcUtils.getConn();
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, psw);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result = resultSet.getInt("count(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert conn != null;
                resultSet = null;
                conn.close();
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
