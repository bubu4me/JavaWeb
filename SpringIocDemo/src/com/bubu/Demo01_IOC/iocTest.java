package com.bubu.Demo01_IOC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class iocTest {
    public static void main(String[] args){
        // IOC：Inverse Of Control
        ApplicationContext context = new ClassPathXmlApplicationContext("com/bubu/Demo01_IOC/applicationContext.xml");
        Student student = (Student) context.getBean("studentId");
        System.out.println(student);

        // 从Spring容器获得
        // 1、获取容器对象
        UserServiceImpl usi = (UserServiceImpl)context.getBean("userServiceId");
        // 2、调用方法
        usi.addUser();







    }
}
