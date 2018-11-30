import com.mysql.cj.xdevapi.Collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class SqlHand {public static void Mysql(ArrayList list) throws  Exception{
    /*setList(list);*/
    final String DBDOIVER="com.mysql.cj.jdbc.Driver";         //定义MySQL的数据库驱动程序
    final String DBURL="jdbc:mysql://localhost:3306/test";    //定义MySQL数据库的连接地址
    final String DBUSER="root";                                   //MySQL的连接用户名
    final String DBPASS="";                                        //MySQL数据库的连接密码
    Connection conn=null;
    PreparedStatement pstmt=null;

    for (Object obj:list){
        Info info=(Info) obj;
        int id=info.getStu_id();
        String name=info.getStu_name();
        String gender=info.getStu_sex();
        int age=info.getStu_age();
        int classes=info.getClasses();
        String sql="INSERT INTO student(id,name,sex,age,classNum) VALUES(?,?,?,?,?)";
        Class.forName(DBDOIVER);                                                //问题一次性抛出。。。
        conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);                     //连接MySQL时，要写上连接的用户名和密码
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.setString(2,name);
        pstmt.setString(3,gender);
        pstmt.setInt(4,age);
        pstmt.setInt(5,classes);
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        System.out.print("数据库更新成功");
    }
}
}
