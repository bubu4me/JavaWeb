package com.bubu.test;

import com.bubu.dao.UserDao;
import com.bubu.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("aaa");
        loginUser.setPassword("123");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
