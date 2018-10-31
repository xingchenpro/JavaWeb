package com.hly.java.JDBC;

import java.sql.*;

/**
 * @author :黄良运
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/20
 */
public class CrudEmployeeTestByPS {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        add();
        //update();
        //delete();
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
        String sql = "select id,name,note from employee";
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
        String sql = "select id,name,note from employee where id = ?";
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
        String sql = "insert into employee(name,note) values(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "Mike");
        ps.setString(2, "来发部");
        ps.executeUpdate();

       /*Statement st = conn.createStatement();
        String sql = "insert into employee(name,note) values('财务部','财务部')";
        st.executeUpdate(sql);*/
    }

    public static void update() throws ClassNotFoundException, SQLException {
        String dbUser = "root";
        String dbPassword = "roof";
        String url = "jdbc:mysql://localhost:3306/testDB";
        String driverName = "com.mysql.jdbc.Driver";

        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
        String sql = "update employee set note= '财务部备注信息' where id = ?";
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
        String sql = "delete from employee where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, 1);
        ps.executeUpdate();
    }
}
