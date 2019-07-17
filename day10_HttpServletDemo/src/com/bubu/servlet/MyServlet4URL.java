package com.bubu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/demo/MyServlet4URL")// 多层路径
//@WebServlet("/demo/*")// *通配符，可写任意名称
//@WebServlet("*.do")// *通配符，可写任意名称
@WebServlet("/MyServlet4URL")
public class MyServlet4URL extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MyServlet4URL...");
        System.out.println(req);
    }
}
