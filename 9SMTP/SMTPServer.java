import java.io.*;
import java.net.*;
class SMTPServer
{
	public static void main(String args[])
	{
		try
		{
			DatagramSocket server_socket=new DatagramSocket(2025);
			InetAddress client_addr;
			int port;
			String client_msg="";
			byte[] client_data=new byte[10];
			DatagramPacket client_datagram=new DatagramPacket(client_data,client_data.length);
			server_socket.receive(client_datagram);
			client_msg=new String(client_datagram.getData());
			System.out.println("CLIENT : "+client_msg);
			client_addr=client_datagram.getAddress();
			port=client_datagram.getPort();
			String server_msg=" ";
			byte[] server_data=new byte[10];
			server_msg="Ok";
			server_data=server_msg.getBytes();
			DatagramPacket server_datagram=new DatagramPacket(server_data,server_data.length,client_addr,port);
			server_socket.send(server_datagram);
			byte[] str_data = new byte[15];
			client_datagram=new DatagramPacket(str_data,str_data.length);
			server_socket.receive(client_datagram);
			String str=new String(client_datagram.getData());
			System.out.println("CLIENT : "+str);
			server_socket.send(server_datagram);
			byte[] str1_data=new byte[15];
			client_datagram=new DatagramPacket(str1_data,str1_data.length);
			server_socket.receive(client_datagram);
			String str1=new String(client_datagram.getData());
			System.out.println("CLIENT : "+str1);
			server_socket.send(server_datagram);
			byte[] str2_data=new byte[10];
			client_datagram=new DatagramPacket(str2_data,str2_data.length);
			server_socket.receive(client_datagram);
			String str2=new String(client_datagram.getData());
			System.out.println("CLIENT : "+str2);
			server_socket.send(server_datagram);
			byte[] data=new byte[20];
			client_datagram=new DatagramPacket(data,data.length);
			String line=new String(client_datagram.getData());
			while(line.charAt(0)!='.')
			{
				System.out.println(line);
				client_datagram=new DatagramPacket(new byte[20],data.length);
				server_socket.receive(client_datagram);
				line=new String(client_datagram.getData());
			}
			System.out.println("Enf of message : "+line);
			server_socket.send(server_datagram);
			byte[] str3_data =new byte[10];
			client_datagram =new DatagramPacket(str3_data,str3_data.length);
			server_socket.receive(client_datagram);
			String str3=new String(client_datagram.getData());
			server_socket.send(server_datagram);
		}
		catch(Exception e){}
	}
}

