import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
  public static void main(String[] args) {
    try {
//      String input;
//      Scanner scanner = new Scanner(System.in);
//      System.out.println("Enter ip adress ");
//      Socket socket = new Socket("127.0.0.1", 7500);
//      DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
//      PrintStream outPutStream = new PrintStream(socket.getOutputStream());
// String input;
//      while (!(input = scanner.nextLine()).equals("q")) {
//        System.out.println("Keep Going!");
//
//        boolean more_data = true;
//        {
//
//          if (input == null) more_data = false;
//          else {
//            String line = dataInputStream.readLine();
//            System.out.println(line);
//           // outPutStream.println(scanner.nextLine());
//          }
//        }
//      }
//
//      {
//        System.out.println("Disconnected from server !!");
//        System.exit(1);
//      }
      Socket pingSocket = null;
      PrintWriter out = null;
      BufferedReader in = null;
      Scanner scanner = new Scanner(System.in);

      try {
//        String getIpAndPort = scanner.nextLine();
//
//        System.out.println(getIpAndPort);
//        System.out.println(getIpAndPort.replaceAll("connect", ""));
//
//        String port = "\\d\\d\\d\\d";
//        Pattern r = Pattern.compile(port);
//        Matcher m = r.matcher(getIpAndPort);
//        while (m.find()) {
//          System.out.println("Found value: " + m.group());
//        }
//
//        String ip = "\\d\\d\\.\\d\\d";
//        Pattern r1 = Pattern.compile(ip);
//        Matcher m1 = r1.matcher(getIpAndPort);
//        while (m1.find()) {
//          System.out.println("Found value ip: " + m1.group());
//        }


        pingSocket = new Socket("127.0.0.1", 7500);
        out = new PrintWriter(pingSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));
      } catch (IOException e) {
        return;
      }

      out.println("a"+(int)Math.floor(Math.random()*100));
      String input;
      System.out.println(in.readLine());

      while (!(input = scanner.nextLine()).equals("q")) {

        out.println(input);
        System.out.println(in.readLine());

      }

      out.close();
      in.close();
      pingSocket.close();


    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
