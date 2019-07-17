package com.bubu.Demo02_DI;

public class BookDaoImpl implements BookDao {

    @Override
    public void addBook() {
        System.out.println("DI add book");
    }
}
