<%@ page import="model.Info" %>
<%@ page import="dao.InfoDaoimp" %>
<%@ page import="dao.FactoryDao" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/24
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>
    <%

        String uuid = (String) request.getAttribute("uuid");
        System.out.println(uuid);
        InfoDaoimp dao = FactoryDao.getInfoDaoimp();
        Info i = dao.getInfoByuuid(uuid);
        String[] status = {"","待处理","已播放","被退回"};
    %>
    <table>
        <tr>
            <th>歌名</th>
            <th>歌手</th>
            <th>日期</th>
            <th>播放状态</th>
        </tr>

        <tr>
            <td><%=i.getSong()%></td>
            <td><%=i.getSinger()%></td>
            <td><%=i.getDate_time()%></td>
            <td><%=status[i.getStatus_code()]%></td>
        </tr>
    </table>
</body>
</html>
