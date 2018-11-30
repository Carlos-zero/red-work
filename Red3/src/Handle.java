import com.mysql.cj.xdevapi.Collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Handle {

        public static ArrayList list = new ArrayList();                 //

        public static void setList(ArrayList list) throws Exception {
                final String DBDOIVER="com.mysql.cj.jdbc.Driver";         //定义MySQL的数据库驱动程序
                final String DBURL="jdbc:mysql://localhost:3306/student";    //定义MySQL数据库的连接地址
                final String DBUSER="root";                                   //MySQL的连接用户名
                final String DBPASS="";                                        //MySQL数据库的连接密码
                        Connection conn=null;
                        PreparedStatement pstmt=null;
                        ResultSet rs=null;
                        String sql="SELECT stuNum,name,sex,age,classNum FROM student";
                        Class.forName(DBDOIVER);                                                //问题一次性抛出。。。
                        conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);                     //连接MySQL时，要写上连接的用户名和密码
                        pstmt=conn.prepareStatement(sql);
                        rs=pstmt.executeQuery();
                        int order=1;
                        while (rs.next()){
                                int stuNum=rs.getInt(1);
                                String name=rs.getString(2);
                                String sex=rs.getString(3);
                                int age=rs.getInt(4);
                                int classNum=rs.getInt(5);
                                Info Info=new Info();
                                Info.setStu_id(stuNum);
                                Info.setStu_name(name);
                                Info.setStu_sex(sex);
                                Info.setStu_age(age);
                                Info.setClasses(classNum);
                                list.add(Info);
                                /*System.out.print(stuNum+name+sex+age+classNum);*/
                                /*return stuNum+name+sex+age+classNum;*/
                        }
                        rs.close();
                        pstmt.close();
                        conn.close();

                /*Info Info1 = new Info();
                *//*Info1.SqlQueryHand();*//*
                Info1.setStu_id(1);
                Info1.setClasses(1);
                Info1.setStu_age(18);
                Info1.setStu_sex("男");
                Info1.setStu_name("hc");
                Info Info2 = new Info();
                Info2.setStu_id(2);
                Info2.setClasses(1);
                Info2.setStu_age(18);
                Info2.setStu_sex("男");
                Info2.setStu_name("zzz");
                Info Info3 = new Info();
                Info3.setStu_id(3);
                Info3.setClasses(1);
                Info3.setStu_age(18);
                Info3.setStu_sex("男");
                Info3.setStu_name("kjl");
                Info Info4 = new Info();
                Info4.setStu_id(4);
                Info4.setClasses(1);
                Info4.setStu_age(18);
                Info4.setStu_sex("女");
                Info4.setStu_name("tqy");
                Info Info5 = new Info();
                Info5.setStu_id(5);
                Info5.setClasses(1);
                Info5.setStu_age(18);
                Info5.setStu_sex("男");
                Info5.setStu_name("lk");
                list.add(Info1);
                list.add(Info2);
                list.add(Info3);
                list.add(Info4);
                list.add(Info5);*/
                Handle.list = list;
        }

        public static ArrayList getList() {
                return list;
        }

        /*public static void main(String args[]) throws  Exception{
*//*
        public static void SqlHand() throws Exception{
*//*
                setList(list);
                final String DBDOIVER="com.mysql.cj.jdbc.Driver";         //定义MySQL的数据库驱动程序
                final String DBURL="jdbc:mysql://localhost:3306/student";    //定义MySQL数据库的连接地址
                final String DBUSER="root";                                   //MySQL的连接用户名
                final String DBPASS="";                                        //MySQL数据库的连接密码
                Connection conn=null;
                PreparedStatement pstmt=null;

                for (Object obj:list){
                        Info info=(Info) obj;
                        int stuNum=info.getStu_id();
                        String name=info.getStu_name();
                        String gender=info.getStu_sex();
                        int age=info.getStu_age();
                        int classes=info.getClasses();
                        String sql="INSERT INTO student(stuNum,name,sex,age,classNum) VALUES(?,?,?,?,?)";
                        Class.forName(DBDOIVER);                                                //问题一次性抛出。。。
                        conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);                     //连接MySQL时，要写上连接的用户名和密码
                        pstmt=conn.prepareStatement(sql);
                        pstmt.setInt(1,stuNum);
                        pstmt.setString(2,name);
                        pstmt.setString(3,gender);
                        pstmt.setInt(4,age);
                        pstmt.setInt(5,classes);
                        pstmt.executeUpdate();
                        pstmt.close();
                        conn.close();
                }
                System.out.print("数据库更新成功");
        }
*/
        //添加学生信息
        public static boolean AddInfo(Info add_info) throws Exception {
                setList(list);
                boolean add = false;
                add = list.add(add_info);
                add_info.SqlAddHand();
                return add;
        }

        //根据学号修改学生信息
        public static boolean updateInfoById(int id, Info update_infoById) throws Exception {
                setList(list);
                boolean update = false;
                for (Object obj : list) {
                        Info info = (Info) obj;
                        if (id == info.getStu_id()) {
                                list.set(list.indexOf(info), update_infoById);
                                update_infoById.SqlUpdataHand(id);
                                update = true;
                                break;
                        }
                }
                return update;
        }


        //根据学号删除学生信息
        public static boolean deleteInfoById(int delete_id) throws Exception {
                setList(list);
                boolean delete = false;
                for (Object obj : list) {
                        Info info = (Info) obj;
                        if (delete_id == info.getStu_id()) {
                                delete = list.remove(info);
                                ((Info) obj).SqlDeleteHand(delete_id);
                                break;
                        }
                }
                return delete;
        }

        public static boolean selectStuId(int id) throws Exception {
                setList(list);
                boolean fag = false;
                for (Object obj : list) {
                        Info info = (Info) obj;
                        if (id == info.getStu_id()) {
                                fag = true;
                                break;
                        }
                }
                return fag;
        }


        //查询所有学生信息
        //这里出现了setlist每次都会重复多遍历的问题。。很遗憾尝试了很多方法也没有解决，最后正确结果应该时遍历的最后一遍
        public static void selectAllInfo() throws Exception {
                setList(list);
                System.out.println("-----foreach遍历方式-----");
                for (Object obj : list) {
                        Info info = (Info) obj;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("学号:" + info.getStu_id());
                        stringBuilder.append("\t姓名:" + info.getStu_name());
                        stringBuilder.append("\t性别:" + info.getStu_sex());
                        stringBuilder.append("\t年龄:" + info.getStu_age());
                        stringBuilder.append("\t班级:" + info.getClasses());
                        System.out.println(stringBuilder.toString());
                }
                System.out.println("-----Iterator遍历方式-----");
                Iterator<Info> it=list.iterator();
                while (it.hasNext()){
                        Info i =it.next();
                        System.out.println("学号："+i.getStu_id()+" 姓名："+i.getStu_name()+" 性别："+i.getStu_sex()+" 年龄："+i.getStu_age()+" 班级："+i.getClasses());
                }


        }
        public static void sortjx() throws Exception {
                setList(list);
                Collections.sort(list);
                System.out.println("------升序------");
                for (Object obj : list) {
                        Info info = (Info) obj;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("学号:" + info.getStu_id());
                        stringBuilder.append("\t姓名:" + info.getStu_name());
                        stringBuilder.append("\t性别:" + info.getStu_sex());
                        stringBuilder.append("\t年龄:" + info.getStu_age());
                        stringBuilder.append("\t班级:" + info.getClasses());
                        System.out.println(stringBuilder.toString());
                }
                Collections.reverse(list);
                System.out.println("------降序------");
                for (Object obj : list) {
                        Info info = (Info) obj;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("学号:" + info.getStu_id());
                        stringBuilder.append("\t姓名:" + info.getStu_name());
                        stringBuilder.append("\t性别:" + info.getStu_sex());
                        stringBuilder.append("\t年龄:" + info.getStu_age());
                        stringBuilder.append("\t班级:" + info.getClasses());
                        System.out.println(stringBuilder.toString());
                }


        }


}









