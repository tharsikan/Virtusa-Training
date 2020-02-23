import java.io.*;
import java.net.Socket;
import java.security.Security;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.security.Security;

import com.sun.net.ssl.internal.ssl.Provider;

public class Client {
  public static void main(String[] args) {
    try {
      PrintWriter out = null;
      BufferedReader in = null;
      String ip = "localhost", name = "ishan", port = "7800";

      Scanner scanner = new Scanner(System.in);

      //SSL
        /*Adding the JSSE (Java Secure Socket Extension) provider which provides SSL and TLS protocols
        and includes functionality for data encryption, server authentication, message integrity,
        and optional client authentication.*/
      Security.addProvider(new Provider());
      //specifing the trustStore file which contains the certificate & public of the server
      System.setProperty("javax.net.ssl.trustStore", "src/myTrustStore.jts");
      //specifing the password of the trustStore file
      System.setProperty("javax.net.ssl.trustStorePassword", "123456");
      //This optional and it is just to show the dump of the details of the handshake process
      //System.setProperty("javax.net.debug", "all");

      //SSLSSocketFactory establishes the ssl context and and creates SSLSocket
      SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

      System.out.println("please use connect ip:port as name exactly to connect !");
      String command = scanner.nextLine();
      Pattern regex1 = Pattern.compile("^connect " +
              "(?<ip>((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))" +
              ":(?<port>\\d{4})" +
              " as " +
              "(?<name>\\w*)$");
      Matcher matches = regex1.matcher(command);

      if (matches.find()) {
        ip = matches.group("ip");
        name = matches.group("name");
        port = matches.group("port");

        System.out.println("ip: " + ip);
        System.out.println("name: " + name);
        System.out.println("port: " + port);

      } else {
        System.out.println("Wronge Command !");
      }

      //Create SSLSocket using SSLServerFactory already established ssl context and connect to server
      SSLSocket sslSocket = (SSLSocket) sslsocketfactory.createSocket(ip, Integer.parseInt(port));
      //output and input stream
      out = new PrintWriter(sslSocket.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
      //Assign name to the client
      out.println(name);
      String reply = in.readLine();
      //duplicate nam disconnect wenawa
      if (reply == null) {
        System.out.println("Duplicate name entered connection closing !");
        out.close();
        in.close();
        sslSocket.close();
      } else {
        //client and server communication through scanner
        String input;
        while (true) {
          input = scanner.nextLine();

          if (input.equals("close")) break;
          out.println(input);

       //is this stupid?
       final   BufferedReader finalIn = in;
          new Thread(() -> {
          try{
            while (true) System.out.println(finalIn.readLine());
          }catch(Exception e){
            System.out.println(e);
          }
          }).start();

        }

      }


      out.close();
      in.close();
      sslSocket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
