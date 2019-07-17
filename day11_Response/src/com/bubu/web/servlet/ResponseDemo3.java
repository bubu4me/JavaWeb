package com.bubu.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 流的默认编码：ISO-8859-1，此处需要设置编码格式：UTF-8
        // 方式1
//        resp.setCharacterEncoding("UTF-8");
        // 方式2
//        resp.setHeader("content-type","text/html;charset=utf-8");
        // 方式3
        resp.setContentType("text/html;charset=utf-8");
        // 获取字符输出流并输出数据
        resp.getWriter().write("你好哇! kkkkkkk");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
