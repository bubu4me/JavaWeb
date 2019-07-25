package com.bubu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 4.测试过滤器配置详解 - 2.拦截方式配置
// 2.1浏览器直接请求index.jsp资源时，该过滤器才会被执行
//@WebFilter(value = "/index.jsp", dispatcherTypes = DispatcherType.REQUEST)

// 2.2浏览器只有在转发访问index.jsp资源时，该过滤器才会被执行
@WebFilter(value = "/index.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FilterDemo5 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo5.....");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
