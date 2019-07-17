<%--
  Created by IntelliJ IDEA.
  User: bubu
  Date: 2019/7/13
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <%
        // 在_jspService()方法中
        System.out.println("hello, jsp");
        int i = 5;
    %>

    <%!
        int i = 3;// 属于成员变量
    %>

    <%=
        i// 就近原则,所以输出_jspService()方法中的变量
    %>
</body>
</html>
