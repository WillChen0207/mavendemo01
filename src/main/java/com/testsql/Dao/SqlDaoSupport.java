package com.testsql.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDaoSupport {

    static Connection conn;
    static String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/testsql?useSSL=false&serverTimezone=UTC";
    static final String username = "root";
    static final String password = "root";

    public SqlDaoSupport() {
//        public static void main(String[] args){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("Fail to load jdbc driver.");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Fail to connect to database.");
            e.printStackTrace();
        }

    }
}
