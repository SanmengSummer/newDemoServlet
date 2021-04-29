package com.example.newDemoServlet.entity;

public class Users {
    private int userId;
    private String userName;
    private String passWord;
    private String sex;
    private String email;

    public Users() {
    }

    public Users( String userName, String passWord, String sex, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.sex = sex;
        this.email = email;
    }

    public Users(int userId, String userName, String passWord, String sex, String email) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.sex = sex;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
