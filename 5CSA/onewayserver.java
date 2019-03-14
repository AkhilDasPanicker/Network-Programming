import java.net.*;
import java.io.*;


public class onewayserver
{
 public static void main(String args[])throws Exception
 {
  ServerSocket ss=new ServerSocket(5000);
  System.out.println("Server is ready");
  Socket s= ss.accept();
  InputStream is = s.getInputStream();
  DataInputStream ds = new DataInputStream(is);
  String msg=ds.readLine();
  System.out.println(msg);
  ds.close();is.close();ss.close();s.close();
 }
}
	