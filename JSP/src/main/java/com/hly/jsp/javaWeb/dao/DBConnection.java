package com.hly.jsp.javaWeb.dao;

import java.sql.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/31
 */
public class DBConnection {

    private static final String driverName = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/testDB?useUnicode=true&characterEncoding=UTF-8";
    private static final String user = "root";
    private static final String password = "roof";
    private static Connection connection = null;

    /*static {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.out.println("连接失败"+e.getMessage());
        }
    }
*/
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, user, password);;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
