package dao;

import User.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageBoard {
    //这里用了一个单例模式 这是message_boardDao的单例
    private static MessageBoard instance = null;
    /**
     * 得到dao层的单例
     *
     * @return dao层的单例
     */
    public static MessageBoard getInstance() {
        //双重校验锁 防止高并发的情况下new出来多个message_boardDao的实例
        if (instance == null) {
            synchronized (MessageBoard.class) {
                if (instance == null) {
                    instance = new MessageBoard();
                }
            }
        }
        return instance;
    }
    public static JdbcUtils jdbcUtils=new JdbcUtils();
    //插入新留言
    public void insertMessage(Message message) throws SQLException {
        Connection connection=jdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="insert into message(username,text,pid) value (?,?,?)";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,message.getUsername());
        preparedStatement.setString(2,message.getText());
        preparedStatement.setInt(3,message.getPid());
        preparedStatement.execute();
        jdbcUtils.close(connection,preparedStatement);
    }
    //查询留言
    public List<Message> findMessageByPid(int pid) throws SQLException {
        Connection connection=jdbcUtils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from message where pid=?";
        List<Message> list=new ArrayList<Message>();
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setInt(1,pid);
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            Message message=new Message();
            message.setId(resultSet.getInt("id"));
            message.setPid(resultSet.getInt("pid"));
            message.setText(resultSet.getString("text"));
            message.setUsername(resultSet.getString("username"));
            list.add(message);
        }
        jdbcUtils.close(connection,preparedStatement,resultSet);
        return list;
    }
}
