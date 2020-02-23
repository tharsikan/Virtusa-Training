import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.io.DataInputStream;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.security.Security;

import com.sun.net.ssl.internal.ssl.Provider;

public class Server {
  public static HashMap<String, Socket> stringSocketHashMap = new HashMap<>();

  public static void main(String[] args) {
    //The Port number through which this server will accept client connections
    int port = 7800;
        /*Adding the JSSE (Java Secure Socket Extension) provider which provides SSL and TLS protocols
        and includes functionality for data encryption, server authentication, message integrity,
        and optional client authentication.*/
    Security.addProvider(new Provider());
    //specifing the keystore file which contains the certificate/public key and the private key
    System.setProperty("javax.net.ssl.keyStore", "src/myKeyStore.jks");
    //specifing the password of the keystore file
    System.setProperty("javax.net.ssl.keyStorePassword", "123456");
    //This optional and it is just to show the dump of the details of the handshake process
    //System.setProperty("javax.net.debug", "all");

    try {
      int nreq = 1;

      //Must be after  all above
      //SSLServerSocketFactory establishes the ssl context and and creates SSLServerSocket
      SSLServerSocketFactory sslServerSocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
      //Create SSLServerSocket using SSLServerSocketFactory established ssl context
      SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketfactory.createServerSocket(port);
      System.out.println("Ishans Server Started & Ready to accept Clients Connections");
      for (; ; ) {

        //System.out.println("Ishans Server Started & Ready to accept Clients Connections");
        //Wait for the SSL client to connect to this server
        SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();


        System.out.println("Creting a Thread ....");
        // DataInputStream dataInputStream = new DataInputStream(sslSocket.getInputStream());
        //Resolve Name
        BufferedReader dataInputStream = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        String line = dataInputStream.readLine();
        System.out.println(line + "front");

        //make as a seperate thread
        Thread thread = new ThreadHandler(sslSocket, nreq);
        stringSocketHashMap.put(line, sslSocket);

        thread.start();
        nreq++;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
