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
public class DirtyReadTest {

    public static void main(String[] args) throws InterruptedException, SQLException {
        Thread thread1 = new Thread1();
        thread1.start();
        Thread thread2 = new Thread2();
        thread2.start();
    }
}

// InsertThread线程模拟在一个事务中进行插入数据、回滚操作。
class Thread1 extends Thread {
    Connection conn = null;

    public Thread1() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void run() {
        try {
            conn.setAutoCommit(false);
            String sql = "insert into employee(id,name) values(?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 4);
            ps.setString(2, "Tom");
            ps.executeUpdate();

            Thread.sleep(1000);

            conn.rollback();
            Thread.sleep(1000);

            conn.commit();

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Thread2 extends Thread {
    Connection conn = null;

    public Thread2() throws SQLException {
        conn = DBConnection.getConnection();
    }

    @Override
    public void run() {
        try {
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            String sql = "select * from employee";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeQuery();
            System.out.println("线程2第1次读取线程1插入但是未提交的数据");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id=" + id + ";name=" + name);
            }
            // 第一次读取结束后，线程2休眠
            Thread.sleep(1000);
            // 此时进行thread1的回滚，thread1休眠，线程2再次查询线程1回滚后的数据
            System.out.println("线程2第2次读取线程1回滚但是未提交的数据");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id=" + id + ";name=" + name);
            }

            conn.commit();

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

