package com.bubu.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.IOException;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    public ContextLoaderListener() {
    }

    /**
     * 监听ServletContext对象创建。ServletContext对象在服务器启动后自动创建
     * 在服务器启动后自动调用
     *
     * @param sce
     */
    public void contextInitialized(ServletContextEvent sce) {
        // 可以加载资源文件
        // 1.获取路径
        ServletContext context = sce.getServletContext();

        // 2.加载资源文件
        String contextConfigLocation = context.getInitParameter("contextConfigLocation");

        // 3.获取真实路径
        String realPath = context.getRealPath(contextConfigLocation);

        // 4.加载进内存
        try {
            FileInputStream fis = new FileInputStream(realPath);
            System.out.println(fis); // java.io.FileInputStream@8e7cf34 表明配置成功
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("ServletContext对象被创建了。。。。");
    }

    /**
     * 在服务器关闭后，ServletContext对象被销毁。当服务器正常关闭后会调用该方法，不是正常关闭则不会调用
     *
     * @param sce
     */
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象被销毁了。。。。");
    }

}
