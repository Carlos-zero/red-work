import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteObject  {
    public static void main (String[] args){
        try(
            ObjectOutputStream oos=new ObjectOutputStream(
                    new FileOutputStream("Person.txt")))
        {
            Info Info1 = new Info();
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
            oos.writeObject(Info1);
            oos.writeObject(Info2);
            oos.writeObject(Info3);
            oos.writeObject(Info4);
            oos.writeObject(Info5);



        }
        catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
}

