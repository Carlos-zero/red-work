package work.TwelveWeek.Three;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Three {
    public static void main(String args[])throws Exception{
        final String DBDOIVER="com.mysql.cj.jdbc.Driver";         //定义MySQL的数据库驱动程序
        final String DBURL="jdbc:mysql://localhost:3306/student?useOldAliasMetadataBehavior=true";    //定义MySQL数据库的连接地址
        final String DBUSER="root";                                   //MySQL的连接用户名
        final String DBPASS="";
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="select student.name,student.sex,student.age,student.classNum,grades.physics,grades.math,grades.english from student inner join grades on student.stuNum=grades.stuNum where student.stuNum=11";//从这里查询！！！
        Class.forName(DBDOIVER);
        conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql);
        while (rs.next()) {
            String name=rs.getString("student.name");
            String sex=rs.getString("student.sex");
            int age=rs.getInt("student.age");
            int classNum=rs.getInt("student.classNum");
            int phy=rs.getInt("grades.physics");
            int math=rs.getInt("grades.math");
            int eng=rs.getInt("grades.english");
            System.out.println("姓名："+name+"、性别："+sex+"" + "、年龄："+age+"、班级："+classNum+"、大雾成绩："+phy+"、高数成绩："+math+"、英语成绩"+eng+"。");
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
