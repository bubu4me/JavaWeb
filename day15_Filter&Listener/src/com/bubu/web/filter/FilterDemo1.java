package com.bubu.web.filter;

import javax.servlet.*;
import java.io.IOException;

// 1.测试web.xml配置
//@WebFilter("/*") // 配置拦截路径，访问所有资源之前，都会执行该过滤器
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filterdemo1");

        // 拦截后记得放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
