import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ReadObject {
    public static void main(String[] args) throws IOException {
            try(
              ObjectInputStream  ois =new ObjectInputStream(
                       new FileInputStream("Person.txt")))
       {

           Info p =(Info)ois.readObject();
           System.out.println("学号："+p.getStu_id()+" 姓名："+p.getStu_name()+" 性别："+p.getStu_sex()+" 年龄："+p.getStu_age()+" 班级："+p.getClasses());
           Info o =(Info)ois.readObject();
           System.out.println("学号："+o.getStu_id()+" 姓名："+o.getStu_name()+" 性别："+o.getStu_sex()+" 年龄："+o.getStu_age()+" 班级："+o.getClasses());
           Info i =(Info)ois.readObject();
           System.out.println("学号："+i.getStu_id()+" 姓名："+i.getStu_name()+" 性别："+i.getStu_sex()+" 年龄："+i.getStu_age()+" 班级："+i.getClasses());
           Info u =(Info)ois.readObject();
           System.out.println("学号："+u.getStu_id()+" 姓名："+u.getStu_name()+" 性别："+u.getStu_sex()+" 年龄："+u.getStu_age()+" 班级："+u.getClasses());
           Info y =(Info)ois.readObject();
           System.out.println("学号："+y.getStu_id()+" 姓名："+y.getStu_name()+" 性别："+y.getStu_sex()+" 年龄："+y.getStu_age()+" 班级："+y.getClasses());


       }
       catch (Exception ex){
          ex.printStackTrace();

        }
               }
               }
