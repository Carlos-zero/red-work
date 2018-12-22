package Servlet;

import Service.MessageBoardService;
import User.Message;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;

@WebServlet("/send")
public class SendServlet extends HttpServlet {
    /**
     * 这里使用两个静态常量 来节省开销
     */
    //失败
    private static final String ERROR="{\"status\":\"10001\"}";
    //成功
    private static final String OK="{\"status\":\"10000\"}";

    //service的单例
    private MessageBoardService messageBoardService;

    @Override
    public void init(){
        messageBoardService = MessageBoardService.getInstance();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException{
//        HttpSession session=request.getSession();
//        String username= (String) session.getAttribute("username");
        String username=request.getParameter("username");
        String text=request.getParameter("text");
        int pid=Integer.parseInt(request.getParameter("pid"));          //pid=这层留言的ID   怎么获取这层留言的id

        Message message=new Message(username,text,pid);

        String res=ERROR;

        //如果插入成功  返回成功
        try {
            if (messageBoardService.insertContent(message)){
                res=OK;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));

        writer.write(res);
        writer.flush();
        writer.close();
    }
}
