package com.lyy.Dao;

import domain.User;

public interface UserDao {

    /**
     * 注册操作
     * 根据用户名查询用户信息
     * @param username
     * @return 如果返回null，说明没有这个用户
     */
    public User queryUserByName(String username);


    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int save(User user);

    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return 返回null表示用户名或密码错误
     */
    public User queryUserByNameAndPaw(String username,String password);
}
