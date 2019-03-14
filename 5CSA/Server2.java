import java.io.*;
import java.net.*;
public class Server2
{
  public static void main(String[] args) throws Exception
  {
      ServerSocket sersock = new ServerSocket(3000);
      System.out.println("Server  ready for chatting");
      Socket sock = sersock.accept( );

      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));

      OutputStream ostream = sock.getOutputStream();
      PrintWriter pwrite = new PrintWriter(ostream, true);

      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

      String receiveMessage, sendMessage;
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)
        {
           System.out.println(receiveMessage);
        }
        sendMessage = keyRead.readLine();
        pwrite.println(sendMessage);
        pwrite.flush();
      }
    }
}
