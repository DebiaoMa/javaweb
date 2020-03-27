package cn.ycd.jdbc;

import cn.ycd.domain.Emp;
import cn.ycd.utils.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcImport {
    public static void main(String[] args) {
        List<Emp> list = new JdbcImport().findAll2();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<Emp> findAll() {

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///runoob?characterEncoding=utf-8&serverTimezone=GMT", "root", "cnmdsql");

            String sql = "select * from students";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nickname = rs.getString("nickname");
                String sex = rs.getString("sex");
                Date in_time = rs.getDate("in_time");  //此处Date为sql下的data  为utildate的子类，而子类对象装载父类

                emp = new Emp();

                emp.setId(id);
                emp.setName(name);
                emp.setNickname(nickname);
                emp.setSex(sex);
                emp.setIn_time(in_time);

                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    /**
     * 演示properties
     * @return
     */
    public List<Emp> findAll2() {

        Statement stmt = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql:///runoob?characterEncoding=utf-8&serverTimezone=GMT", "root", "cnmdsql");
            conn = JdbcUtil.getConnection();
            String sql = "select * from students";

            stmt = conn.createStatement();

            rs = stmt.executeQuery(sql);
            Emp emp = null;
            list = new ArrayList<Emp>();
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nickname = rs.getString("nickname");
                String sex = rs.getString("sex");
                Date in_time = rs.getDate("in_time");  //此处Date为sql下的data  为utildate的子类，而子类对象装载父类

                emp = new Emp();

                emp.setId(id);
                emp.setName(name);
                emp.setNickname(nickname);
                emp.setSex(sex);
                emp.setIn_time(in_time);

                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {

            JdbcUtil.close(rs, stmt, conn);
        }

        return list;
    }
}
