package com.lyy.Service;

import domain.User;

/**
 * @description:
 * @author: Moon
 */

public interface UserService {

    /**
     * 注册业务
     * @param user
     */
    public void register(User user);

    /**
     * 登录业务
     * @param user
     * @return 如果为null，表示登录失败
     */
    public User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回false表示用户名已存在，不可用，返回true表示可用
     */
    public boolean existsUserName(String username);
}
