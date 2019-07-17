package com.bubu.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 获取文件的真实路径
 */
@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过HttpServletContext来获取
        ServletContext servletContext = getServletContext();

        // 2.获取文件的真实路径
        String bRealPath = servletContext.getRealPath("b.txt");// web目录下资源访问
        System.out.println(bRealPath);

        String cRealPath = servletContext.getRealPath("/WEB-INF/c.txt");// WEB-INF目录下的资源访问
        System.out.println(cRealPath);

        String aRealPath = servletContext.getRealPath("/WEB-INF/classes/a.txt");// src目录下的资源访问
        System.out.println(aRealPath);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
