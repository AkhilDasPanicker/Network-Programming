import java.io.*;
import java.net.*;
import java.util.Scanner;

class UDPClient
{
   public static void main(String args[]) throws Exception
   {
     while(true)
{
      BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
      DatagramSocket clientSocket = new DatagramSocket();
      InetAddress IPAddress = InetAddress.getByName("10.90.12.2");
      byte[] sendData = new byte[25024];
      byte[] receiveData = new byte[25024];
     
  System.out.println("Enter Message ");
     // Scanner sc =new Scanner(System.in);
      String sentence = inFromUser.readLine();
      //String sentence=sc.next();
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9878);
      clientSocket.send(sendPacket);
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("FROM SERVER:" + modifiedSentence);
      clientSocket.close();
    }
}

}
