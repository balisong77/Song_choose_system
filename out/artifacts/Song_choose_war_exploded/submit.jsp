<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/21
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>欢迎进入点歌系统</title>
  </head>
  <body>

  <div style="text-align: center;padding: 300px">
    <form action="<%=request.getContextPath()%>/add.udo" method="post">
      歌名:<input type="text" name="song"><br>
      歌手名:<input type="text" name="singer"><br>
      姓名:<input type="text" name="name"><br>
      学院:<input type="text"name="college"><br>
      班级:<input type="text" name="classname"><br>
      手机号码:<input type="text" name="phoneNum"><br>
      想送给谁:<input type="text" name="toname"><br>
      ta的所在的学院:<input type="text" name="to_college"><br>
      想说的话:<input type="text" name="message"><br>
      希望播放的日期<input type="datetime-local" name="datetime"><br>
      是否匿名:<input type="checkbox" name="is_anonymous"><br>
      <input type="submit" value="submit" name="submit">
    </form>

    <a href="admin.jsp">管理系统</a>

  </div>
  </body>
</html>
