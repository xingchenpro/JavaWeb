package com.hly.java.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :hly
 * @github :https://github.com/huangliangyun
 * @blog :blog.csdn.net/Sirius_hly
 * @date :2018/10/31
 */
public class TransactionTest {

    public static void main(String[] args) {
        transfer(1000, 1, 2);
    }

    public static void transfer(float m1, int id1, int id2) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // 事务开始，设置手工提交事务

            String sql = "update user set money=money-? where id=?";
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, m1);
            ps.setInt(2, id1);
            ps.executeUpdate();

			int i = 5 /0;

            String sql2 = "update user set money=money+? where id=?";
            ps = conn.prepareStatement(sql2);
            ps.setFloat(1, m1);
            ps.setFloat(2, id2);
            ps.executeUpdate();
            conn.commit();
            // 事务提交
        } catch (SQLException e) {
            // 事务中某项操作不成功事务回滚
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } finally {
            DBConnection.close(rs, ps, conn);
        }
    }

}
