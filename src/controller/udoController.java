package controller;

import service.FactoryService;
import service.InfoService;
import utils.generateUuid;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(urlPatterns = {"*.udo"})
public class udoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String mn = req.getServletPath();
        mn = mn.substring(1);
        mn = mn.substring(0,mn.length()-4);
        try {
            Method method = this.getClass().getDeclaredMethod(mn,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        /**
         * 获取参数
         */
        String song = req.getParameter("song");
        String singer = req.getParameter("singer");
        String name = req.getParameter("name");
        String college = req.getParameter("college");
        String classname = req.getParameter("classname");
        String phoneNum = req.getParameter("phoneNum");
        String toname = req.getParameter("toname");
        String message = req.getParameter("message");
        String datetime = req.getParameter("datetime");
        String to_college = req.getParameter("to_college");
        String is_anonymous = req.getParameter("is_anonymous")==null?"0":"1";
        /**
         * 正则表达式来滤去日期中的特殊字符
         */
        String regEx = "[T]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(datetime);
        String date_str = matcher.replaceAll(" ").trim();

        /**
         *生成uuid，并添加状态码
         */
        String uuid = utils.generateUuid.generate();
        String status_code = "1";
        /**
         * 调用对应controller的方法
         */
        InfoService infoService = FactoryService.getInfoService();
        infoService.save(song,singer,name,phoneNum,college,classname,toname,message,date_str,uuid,status_code,to_college,is_anonymous);

        /**
         * 转发来返回结果
         */
        req.setAttribute("uuid",uuid);
        req.getRequestDispatcher("/submit_result.jsp").forward(req,resp);
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("delete");
        InfoService infoService = FactoryService.getInfoService();
        infoService.deleteInfoById(id);
        String path = req.getContextPath();
        resp.sendRedirect(path + "/admin.jsp");
    }
    private void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String uuid = req.getParameter("query_uuid");
        req.setAttribute("uuid",uuid);
        req.getRequestDispatcher("/query_result.jsp").forward(req,resp);
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String datetime= req.getParameter("date");
        String id = req.getParameter("id");
        /**
         * 正则表达式来滤去日期中的特殊字符
         */
        String regEx = "[T]";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(datetime);
        String date_str = matcher.replaceAll(" ").trim();
        InfoService infoService = FactoryService.getInfoService();
        int i = infoService.updateDate(date_str,id);

//        req.setAttribute("is_success",i);
//        req.getRequestDispatcher("/admin.jsp").forward(req,resp);
        String url = req.getContextPath();
        resp.sendRedirect(url+"/admin.jsp");
    }
    private void alter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("id");
        String status = req.getParameter("status");
        InfoService infoService = FactoryService.getInfoService();
        infoService.alterStatuscode(status,id);
        String url = req.getContextPath();
        resp.sendRedirect(url+"/admin.jsp");
    }
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if(username.equals("admin")&&password.equals("admin")){
            session.setAttribute("is_login","true");
            req.getRequestDispatcher("/admin.jsp").forward(req,resp);
        }
        else{
            session.setAttribute("login","false");
            req.getRequestDispatcher("/admin_login.jsp").forward(req,resp);
        }
    }
}
