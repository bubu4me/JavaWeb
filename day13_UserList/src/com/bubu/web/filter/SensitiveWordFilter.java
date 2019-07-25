package com.bubu.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 创建代理对象，增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 判断是否getParameter方法
                if (method.getName().equals("getParameter")) {
                    // 获取返回值
                    String value = (String) method.invoke(req, args);

                    // 判断返回值是否是敏感词汇
                    if (value != null) {
                        for (String str : list) {
                            if (value.contains(str)) {
                                value = value.replaceAll(str, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(req, args);
            }
        });

        chain.doFilter(proxy_req, resp); // 注意此处放行的是代理对象，否则不起作用
    }

    private List<String> list = new ArrayList<String>();// 敏感词汇集合

    public void init(FilterConfig config) throws ServletException {
        // 首先确定编码格式，以防读取乱码
        try {
            // 根据敏感词汇.txt的真实路径
            ServletContext context = config.getServletContext();
            String realPath = context.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            // 创建输入字符流,指定字符集，否则可能乱码
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "UTF-8"));

            // 读取txt数据
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}
