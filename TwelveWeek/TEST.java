package work.TwelveWeek;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class TEST {
    public static void main(String args[]) throws JSONException{
        String data=get("http://jwzx.cqu.pt/data/json_StudentSearch.php?searchKey=34071801");
        JSONObject jsonObject=new JSONObject(data);
        /*JSONTokener jsonTokener=new JSONTokener(String.valueOf(jsonObject.getJSONArray("returnData")));
        JSONArray jsonArray=new JSONArray(jsonTokener);
        System.out.println(jsonArray);*/
        /*System.out.println(jsonObject.getJSONArray("returnData"));*/
        JSONArray jsonArray=new JSONArray(String.valueOf(jsonObject.get("returnData")));
        /*System.out.println(jsonArray);*/
        JSONObject jsonObject1=jsonArray.getJSONObject(0);
        String str=jsonObject1.getString("xm");
        System.out.println(str);
        System.out.println(jsonObject1);
    }
    public static String get(String url){
        BufferedReader in=null;
        try {
            URL realUrl=new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
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
}
