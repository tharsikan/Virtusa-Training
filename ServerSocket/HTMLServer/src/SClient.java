
import java.net.URL;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class SClient
{


  static {
    //for localhost testing only
    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
            new javax.net.ssl.HostnameVerifier(){

              public boolean verify(String hostname,
                                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                  return true;
                }
                return false;
              }
            });
  }


  public static void main(String[] args) throws Exception {


    System.setProperty("javax.net.ssl.trustStore", "src/myKeyStore.jks");
    System.setProperty("javax.net.ssl.trustStorePassword", "123456");
   // System.setProperty("javax.net.debug", "ssl:record");


    String httpsURL = "https://localhost:8000/test";
    URL myUrl = new URL(httpsURL);
    HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
    InputStream is = conn.getInputStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);

    String inputLine;

    while ((inputLine = br.readLine()) != null) {
      System.out.println(inputLine);
    }

    br.close();
  }

}
