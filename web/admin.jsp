<%@ page import="model.Info" %>
<%@ page import="java.util.List" %>
<%@ page import="service.InfoService" %>
<%@ page import="dao.InfoDaoimp" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/23
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理系统</title>
    <style>
        td {text-align:center}
    </style>
</head>
<body>
<script>
    function success() {
        alert("修改成功")
    }

</script>
    <%
        String is_login = (String) session.getAttribute("is_login");
        if( is_login == null || "".equals(is_login)){
            response.sendRedirect(request.getContextPath() + "/admin_login.jsp");
        }
    %>
<%--待处理歌曲的表格--%>
    <div >
        <p>待处理的歌曲</p><br>
        <table width="100%" border="0" cellspacing="1" cellpadding="4" bgcolor="#cccccc" align="center">
            <tr>
                <th>歌名:</th>
                <th>歌手:</th>
                <th>姓名:</th>
                <th>学院:</th>
                <th>班级:</th>
                <th>手机号码:</th>
                <th>想送给谁:</th>
                <th>ta的学院</th>
                <th>想说的话:</th>
                <th>是否匿名:</th>
                <th>希望播放的日期:</th>
                <th>播放状态:</th>
            </tr>
        <%
            String[] status = {"","待处理","已播放","被退回","已过期"};
            String[] anonymous = {"否","是"};
            InfoDaoimp dao = new InfoDaoimp();
            List<Info> list = dao.getAllComingUnhaddel();
            for(Info i: list){
        %>
            <tr>
                <td><%=i.getSong()%></td>
                <td><%=i.getSinger()%></td>
                <td><%=i.getName()%></td>
                <td><%=i.getCollege_name()%></td>
                <td><%=i.getClass_name()%></td>
                <td><%=i.getPhone_num()%></td>
                <td><%=i.getTo_name()%></td>
                <td><%=i.getTo_college()%></td>
                <td><%=i.getMessage()%></td>
                <td><%=anonymous[i.getIs_anonymous()]%></td>
                <td><%=i.getDate_time()%></td>
                <td><%=status[i.getStatus_code()]%></td>

                <!--删除按钮-->
                <td>
                    <form action="<%=request.getContextPath()%>/alter.udo"method="post">
                        <input hidden type="text" value="<%=i.getId()%>" name="id">
                        <input hidden type="text" value="2" name="status">
                        <input type="submit" value="播放">
                    </form>
                </td>


                <td>
                    <form action="<%=request.getContextPath()%>/alter.udo"method="post">
                        <input hidden type="text" value="<%=i.getId()%>" name="id">
                        <input hidden type="text" value="3" name="status">
                        <input type="submit" value="退回">
                    </form>
                </td>
                <td>
                    <form action="<%=request.getContextPath()%>/delete.udo" method="post">
                        <input hidden type="text" value="<%=i.getId()%>" name="delete">
                        <input type="submit" value="删除">
                    </form>
                </td>
                <td>
                    <form action="<%=request.getContextPath()%>/update.udo" method="post">
                        <input type="text" name="id" hidden="hidden" value="<%=i.getId()%>">
                        <input type="datetime-local" name="date">
                        <input type="submit" value="修改日期" onclick="success()">
                    </form>
                </td>


            </tr>

        <%
            }
        %>
        </table>
    </div>

<%--已过期或已处理歌曲的表格--%>
<div >
    <p>已处理或过期的歌曲(不包含被删除的歌曲)</p><br>
    <table width="100%" border="0" cellspacing="1" cellpadding="4" bgcolor="#cccccc" align="center">
        <tr>
            <th>歌名:</th>
            <th>歌手:</th>
            <th>姓名:</th>
            <th>学院:</th>
            <th>班级:</th>
            <th>手机号码:</th>
            <th>想送给谁:</th>
            <th>ta的学院</th>
            <th>想说的话:</th>
            <th>是否匿名:</th>
            <th>希望播放的日期:</th>
            <th>播放状态:</th>
        </tr>
        <%
            list = dao.getAllHaddeled();
            for(Info i: list){
                if(i.getDate_time().before(new Date())){
                    dao.alterStatuscode("4",i.getId()+"");
                    i.setStatus_code(4);
                }
        %>
        <tr>
            <td><%=i.getSong()%></td>
            <td><%=i.getSinger()%></td>
            <td><%=i.getName()%></td>
            <td><%=i.getCollege_name()%></td>
            <td><%=i.getClass_name()%></td>
            <td><%=i.getPhone_num()%></td>
            <td><%=i.getTo_name()%></td>
            <td><%=i.getTo_college()%></td>
            <td><%=i.getMessage()%></td>
            <td><%=anonymous[i.getIs_anonymous()]%></td>
            <td><%=i.getDate_time()%></td>
            <td><%=status[i.getStatus_code()]%></td>

            <td>
                <form action="<%=request.getContextPath()%>/delete.udo" method="post">
                    <input hidden type="text" value="<%=i.getId()%>" name="delete">
                    <input type="submit" value="删除">
                </form>
            </td>

        </tr>

        <%
            }
        %>
    </table>
</div>
</body>
</html>
