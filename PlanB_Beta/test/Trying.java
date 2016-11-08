
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import com.lafargeholcim.planb.util.Time;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AI-Saac
 */
public class Trying {
    
    public static void main(String[] args) throws UnsupportedEncodingException{
        String percent = "100%";
        System.out.println(Time.getNow());
        System.out.println(percent.substring(0, percent.length()-1));
        System.out.println(Time.getSerialNumberDate("2016-05-10", false).toString()+" coco");
        System.out.println(Time.getSerialNumberDate("2016-06-10", false).toString()+" coco");
        System.out.println(Time.getSerialNumberDate("2016-06-10 19:10:00", true).toString()+" coco");
    }
     
    public static String executePost(String targetURL, String urlParameters) {
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", 
                "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", 
                Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");  

            connection.setUseCaches(false);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response  
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
              response.append(line);
              response.append('\r');
            }
            rd.close();
            return response.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        } 
        finally {
            if (connection != null) {
              connection.disconnect();
            }
        }
    }
    
    public static long getDaysBetweenDates(String start, String end){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ChronoUnit.HALF_DAYS.between(LocalDateTime.parse(start, formatter), LocalDateTime.parse(end,formatter));
//        return (int)ChronoUnit.DAYS.between(Terminal.parseDate(start),Terminal.parseDate(end));
    }
}
