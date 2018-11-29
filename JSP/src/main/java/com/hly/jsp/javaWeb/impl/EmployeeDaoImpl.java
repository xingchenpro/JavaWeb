package com.hly.jsp.javaWeb.impl;
import com.hly.jsp.javaWeb.dao.DBConnection;
import com.hly.jsp.javaWeb.dao.EmployeeDao;
import com.hly.jsp.javaWeb.entity.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/29
 */
public class EmployeeDaoImpl implements EmployeeDao {

    //增
    @Override
    public int add(Employee employee) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into employee(name,note) values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getNote());
            ps.executeUpdate();
            DBConnection.close(null,ps,con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    //查全部
    @Override
    public List<Employee> selectAll() {

        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select id,name,note from employee";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setNote(rs.getString(3));
                list.add(employee);
            }
            DBConnection.close(rs,ps,con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据 id 查
    @Override
    public List<Employee> query(String name) {

        Employee employee = null;
        List<Employee> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "select id,name,note from employee where name like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            //模糊查询
            ps.setString(1,"%"+name+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setName(rs.getString(2));
                employee.setNote(rs.getString(3));
                list.add(employee);
            }
            DBConnection.close(rs,ps,con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //更新
    @Override
    public int update(Employee employee) {

        try {
            Connection con = DBConnection.getConnection();
            String sql = "update employee set name = ?,note = ? where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,employee.getName());
            ps.setString(2,employee.getNote());
            ps.setInt(3,employee.getId());
            ps.executeUpdate();
            DBConnection.close(null,ps,con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    //删除
    @Override
    public int delete(int id) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from employee where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            DBConnection.close(null,ps,con);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
