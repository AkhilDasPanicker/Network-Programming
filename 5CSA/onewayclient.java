import java.net.*;
import java.io.*;


public class onewayclient
{
 public static void main(String args[])throws Exception
 {
  Socket s=new Socket("127.0.0.1",5000);
  String msg="Hello Server";
  OutputStream os= s.getOutputStream();
  DataOutputStream ds=new DataOutputStream(os);
  ds.writeBytes(msg);
  ds.close();os.close();s.close();
 }
}
