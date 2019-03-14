import java.net.*;
import java.io.*;
public class Server
{
 public static void main(String args[])throws Exception
 {
  ServerSocket ss= new ServerSocket(5000);
  System.out.println("Server is ready");
  Socket s=ss.accept();
  OutputStream os=s.getOutputStream();
  BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
  String s2="Thankyou for connecting to Server";
  bw.write(s2);
  bw.close();
  os.close();ss.close();s.close();
 }
}
