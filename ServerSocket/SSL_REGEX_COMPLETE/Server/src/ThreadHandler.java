import java.io.*;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThreadHandler extends Thread {
  Socket newSocket;
  int n;
  private String clientName;

  ThreadHandler(Socket newSocket, int n, String clientName) {
    this.newSocket = newSocket;
    this.n = n;
    this.clientName = clientName;
  }

  @Override
  public void run() {
    try {
      // DataInputStream dataInputStream = new DataInputStream(newSocket.getInputStream());
      // PrintStream outPutStream = new PrintStream(newSocket.getOutputStream());
      PrintWriter outPutStream = new PrintWriter(newSocket.getOutputStream(), true);
      BufferedReader dataInputStream = new BufferedReader(new InputStreamReader(newSocket.getInputStream()));

      outPutStream.println("hello::enter q to exit");
      boolean more_data = true;
      boolean firstTime = true;
      while (more_data) {

        String clientMsg = dataInputStream.readLine();

        //If user want to list
        if (clientMsg.equals("list")) {
          //skip lambda final
          String list[] = {""};

          Server.stringSocketHashMap.keySet().forEach(e -> {
            String youOrnot = "";
            System.out.println(newSocket.getRemoteSocketAddress());
            if (newSocket.getRemoteSocketAddress().equals(Server.stringSocketHashMap.get(e).getRemoteSocketAddress())) {
              youOrnot = "(you)";
            }
            list[0] += e + youOrnot + ",";
          });
          outPutStream.println(list[0]);
        }


        System.out.println(clientMsg);
        Matcher matcher2 = Pattern.compile("send (?<msg>.*)->(?<name>.*)").matcher(clientMsg);
        if (matcher2.find()) {
          System.out.println("message: " + matcher2.group("msg"));
          System.out.println("receiver name: " + matcher2.group("name"));
          String message = matcher2.group("msg");
          String receiver = matcher2.group("name");
          String sender = clientName;
          System.out.println("sender " + clientName);
          Server.stringSocketHashMap.keySet().forEach(e -> {
            if (e.equals(receiver)) {
              try {
                PrintWriter sendMessage = new PrintWriter(Server.stringSocketHashMap.get(e).getOutputStream(), true);
                sendMessage.println(sender + " ->" + message);

              } catch (Exception e1) {
                System.out.println(e1);
              }
            }
          });

        }

        if (clientMsg == null) more_data = false;
        else {
          DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          Date date = new Date();
          System.out.println(dateFormat.format(date));
          outPutStream.println("From Server: ok messages received from server " + clientMsg +" at this time "+dateFormat.format(date));
          if (clientMsg.trim().equals("q")) more_data = false;
        }
      }
      newSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
