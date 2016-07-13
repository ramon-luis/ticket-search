package seatGeekPortal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Parses JSON to String
 * Provided in base code from Yelp client API example
 */

class JsonParser {

    private static final String USER_AGENT = "Mozilla/5.0";

    //http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
    static String sendGet(String strUrl) throws Exception {

        URL obj = new URL(strUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();

        if (responseCode == 200){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

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
