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
public class IsolationSetTest {

    public static void main(String[] args) {
        setIsolation();
    }

    public static void setIsolation() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBConnection.getConnection();

            conn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            int transaction_read_uncommitted = conn.getTransactionIsolation();
            System.out.println(transaction_read_uncommitted);

            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            int transaction_read_committed = conn.getTransactionIsolation();
            System.out.println(transaction_read_committed);

            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            int transaction_repeatable_read = conn.getTransactionIsolation();
            System.out.println(transaction_repeatable_read);

            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            int transaction_serializable = conn.getTransactionIsolation();
            System.out.println(transaction_serializable);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, ps, conn);
        }
    }


}
