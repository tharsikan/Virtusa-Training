import java.io.*;
import java.net.Socket;

public class ThreadHandler extends Thread {
  Socket newSocket;
  int n;

  ThreadHandler(Socket newSocket, int n) {
    this.newSocket = newSocket;
    this.n = n;
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

        String line = dataInputStream.readLine();

        if (line.equals("list")) {
          String list[] = {""};
          Server.stringSocketHashMap.keySet().forEach(e -> {
            String youOrnot = "";
            System.out.println(newSocket.getRemoteSocketAddress());
            if (newSocket.getRemoteSocketAddress().equals(Server.stringSocketHashMap.get(e).getRemoteSocketAddress())) {
              youOrnot = "you";
            }
            list[0] += e + youOrnot + ",";
          });
          outPutStream.println(list[0]);
        }
        System.out.println(line);
        if (line == null) more_data = false;
        else {
          outPutStream.println("From Server: " + line + Math.random() + "in");
          if (line.trim().equals("q")) more_data = false;
        }
      }
      newSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
