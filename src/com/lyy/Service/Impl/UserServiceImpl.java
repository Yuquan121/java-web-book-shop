package com.lyy.Service.Impl;

import com.lyy.Dao.UserDao;
import com.lyy.Dao.impl.UserDaoImpl;
import com.lyy.Service.UserService;
import domain.User;

/**
 * @description:
 * @author: Moon
 */

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        userDao.save(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByNameAndPaw(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUserName(String username) {

        if(userDao.queryUserByName(username) == null){
            return false;
        }
        return true;
    }
}
