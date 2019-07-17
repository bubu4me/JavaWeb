package com.bubu.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo2")
public class requestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String refererValue = request.getHeader("referer");
        System.out.println(refererValue);// http://localhost:8080/login.html

        // 防盗链
        if(refererValue!=null){
            if(refererValue.contains("/requestDemo2")){
                System.out.println("播放电影");
                // 在页面上显示
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影...");
            }else {
                // 盗链
                System.out.println("想看不");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("来优酷吧...");
            }
        }
    }
}
