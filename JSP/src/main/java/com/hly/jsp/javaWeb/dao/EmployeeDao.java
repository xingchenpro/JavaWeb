package com.hly.jsp.javaWeb.dao;
import com.hly.jsp.javaWeb.entity.Employee;
import java.util.List;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/11/29
 */
public interface EmployeeDao {
    //C
    public int add(Employee employee);
    //R
    public List<Employee> selectAll();
    public List<Employee> query(String name);
    //U
    public int  update(Employee employee);
    //D
    public int delete (int id);

}
