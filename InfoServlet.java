package Servlet;

import Service.MessageBoardService;
import User.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
    //service的单例
    MessageBoardService messageBoardService;

    @Override
    public void init(){
        messageBoardService=MessageBoardService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        List<Message> messageList= null;
        try {
            messageList = messageBoardService.findAllMessages(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String res=messageBoardService.messagesToJson(messageList);

        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
        writer.write(res);
        writer.flush();
        writer.close();
    }
}
