package com.bubu.Demo02_DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class diTest {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("com/bubu/Demo02_DI/applicationContext.xml");
        BookDaoImpl bookDao = (BookDaoImpl) context.getBean("bookId");
        bookDao.addBook();
    }
}
