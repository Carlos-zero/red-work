package dao;

import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSql {
    public static JdbcUtils conn=new JdbcUtils();           //实例化连接数据库的方法
    public Integer insertUser(String username,String password) throws SQLException {        //注册用户使用
        Connection connection=conn.getConnection();             //连接数据库
        PreparedStatement statement=null;                       //
        String sql="insert into users(username,password)value(?,?)";
        statement=connection.prepareStatement(sql);         //?
        statement.setString(1,username);
        statement.setString(2,password);
        statement.execute();                                //?
        sql="select @@identity newId";
        statement=connection.prepareStatement(sql);
        ResultSet resultSet=statement.executeQuery();       //?
        Integer id=null;                                    //Integer可以为null   但是int不行  区别？
        if (resultSet.next()){
            id=resultSet.getInt("newId");
        }
        JdbcUtils.close(connection,statement,resultSet);
        return id;
    }
    public User login(String username,String password) throws SQLException{
        User user=null;
        Connection connection=conn.getConnection();
        PreparedStatement statement=null;
        String sql="select * from users where username=? and password=?";
        statement=connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,password);
        ResultSet resultSet=statement.executeQuery();
        if (resultSet.next()) {
            user=new User();
            user.setId(resultSet.getInt("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        }
        JdbcUtils.close(connection,statement,resultSet);
        return user;
    }

}
