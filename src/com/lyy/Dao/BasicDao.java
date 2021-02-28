package com.lyy.Dao;

import com.lyy.Utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 * @author: Moon
 */

public class BasicDao<T> {
    /**
     * 封装通用的增删改方法
     */
    QueryRunner qr = new QueryRunner();

    /**
     * 通用的修改方法
     *
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            int update = qr.update(connection, sql, params);
            return update;
        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    /**
     * 返回单个对象
     *
     * @param sql
     * @param clazz
     * @param params
     * @return 返回对象，如果为null表示不存在该对象
     */
    public T queryOne(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            //执行查询
            return qr.query(connection, sql, new BeanHandler<T>(clazz), params);

        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }

    /**
     * 返回多个对象
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public List<T> queryMult(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            //执行查询
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), params);

        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }


    /**
     * 查询单个值
     *
     * @param sql
     * @param clazz
     * @param params
     * @return
     */
    public Object scalar(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            //执行查询
            return qr.query(connection, sql, new ScalarHandler(), params);

        } catch (SQLException throwables) {
            throw new RuntimeException();
        }
    }
}
