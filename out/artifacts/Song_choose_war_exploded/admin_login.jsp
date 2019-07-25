<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/25
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<div style="text-align: center;padding: 300px">
    <%
        if("false".equals((String) session.getAttribute("login"))){
    %>
        <div>
            <p style="color: red">用户名或密码错误</p>
        </div>
    <%
        }
    %>
    <form method="post" action="<%=request.getContextPath()%>/login.udo" >
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        <input type="submit" value="提交"><br>
    </form>
</div>

</body>
</html>
