package com.bubu.web.servlet;

import com.bubu.domain.User;
import com.bubu.service.UserService;
import com.bubu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取id
        String id = request.getParameter("id");

        // 2.根据id查询用户信息
        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        // 3.将user对象存到request
        request.setAttribute("user",user);

        // 4.转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
