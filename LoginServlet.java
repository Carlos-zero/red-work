package Servlet;

import User.User;
import dao.UserSql;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收请求参数
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        PrintWriter out=response.getWriter();
        UserSql userSql=new UserSql();

        try {
            User user=userSql.login(username,password);
            if (userSql.login(username,password)!=null){
                HttpSession session=request.getSession();
                session.setAttribute("username",user.getUsername());                //利用session将用户名传过去
                response.sendRedirect(request.getContextPath()+"/message.jsp");   //页面跳转到留言板
            }else {
                response.sendRedirect(request.getContextPath()+"/login.jsp");   //密码错误  接着登录
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
