package com.lyy.Test;

import com.lyy.Dao.UserDao;
import com.lyy.Dao.impl.UserDaoImpl;
import domain.User;
import org.junit.Test;

/**
 * @description:
 * @author: Moon
 */

public class UserDaoImplTest {
    UserDao u= new UserDaoImpl();
    @Test
    public void queryByName(){

        if(u.queryUserByName("admin123") == null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void save(){
        System.out.println(u.save(new User(null,"admin122","123456","ssd@qq.com")));
    }

}
