package cn.ycd.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 文件读取，只读取一次就拿到所有的值
     * 使用静态代码块
     */
    static {

        //使用Properties集合类
        try {
            Properties pro = new Properties();

            //获取src路径下的文件的方式---> ClassLoader 类加载器
            //可以动态获取src下的properties路径
            ClassLoader classLoader = JdbcUtil.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
//            System.out.println(path);
            pro.load(new FileReader(path));

//            pro.load(new FileReader("src/jdbc.properties"));

            //获取数据
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection () throws SQLException {

        return DriverManager.getConnection(url,user,password);
    }

    public static void close(Statement stmt, Connection conn) {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
