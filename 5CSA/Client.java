import java.net.*;
import java.io.*;
public class Client
{
 public static void main(String args[])throws Exception
 {
  Socket s=new Socket("127.0.0.1",5000);
  InputStream is= s.getInputStream();
  BufferedReader br= new BufferedReader(new InputStreamReader(is));
  String s1=br.readLine();
  System.out.println(s1);
  br.close();is.close();s.close();
 }
}
