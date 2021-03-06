package com.bubu.web.servlet;

import com.bubu.service.UserService;
import com.bubu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectedServlet")
public class DeleteSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取所有id
        String[] ids = request.getParameterValues("uid");

        // 2.调用service删除
        UserService service = new UserServiceImpl();
        service.deleteSelectedUser(ids);

        // 3.跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
