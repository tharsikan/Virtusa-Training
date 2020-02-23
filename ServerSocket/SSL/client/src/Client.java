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
      //Create SSLSocket using SSLServerFactory already established ssl context and connect to server
      SSLSocket sslSocket = (SSLSocket) sslsocketfactory.createSocket("localhost", 7800);


        out = new PrintWriter(sslSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));


      out.println("a" + (int) Math.floor(Math.random() * 100));
      String input;
      System.out.println(in.readLine());

      while (true) {
        input = scanner.nextLine();
        if (input.equals("close")) break;
        out.println(input);
        System.out.println(in.readLine());
      }

      out.close();
      in.close();
      sslSocket.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
