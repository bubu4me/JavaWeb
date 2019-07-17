package com.bubu.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 演示Request对象获取请求行数据
 */

@WebServlet("/requestDemo1")
public class requestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1. 获取请求方式：GET
         *    - String getMethod()
         * 2. 获取虚拟目录：/demo
         *    - String getContextPath()
         * 3. 获取Servlet路径：/MyServlet4URL
         *    - String getServletPath()
         * 4. 获取get方式请求参数：name=aaaa
         *    - String getQueryString()
         * 5. 获取请求URI：/demo/MyServlet4URL
         *    - String getRequestURI():       /demo/MyServlet4URL
         *    - StringBuffer getRequestURL(): http://localhost/demo/MyServlet4URL
         * 6. 获取协议及版本：HTTP/1.1
         *    - String getProtocol()
         * 7. 获取客户机的IP地址
         *    - String getRemoteAddr()
         */

        System.out.println("path: "+request.getContextPath());// path:
        System.out.println("URI: "+request.getRequestURI());// URI: /requestDemo1

        // Enumeration<E>遍历所有请求头信息
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            System.out.println(name+"---"+request.getHeader(name));
        }

    }
}
