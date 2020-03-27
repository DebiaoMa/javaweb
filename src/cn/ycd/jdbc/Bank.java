package cn.ycd.jdbc;

import cn.ycd.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 实务操作
 */
public class Bank {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        try {
            connection = JdbcUtil.getConnection();
            //开启事物
            connection.setAutoCommit(false);

            String sql1 = "update account set bonus = bonus - ? where name = ?";
            String sql2 = "update account set bonus = bonus + ? where name = ?";

            pstmt1 = connection.prepareStatement(sql1);
            pstmt2 = connection.prepareStatement(sql2);

            pstmt1.setInt(1,500);
            pstmt1.setString(2,"lisi");
            pstmt2.setInt(1,500);
            pstmt2.setString(2,"zhangsan");

            pstmt1.executeUpdate();
            pstmt2.executeUpdate();

            //全程没出错
            connection.commit();
        } catch (Exception e) {
            //出错就回滚
            try {
                if (connection != null){
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JdbcUtil.close(pstmt1, connection);
            JdbcUtil.close(pstmt2, null);
        }

    }
}

