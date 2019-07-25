package com.bubu.web.filter;

import javax.servlet.*;
import java.io.IOException;

// 4.测试过滤器配置详解 - 1.拦截路径配置

//@WebFilter("/index.jsp") // 1.具体资源路径：/index.jsp 代表只有访问index.jsp资源时，过滤器才会被执行
//@WebFilter("/user/*") // 2.拦截目录：/user/* 访问某个文件夹下的所有资源时，都会被执行
//@WebFilter("*.jsp") // 3.后缀名拦截：*.jsp 访问所有后缀名为jsp资源时，过滤器都会被执行
//@WebFilter("/*") // 4.拦截所有资源：/* 访问所有资源时，过滤器都会被执行

public class FilterDemo4 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
