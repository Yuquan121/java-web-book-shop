package com.lyy.Dao.impl;

import com.lyy.Dao.BasicDao;
import com.lyy.Dao.UserDao;
import com.lyy.Dao.BasicDao;
import domain.User;

/**
 * @description:
 * @author: Moon
 */

public class UserDaoImpl extends BasicDao implements UserDao {
    @Override
    public User queryUserByName(String username) {
        String sql = "select `id`,`username`,`password`,'email' from t_user where username = ?";
        return (User) queryOne(sql,User.class,username);
    }

    @Override
    public User queryUserByNameAndPaw(String username, String password) {
        String sql = "select `id`,`username`,`password`,'email' from t_user where username = ? and password = ?";
        return (User) queryOne(sql,User.class,username,password);
    }

    @Override
    public int save(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());

    }
}
