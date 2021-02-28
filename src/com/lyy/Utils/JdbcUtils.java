package com.lyy.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @description: 通过Druid数据库连接池获取连接对象
 * @author: Moon
 */

public class JdbcUtils {
    static DataSource ds = null;
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();

    static {
        Properties properties = new Properties();
        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);

            //1.创建一个指定参数的数据库连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接方法
     *
     * @return connection
     */
    public static Connection getConnection() {
        Connection conn = conns.get();
        if (conn == null) {
            try {
                conn = ds.getConnection();
                conns.set(conn);
                //设置事务，手动管理
                conn.setAutoCommit(false);
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public static void commit() {
        Connection connection = conns.get();
        //不为空，之前操作过数据库
        if (connection != null) {
            try {
                connection.commit();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }

    public static void rollBack() {
        Connection connection = conns.get();
        //不为空，之前操作过数据库
        if (connection != null) {
            try {
                connection.rollback();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();
    }

    /**
     * 关闭连接方法
     *
     * @param set
     * @param statement
     * @param connection
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
