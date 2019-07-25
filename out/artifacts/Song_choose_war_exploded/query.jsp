<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/24
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询系统</title>

</head>
<body>
<div style="text-align: center;padding: 300px">
    <form action="<%=request.getContextPath()%>/query.udo"method="post" style="text-align: center">
        <p>请输入您的歌曲查询码</p><br>
        <input type="text" name="query_uuid" ><br>
        <input type="submit" value="提交" id="check_button" onclick="display_form()">
    </form>
</div>

</body>
</html>
