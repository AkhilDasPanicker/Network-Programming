import java.io.*;
import java.net.*;
class Client implements Runnable
{
 public String str;
 public static Thread t1=null,t2=null;
 public Socket sock;
 public BufferedReader keyBoardReader;
 public BufferedReader streamReader;
 public PrintWriter streamWriter;
 
 public Client()
 {
  try
  {
   str=" ";
   System.out.println("Connecting...");
   sock=new Socket("127.0.0.1",7000);
   System.out.println("Connected");
   keyBoardReader= new BufferedReader(new InputStreamReader(System.in));
   streamReader= new BufferedReader(new InputStreamReader(sock.getInputStream()));
   streamWriter= new PrintWriter(sock.getOutputStream(),true);
  }
  catch(Exception e){}
 }
 public void run()
 {
  do
  {
   if(Thread.currentThread()==t1)
   {
    try
    {
     str=keyBoardReader.readLine();
     streamWriter.println(str);
    }
    catch(Exception e){}
   }
   else
   {
    try
    {
     str=streamReader.readLine();
     System.out.println(str);
    }
    catch(Exception e){}
   }
   str=str.substring(str.length()-4,str.length());
  }while(!str.equals("Quit"));
 }
 public static void main(String a[])
 {
  Client ss=new Client();
  t1=new Thread(ss);
  t2=new Thread(ss);
  t1.start();
  t2.start();
 }
}
