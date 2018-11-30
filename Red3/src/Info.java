import com.mysql.cj.xdevapi.Result;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Info implements Comparable<Info>, Serializable {

        private int stu_id;
        private String stu_name;
        private String stu_sex;
        private int stu_age;
        private int classes;




        public int getStu_id() {
                return stu_id;
        }

        public void setStu_id(int stu_id) {
                this.stu_id = stu_id;
        }

        public String getStu_name() {
                return stu_name;
        }

        public void setStu_name(String stu_name) {
                this.stu_name = stu_name;
        }

        public String getStu_sex() {
                return stu_sex;
        }

        public void setStu_sex(String stu_sex) {
                this.stu_sex = stu_sex;
        }

        public int getStu_age() {
                return stu_age;
        }

        public void setStu_age(int stu_age) {
                this.stu_age = stu_age;
        }





        public int getClasses() {
                return classes;
        }

        public void setClasses(int classes) {
                this.classes = classes;
        }


        @Override
        public int compareTo(Info o) {
                return this.stu_id-o.stu_id;
        }
        public String toString() {
                return "学号："+getStu_id()+" 姓名："+getStu_name()+" 性别："+getStu_sex()+" 年龄："+getStu_age()+" 班级："+getClasses();
        }
        public static final String DBDOIVER="com.mysql.cj.jdbc.Driver";         //定义MySQL的数据库驱动程序
        public static final String DBURL="jdbc:mysql://localhost:3306/student";    //定义MySQL数据库的连接地址
        public static final String DBUSER="root";                                   //MySQL的连接用户名
        public static final String DBPASS="";                                        //MySQL数据库的连接密码
        public void SqlAddHand() throws Exception {                        //添加用户
                /*final String DBDOIVER="com.mysql.cj.jdbc.Driver";         //定义MySQL的数据库驱动程序
                final String DBURL="jdbc:mysql://localhost:3306/student";    //定义MySQL数据库的连接地址
                final String DBUSER="root";                                   //MySQL的连接用户名
                final String DBPASS="";                                        //MySQL数据库的连接密码*/
                Connection conn=null;
                PreparedStatement pstmt=null;
                int stuNum=getStu_id();
                String name=getStu_name();
                String sex=getStu_sex();
                int age=getStu_age();
                int classNum=getClasses();
                String sql="INSERT INTO student(stuNum,name,sex,age,classNum) VALUES(?,?,?,?,?)";
                Class.forName(DBDOIVER);                                                //问题一次性抛出。。。
                conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);                     //连接MySQL时，要写上连接的用户名和密码
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,stuNum);
                pstmt.setString(2,name);
                pstmt.setString(3,sex);
                pstmt.setInt(4,age);
                pstmt.setInt(5,classNum);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                System.out.print("数据库更新成功");
        }
        public void SqlUpdataHand(int stuNum1)throws Exception{                         //修改
                Connection conn=null;
                PreparedStatement pstmt=null;
                int stuNum=getStu_id();
                String name=getStu_name();
                String sex=getStu_sex();
                int age=getStu_age();
                int classNum=getClasses();
                String sql="UPDATE student set stuNum=?,name=?,sex=?,age=?,classNum=? WHERE stuNum=?";
                Class.forName(DBDOIVER);                                                //问题一次性抛出。。。
                conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);                     //连接MySQL时，要写上连接的用户名和密码
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,stuNum);
                pstmt.setString(2,name);
                pstmt.setString(3,sex);
                pstmt.setInt(4,age);
                pstmt.setInt(5,classNum);
                pstmt.setInt(6,stuNum1);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
        }
        public void SqlDeleteHand(int stuNum1)throws Exception{                               //删除
                Connection conn=null;
                PreparedStatement pstmt=null;
                String sql="DELETE FROM student WHERE stuNum=?";
                Class.forName(DBDOIVER);                                                //问题一次性抛出。。。
                conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);                     //连接MySQL时，要写上连接的用户名和密码
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1,stuNum1);
                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
        }
/*
        public static void main(String args[])throws Exception{
*/

}
	
	
