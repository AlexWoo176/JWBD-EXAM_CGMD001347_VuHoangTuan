package com.codegym.dao;

import com.codegym.constant.SystemConstant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public static Connection getConnection() {
        try {
            Class.forName(SystemConstant.driverName);
            return DriverManager.getConnection(SystemConstant.url, SystemConstant.user, SystemConstant.password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        try {
            if (connection != null) {
                System.out.println("Data connection successful");
            } else {
                System.out.println("Data connection failed");
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}