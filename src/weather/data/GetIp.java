package weather.data;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

public class GetIp {

    public static String getExternalIpV4() throws MalformedURLException, IOException {
        String ip = "127.0.0.1";

//http://ifconfig.me/ip
        java.net.URL url = new java.net.URL("http://checkip.amazonaws.com/");
        java.net.HttpURLConnection con = (HttpURLConnection) url.openConnection();
        java.io.InputStream stream = con.getInputStream();
        java.io.InputStreamReader reader = new java.io.InputStreamReader(stream);
        java.io.BufferedReader bReader = new java.io.BufferedReader(reader);
        ip = bReader.readLine();

        return ip;
    }

}
