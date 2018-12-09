package work.TwelveWeek.Two;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Hand {

    public static void get()throws Exception{                                                                           //将爬下来的内容解析
    String data=get("http://jwzx.cqu.pt/data/json_StudentSearch.php?searchKey=34071801");
    JSONObject jsonObject=new JSONObject(data);
    /*----------------------------------------------------------------------------------------------------------------------------------JSONTokener jsonTokener=new JSONTokener(String.valueOf(jsonObject.getJSONArray("returnData")));
    ---------------------------------------------------------------------------------------------------------------------------JSONArray jsonArray=new JSONArray(jsonTokener);
    ----------------------------------------------------------------------------------------------------------------------System.out.println(jsonArray);*/
    /*-------------------------------------------------------------------------------------------------------------System.out.println(jsonObject.getJSONArray("returnData"));*/
    JSONArray jsonArray=new JSONArray(String.valueOf(jsonObject.get("returnData")));
    /*--------------------------------------------------------------------------------------------------------System.out.println(jsonArray);*/
    for (int a=0;a<jsonArray.length();a++) {                                                                                //利用循环添加导数据库
        JSONObject jsonObject1 = jsonArray.getJSONObject(a);
        int xh = jsonObject1.getInt("xh");
        String xm = jsonObject1.getString("xm");
        String xb = jsonObject1.getString("xb");
        int bj = jsonObject1.getInt("bj");
        String zym = jsonObject1.getString("zym");
        int csrq = jsonObject1.getInt("csrq");
        String xjzt = jsonObject1.getString("xjzt");
        String mz = jsonObject1.getString("mz");
        Student student = null;
        student = new Student();
        student.setXh(xh);
        student.setXm(xm);
        student.setXb(xb);
        student.setBj(bj);
        student.setZym(zym);
        student.setCsrq(csrq);
        student.setSjzt(xjzt);
        student.setMz(mz);
        System.out.println(student.toString());
        sqlAddHand(student);
    }
        /*System.out.println(str);
        System.out.println(jsonObject1);*/
    }

    public static String get(String url){                                                                               //将数据从内网爬下
        BufferedReader in=null;
        try {
            URL realUrl=new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(50000);
            connection.setReadTimeout(50000);
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }catch (Exception e){
            e.printStackTrace();
/*
            LOG.error("Exception occur when send http get request!", e);
*/
        }
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }


    public static boolean sqlAddHand(Student student)throws Exception{                                               //向数据库中存入信息
        final String DBDOIVER="com.mysql.cj.jdbc.Driver";         //定义MySQL的数据库驱动程序
        final String DBURL="jdbc:mysql://localhost:3306/student";    //定义MySQL数据库的连接地址
        final String DBUSER="root";                                   //MySQL的连接用户名
        final String DBPASS="";                                        //MySQL数据库的连接密码
        Connection conn=null;
        PreparedStatement pstmt=null;
        int xh=student.getXh();
        String xm=student.getXm();
        String xb=student.getXb();
        int bj=student.getBj();
        String zym=student.getZym();
        int csrq=student.getCsrq();
        String sjzt=student.getSjzt();
        String mz=student.getMz();
        String sql="INSERT INTO stu_data(xh,xm,xb,bj,zym,csrq,xjzt,mz) VALUE(?,?,?,?,?,?,?,?)";
        Class.forName(DBDOIVER);
        conn= DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        pstmt=conn.prepareStatement(sql);
        pstmt.setInt(1,xh);
        pstmt.setString(2,xm);
        pstmt.setString(3,xb);
        pstmt.setInt(4,bj);
        pstmt.setString(5,zym);
        pstmt.setInt(6,csrq);
        pstmt.setString(7,sjzt);
        pstmt.setString(8,mz);
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        System.out.println("学生信息添加成功！");
        return true;
    }
}
