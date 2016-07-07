package seatGeekPortal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by RAM0N on 7/6/16.
 */
public class JsonParser {

    private static final String USER_AGENT = "Mozilla/5.0";
    //http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
    public static String sendGet(String strUrl) throws Exception {

        URL obj = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();

        if (responseCode == 200){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return null;
        }

    }
}
