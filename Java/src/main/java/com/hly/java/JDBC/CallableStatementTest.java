package com.hly.java.JDBC;

import java.sql.*;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/31
 */
public class CallableStatementTest {

    public static void main(String[] args) {
        getEmployeeNameById();
    }

    public static void getEmployeeNameById() {
        Connection conn = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            // 存储过程函数格式：{call getEmployeeNameById(?,?)}
            conn = DBConnection.getConnection();
            // ① 定义调用存储过程的SQL语句
            String sql = "{call getEmployeeNameById(?,?)}";
            // ② 获取CallableStatement对象
            cs = conn.prepareCall(sql);
            // ③ 设置参数（可选）
            cs.setInt(1, 1);
            cs.registerOutParameter(2, Types.VARCHAR);
            // ④ 执行存储过程
            cs.execute();
            // ⑤ 获得输出参数值（可选）
            String userName = cs.getString(2);
            System.out.println(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, cs, conn);
        }
    }

}
