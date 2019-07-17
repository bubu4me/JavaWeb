<%--
  Created by IntelliJ IDEA.
  User: bubu
  Date: 2019/7/14
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <script>
        window.onload = function () {
            document.getElementById("checkCodeImg").onclick = function () {
                this.src = "/checkcodeServlet?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: firebrick;
        }
    </style>
</head>
<body>
    <form action="/loginServlet" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>验证码:</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img src="/checkcodeServlet" id="checkCodeImg"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </form>

    <div><%= request.getAttribute("cc_error")%></div>
    <div><%= request.getAttribute("login_error")%></div>
</body>
</html>
