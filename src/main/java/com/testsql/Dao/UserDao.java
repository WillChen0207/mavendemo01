package com.testsql.Dao;

import com.testsql.pojo.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao extends SqlDaoSupport{
    public User user;

    public UserDao(User user) {
        super();
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void save() throws Exception {
        String sql = "INSERT INTO testsql.userinfo (UserName, Name, ID, Password, CampusCode, AuthLv, Signature) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getUserID());
            pstmt.setString(4, user.getPassword());
            pstmt.setInt(5, user.getCampusCode());
            pstmt.setInt(6, user.getAuthLv());
            pstmt.setString(7, user.getSignature());
            pstmt.executeUpdate();
            pstmt.close();
        } finally {

        }
    }

    public void delete() throws Exception {
        String sql = "DELETE FROM testsql.userinfo where ID = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserID());
            pstmt.executeUpdate();
            pstmt.close();
        } finally {

        }
    }

    public User getUserById() throws Exception {
        User userres = new User();
        String sql = "SELECT * FROM testsql.userinfo WHERE ID = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserID());
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                userres.setUserID(user.getUserID());
                userres.setUserName(res.getString("UserName"));
                userres.setPassword(res.getString("Password"));
                userres.setCampusCode(res.getInt("CampusCode"));
                userres.setAuthLv(res.getInt("AuthLv"));
                userres.setSignature(res.getString("Signature"));
            }
        } finally {

        }
        return userres;
    }

    public Boolean logcheck() throws Exception{ //return boolean type result
        boolean flag = false;
        String sql = "SELECT UserName, AuthLv FROM testsql.userinfo WHERE userinfo.ID = ? AND userinfo.Password = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserID());
            pstmt.setString(2, user.getPassword());
            ResultSet res = pstmt.executeQuery();
            if (res.next()) {
                flag = true;
            }
        } finally {

        }
        return flag;
    }

    public ArrayList<User> fetchAll(int order) throws Exception {
        ArrayList<User> userList;
        userList = new ArrayList<>();
        String orderCol = "";
        switch (order) {
            case 2 -> {
                orderCol = "UserName";
            }
            case 3 -> {
                orderCol = "CampusCode";
            }
            case 4 -> {
                orderCol = "AuthLv";
            }
            default -> {
                orderCol = "ID";
            }
        }
        String sql = "SELECT\n" +
                "	userinfo.ID,\n" +
                "	userinfo.UserName,\n" +
                "	userinfo.Signature,\n" +
                "	campusinfo.CampusCode,\n" +
                "	campusinfo.CampusName,\n" +
                "	userinfo.AuthLv \n" +
                "FROM\n" +
                "	testsql.userinfo\n" +
                "	INNER JOIN testsql.campusinfo ON userinfo.CampusCode = campusinfo.CampusCode \n" +
                "ORDER BY\n" + orderCol;
        PreparedStatement pstmt = null;
        ResultSet res;
        try {
            pstmt = conn.prepareStatement(sql);
            res = pstmt.executeQuery();

            while (res.next()) {
                User user = new User();
                user.setUserID(res.getString("ID"));
                user.setUserName(res.getString("UserName"));
                user.setSignature(res.getString("Signature"));
                user.setCampusCode(res.getInt("CampusCode"));
                user.setCampusName(res.getString("CampusName"));
                user.setAuthLv(res.getInt("AuthLv"));
                userList.add(user);
            }
        } finally {
            pstmt.close();

        }
        return userList;
    }
}
