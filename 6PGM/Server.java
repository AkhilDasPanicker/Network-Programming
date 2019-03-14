import java.io.*;
import java.net.*;
class Server extends Thread
{
 public String str,str1;
 public Thread t1=null,t2=null,t3=null,t4=null,t5=null;
 public ServerSocket serSock;
 public Socket sock1,sock2,sock3,sock4;
 public BufferedReader keyBoardReader;
 public BufferedReader streamReader1,streamReader2,streamReader3,streamReader4;
 public PrintWriter streamWriter1,streamWriter2,streamWriter3,streamWriter4;
 public Server()
 {
  try
  {
   str=" ";
   str1=" ";
   serSock =new ServerSocket(7000);
   System.out.println("Server listening...");
   sock1=serSock.accept();
   sock2=serSock.accept();
   sock3=serSock.accept();
   sock4=serSock.accept();
   keyBoardReader=new BufferedReader(new InputStreamReader(System.in));
   streamReader1=new BufferedReader(new InputStreamReader(sock1.getInputStream()));
   streamReader2=new BufferedReader(new InputStreamReader(sock2.getInputStream()));
   streamReader3=new BufferedReader(new InputStreamReader(sock3.getInputStream()));
   streamReader4=new BufferedReader(new InputStreamReader(sock4.getInputStream()));
   streamWriter1=new PrintWriter(sock1.getOutputStream(),true);
   streamWriter2=new PrintWriter(sock2.getOutputStream(),true);
   streamWriter3=new PrintWriter(sock3.getOutputStream(),true);
   streamWriter4=new PrintWriter(sock4.getOutputStream(),true);
  }
  catch(Exception e){}
 }
 public void run()
 {
  while(!str.equals("quit"))
  {
   if(Thread.currentThread()==t1)
   {
    try
    {
     str=keyBoardReader.readLine();
     streamWriter1.println("From Server:"+str);
     streamWriter2.println("From Server:"+str);
     streamWriter3.println("From Server:"+str);
     streamWriter4.println("From Server:"+str);
    }
    catch(Exception e){}
   }
   else if(Thread.currentThread()==t2)
   {
    try
    {
     str1=streamReader1.readLine();
     System.out.println(str1);
     streamWriter2.println("From Client1:"+str1);
     streamWriter3.println("From Client1:"+str1);
     streamWriter4.println("From Client1:"+str1);
    }
    catch(Exception e){}
   }
   else if(Thread.currentThread()==t3)
   {
    try
    {
     str1=streamReader2.readLine();
     System.out.println(str1);
     streamWriter1.println("From Client2:"+str1);
     streamWriter3.println("From Client2:"+str1);
     streamWriter4.println("From Client2:"+str1);
    }
    catch(Exception e){}
   }
   else if(Thread.currentThread()==t4)
   {
    try
    {
     str1=streamReader3.readLine();
     System.out.println(str1);
     streamWriter2.println("From Client3:"+str1);
     streamWriter1.println("From Client3:"+str1);
     streamWriter4.println("From Client3:"+str1);
    }
    catch(Exception e){}
   }
   else if(Thread.currentThread()==t5)
   {
    try
    {
     str1=streamReader4.readLine();
     System.out.println(str1);
     streamWriter2.println("From Client4:"+str1);
     streamWriter3.println("From Client4:"+str1);
     streamWriter1.println("From Client4:"+str1);
    }
    catch(Exception e){}
   }
   str=str.substring(str.length()-4,str.length());
  }
 }
 public static void main(String a[])
 {
  Server ss=new Server();
  ss.t1=new Thread(ss);
  ss.t2=new Thread(ss);
  ss.t3=new Thread(ss);
  ss.t4=new Thread(ss);
  ss.t5=new Thread(ss);
  ss.t1.start();
  ss.t2.start();
  ss.t3.start();
  ss.t4.start();
  ss.t5.start();
 }
}
