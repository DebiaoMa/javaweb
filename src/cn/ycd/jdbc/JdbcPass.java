package cn.ycd.jdbc;

import cn.ycd.utils.JdbcUtil;

import java.sql.*;
import java.util.Scanner;

public class JdbcPass {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("username:");
        String username = scan.nextLine();
        System.out.println("password");
        String password = scan.nextLine();

        boolean flag = new JdbcPass().login(username, password);

        if(flag) {
            System.out.println("登陆成功");
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    public boolean login (String username, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        if (username == null || password == null) {
            return false;
        }

        try {
            conn = JdbcUtil.getConnection();

            String sql = "select * from user where username = ? and password = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, pstmt, conn);
        }

        return false;
    }
}
