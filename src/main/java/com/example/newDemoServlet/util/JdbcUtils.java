package com.example.newDemoServlet.util;

import java.sql.*;

public class JdbcUtils {


    private static Connection connection;
    private static ResultSet resultSet;
    private static PreparedStatement preparedStatement;

    public static Connection getConn() throws Exception {
        String url = "jdbc:mysql://localhost:3306/demosql";
        String user = "root";
        String password = "123";
        String driver = "com.mysql.jdbc.Driver";
        Connection connection = null;
        try {
//            Properties properties = new Properties();
//            FileInputStream fis = new FileInputStream(new File("mysql.properties"));
//            properties.load(fis);
//            url = properties.getProperty("url");
//            user = properties.getProperty("username");
//            password = properties.getProperty("password");
//            driver = properties.getProperty("driver");
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.getMessage();
            System.out.println(""+e);
        }
        return connection;
    }

    public static void close(ResultSet resultSet, PreparedStatement preparedStatement) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public static void close() {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
