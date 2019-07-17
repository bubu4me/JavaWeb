package com.bubu.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.通过HttpServletContext来获取
        ServletContext servletContext = getServletContext();

        // 2.定义文件名称
        String fileName = "a.jpg";

        // 3.获取MIME类型
        String mimeType = servletContext.getMimeType(fileName);
        System.out.println(mimeType);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
