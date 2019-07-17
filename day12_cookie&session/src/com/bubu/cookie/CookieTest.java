package com.bubu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置响应的消息体的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        // 1.获取所有cookie
        Cookie[] cookies = request.getCookies();

        boolean flag = false;

        // 2.遍历cookie数组
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("lastTime".contains(cookie.getName())) {
                    flag = true;
                    // 不是首次访问
                    // 获取本次访问时间
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String str_date = simpleDateFormat.format(date);

                    // *需要对时间字符串进行编解码，否则在cookie中SimpleDateFormat的空格属于非法字符
                    // java.lang.IllegalArgumentException: An invalid character [32] was present in the Cookie value
                    str_date = URLEncoder.encode(str_date, "utf-8");

                    // 设置cookie值
                    cookie.setValue(str_date);
                    // 设置cookie的存活时间
                    cookie.setMaxAge(30 * 24 * 60 * 60);
                    response.addCookie(cookie);

                    // 获取时间并解码
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");
                    // 在浏览器打印文本
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为：" + value + "</h1>");

                    break;// 找到一个就行啦
                }
            }
        }

        if (cookies == null || cookies.length <= 0 || !flag) {
            // 第一次访问

            // 获取本次访问时间
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str_date = simpleDateFormat.format(date);

            // *需要对时间字符串进行编解码，否则在cookie中SimpleDateFormat的空格属于非法字符
            // java.lang.IllegalArgumentException: An invalid character [32] was present in the Cookie value
            str_date = URLEncoder.encode(str_date, "utf-8");

            // 创建Cookie对象，设置value为首次访问时间
            Cookie cookie = new Cookie("lastTime", str_date);
            // 设置cookie的存活时间
            cookie.setMaxAge(30 * 24 * 60 * 60);
            response.addCookie(cookie);

            // 在浏览器打印文本
            response.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
