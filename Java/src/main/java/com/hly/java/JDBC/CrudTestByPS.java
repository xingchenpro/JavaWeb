package com.hly.java.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudTestByPS {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //add();
        //update();
        delete();
        listAllDepartments();
        getDepartmentById();
    }

    public static void listAllDepartments() throws ClassNotFoundException, SQLException {
        String dbUser = "root";
        String dbPassword = "roof";
        String url = "jdbc:mysql://localhost:3306/testDB";
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        String sql = "select id,name,note from department";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String note = rs.getString(3);
            System.out.println("id=" + id + ";name=" + name + ";note=" + note);
        }
    }

    public static void getDepartmentById() throws ClassNotFoundException, SQLException {
        String dbUser = "root";
        String dbPassword = "roof";
        String url = "jdbc:mysql://localhost:3306/testDB";
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        int queryId = 1;
        String sql = "select id,name,note from department where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, queryId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String note = rs.getString("note");
            System.out.println("id=" + id + ";name=" + name + ";note=" + note);
        }
    }

    public static void add() throws ClassNotFoundException, SQLException {
        String dbUser = "root";
        String dbPassword = "roof";
        String url = "jdbc:mysql://localhost:3306/testDB";
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        String sql = "insert into department(name,note) values(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "财务部");
        ps.setString(2, "财务部");
        ps.executeUpdate();

       /*Statement st = conn.createStatement();
        String sql = "insert into department(name,note) values('财务部','财务部')";
        st.executeUpdate(sql);*/
    }

    public static void update() throws ClassNotFoundException, SQLException {
        String dbUser = "root";
        String dbPassword = "roof";
        String url = "jdbc:mysql://localhost:3306/testDB";
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        String sql = "update department set note= '财务部备注信息' where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 3);
        ps.executeUpdate();
    }

    public static void delete() throws ClassNotFoundException, SQLException {
        String dbUser = "root";
        String dbPassword = "roof";
        String url = "jdbc:mysql://localhost:3306/testDB";
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        String sql = "delete from department where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 1);
        ps.executeUpdate();
    }
}

