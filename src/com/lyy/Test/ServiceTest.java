package com.lyy.Test;

import com.lyy.Service.Impl.UserServiceImpl;
import com.lyy.Service.UserService;
import domain.User;
import org.junit.Test;

/**
 * @description:
 * @author: Moon
 */

public class ServiceTest {
    UserService us = new UserServiceImpl();
    @Test
    public void register(){
        us.register(new User(null,"abc","123456","abc@163.com"));
        us.register(new User(null,"bcd","123456","bcd@163.com"));
    }

    @Test
    public void login(){
        System.out.println(us.login(new User(null,"abdfgfdc","12432543656","abc@163.com")));
    }
}
