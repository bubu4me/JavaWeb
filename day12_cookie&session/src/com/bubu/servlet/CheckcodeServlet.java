package com.bubu.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkcodeServlet")
public class CheckcodeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int width = 100;
        int height = 40;

        // 1.创建一对象，在内存中存储图片（验证码图片对象）
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2.美化图片
        // 2.1填充背景色
        Graphics g = img.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0, 0, width, height);

        // 2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width - 1, height - 1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            // 生成随机角标
            int index = ran.nextInt(str.length());
            char ch = str.charAt(index);

            // 获取随机字符串
            sb.append(ch);

            // 2.3写验证码
            g.drawString(ch + "", width / 5 * i, 3 * height / 5);
        }

        // 将验证码存入session
        String checkCode_session = sb.toString();
        req.getSession().setAttribute("checkCode_session",checkCode_session);

        // 2.4画干扰线
        g.setColor(Color.GREEN);
        for (int i = 0; i < 10; i++) {
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        // 3.将图片输出到页面展示
        ImageIO.write(img, "jpg", resp.getOutputStream());

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
