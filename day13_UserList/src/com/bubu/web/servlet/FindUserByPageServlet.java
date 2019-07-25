package com.bubu.web.servlet;

import com.bubu.domain.PageBean;
import com.bubu.domain.User;
import com.bubu.service.UserService;
import com.bubu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        // 1.接收请求参数currentPage，rows
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");
        // 由于index.jsp直接可以访问/findUserByPageServlet
        // 所以要对currentPage和rows赋初始值，否则报错
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        // 获取查询条件参数
        Map<String, String[]> condition = request.getParameterMap();

        // 2.调用service查询PageBean
        UserService service = new UserServiceImpl();
        PageBean<User> pageBean = service.findUserByPage(currentPage, rows, condition);

        // 3.将PageBean存入request
        request.setAttribute("pageBean", pageBean);
        // 将查询条件存入request
        request.setAttribute("condition",condition);

        // 4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
