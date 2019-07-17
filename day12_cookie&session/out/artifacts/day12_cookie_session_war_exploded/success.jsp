<%--
  Created by IntelliJ IDEA.
  User: bubu
  Date: 2019/7/14
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
    <h1><%=request.getSession().getAttribute("user")+"欢迎您！"%></h1>
</body>
</html>
