package Service;

import User.Message;
import dao.MessageBoard;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.sql.SQLException;
import java.util.List;

public class MessageBoardService {
    //service的单例
    private static MessageBoardService instance = null;
    //dao的单例
    private MessageBoard messageBoard = null;
    /*public static MessageBoard messageBoard=new MessageBoard();*/
    /**
     * 构造方法 实例化时为contentDao赋值
     */
    public MessageBoardService() {
        messageBoard = MessageBoard.getInstance();
    }
    /**
     * 得到service的单例
     *
     * @return service
     */
    public static MessageBoardService getInstance() {
        //双重校验锁
        if (instance == null) {
            synchronized (MessageBoardService.class) {
                if (instance == null) {
                    instance = new MessageBoardService();
                }
            }
        }
        return instance;
    }

    private List<Message> findContentChild(Message content) throws SQLException {
        //找到该评论的子节点，即pid为该条评论id的评论
        List<Message> list=messageBoard.findMessageByPid(content.getId());

        //遍历它的子节点，然后递归找每条评论下的评论 即节点的子节点
        for (Message message:list){
            //递归找这条评论的节点 然后赋值
            List<Message> childList=findContentChild(message);
            message.setChildcntent(childList);
        }

        return list;
    }
    public List<Message> findAllMessages(int id) throws SQLException {
        //先找到pid为0的所有留言 即留言板上所有无父节点的留言
        List<Message> list=messageBoard.findMessageByPid(id);
        //然后找每条留言的评论  并赋值
        for (Message message:list){
            List<Message> childList=findContentChild(message);
            message.setChildcntent(childList);
            System.out.println(message.getChildcntent());
        }
        return list;
    }
    public static String messagesToJson(List<Message> messageList){
        if (messageList==null) return "";
        JSONArray array=new JSONArray();
        /*JsonArray array=new JsonArray();*/
        JSONObject jsonObject=null;
        Message message=null;
        for (int i=0;i<messageList.size();i++){
            message=messageList.get(i);
            jsonObject = new JSONObject();
            jsonObject.put("id",message.getId());
            jsonObject.put("username",message.getUsername());
            jsonObject.put("text",message.getText());
            jsonObject.put("pid",message.getPid());
            array.add(jsonObject);
        }
        return array.toString();
    }
    public boolean insertContent(Message message) throws SQLException {
        if (message.getUsername()!=null&&message.getText()!=null){
            messageBoard.insertMessage(message);
            return true;
        }
        return false;
    }
}
