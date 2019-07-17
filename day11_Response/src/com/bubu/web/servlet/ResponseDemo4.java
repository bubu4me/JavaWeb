package com.bubu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方式1
//        resp.setCharacterEncoding("UTF-8");
        // 方式2
//        resp.setHeader("content-type","text/html;charset=utf-8");
        // 方式3
        resp.setContentType("text/html;charset=utf-8");
        // 获取字节流并输出数据
        resp.getOutputStream().write("你好，kkkkkk".getBytes("utf-8"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
