package com.bubu.web.filter;

import javax.servlet.*;
import java.io.IOException;

// 3.测试过滤器生命周期方法

//@WebFilter("/*")
public class FilterDemo3 implements Filter {

    /**
     * 每一次请求被拦截资源时，会执行。执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 对request对象请求消息增强
        System.out.println("filterDemo3执行了。。。");

        // 放行
        chain.doFilter(req, resp);

        // 对response对象的响应消息增强
        System.out.println("filterDemo3回来了。。。");
    }

    /**
     * 在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次，用于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("init...");
    }

    /**
     * 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
     */
    public void destroy() {
        System.out.println("destroy...");
    }
}
