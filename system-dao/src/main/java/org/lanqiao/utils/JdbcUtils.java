package org.lanqiao.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcUtils {
    private static DataSource ds = null;
    static {
        //数据源只能被创建一次
        ds = new ComboPooledDataSource("mvcdemo");

    }
    public static DataSource getDs(){
        return ds;
    }
    /**
     * 释放Connection连接
     */
    public static void releaseConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
