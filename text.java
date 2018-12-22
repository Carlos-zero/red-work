package dao;

import Service.MessageBoardService;
import User.Message;

import java.util.List;

public class text {
    public static void main(String args[])throws Exception{
       /* UserSql userSql=new UserSql();
//        int a=userSql.insertUser("tianshi","123");
//        System.out.println(a);
        User b=userSql.login("CCC","1234");
        System.out.println(b.getUsername());*/
       /*MessageBoard messageBoard=new MessageBoard();
       Message message=new Message("angel","test",1);
       messageBoard.insertMessage(message);
       System.out.println(messageBoard.findMessageByPid(2));*/
        Message message=new Message();
        MessageBoardService messageBoardService =new MessageBoardService();
        List<Message> list=messageBoardService.findAllMessages(0);
        String res=messageBoardService.messagesToJson(list);
        System.out.println(res);
    }
}
