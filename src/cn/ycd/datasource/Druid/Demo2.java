package cn.ycd.datasource.Druid;

import cn.ycd.datasource.utils.JdbcUtil;
import com.alibaba.druid.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = JdbcUtil.getConnection();

            String sql = "insert into account values(null, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, "hanat");
            preparedStatement.setInt(2, 60000);

            int count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(null, preparedStatement, connection);
        }
    }
}
