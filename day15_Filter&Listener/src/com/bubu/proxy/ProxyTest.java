package com.bubu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        // 1.创建真实对象
        Lenovo lenovo = new Lenovo();

        // 2.动态代理增强Lenovo对象
        /**
         * 三个参数：
         * 1.类加载器：真实对象.getClass().getClassLoader()
         * 2.接口数组：真实对象.getClass().getInterfaces()
         * 3.处理器：new InvocationHandler()
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行
             * @param proxy 代理对象，一般不用
             * @param method 代理对象调用的方法，被封装为的对象（反射）
             * @param args 代理对象调用的方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("代理模式执行。。。。。");
//                System.out.println(method.getName());
//                if (args != null)
//                    System.out.println(args[0]);
//                return null;

                // 判断是否是sale方法
                if (method.getName().equals("sale")) {
                    // 增强参数
                    double money = (double) args[0];
                    money *= 0.8;

                    // 增强方法体执行逻辑
                    System.out.println("专车接送。。。");

                    // 使用真实对象调用调用该方法
                    String obj = (String) method.invoke(lenovo, money);

                    // 增强方法体执行逻辑
                    System.out.println("免费送货");

                    // 增强返回值
                    return obj + "_鼠标";
                } else {
                    String obj = (String) method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        // 调用方法
//        String computer = proxy_lenovo.sale(8000); // 触发invoke(),输出：代理模式执行。。。。。\n sale \n 8000.0
//        System.out.println(computer); // 输出：null
//        proxy_lenovo.show();// 触发invoke(),输出：代理模式执行。。。。。\n show

        // 增强方式演示
        String computer = proxy_lenovo.sale(8000);
        /*  调用了增强的方法，输出：
            专车接送。。。
            卖出电脑：6400.0
            免费送货
         */
        System.out.println(computer);// Lenovo_鼠标
        proxy_lenovo.show(); // Lenovo show 可见调用了原方法
    }
}
