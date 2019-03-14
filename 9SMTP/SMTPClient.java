import java.io.*;
import java.net.*;
class SMTPClient
{
	public static void main(String args[])
	{
		try
		{
			DatagramSocket socket=new DatagramSocket();
			InetAddress server_addr=InetAddress.getByName("127.0.0.1");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("coverting to mail server..");
			System.out.println("send hello");
			String client_msg;
			byte[] client_data=new byte[10];
			client_msg=br.readLine();
			client_data=client_msg.getBytes();
			DatagramPacket client_datagram=new DatagramPacket(client_data,client_data.length,server_addr,2025);
			socket.send(client_datagram);
			String server_msg="";
			byte[] server_data=new byte[10];
			DatagramPacket server_datagram=new DatagramPacket(server_data,server_data.length);
			socket.receive(server_datagram);
			server_msg=new String(server_datagram.getData());
			System.out.println("SERVER:"+server_msg);
			System.out.println("MAIL From:");
			String str=br.readLine();
			byte[] str_data=new byte[15];
			str_data=str.getBytes();
			client_datagram=new DatagramPacket(str_data,str_data.length,server_addr,2025);
			socket.send(client_datagram);
			server_datagram=new DatagramPacket(server_data,server_data.length);
			socket.receive(server_datagram);
			server_msg=new String(server_datagram.getData());
			System.out.println("SERVER: "+server_msg);
			System.out.println("RCPT TO: ");
			String str1=br.readLine();
			byte[] str1_data=new byte[15];
			str1_data=str1.getBytes();
			client_datagram=new DatagramPacket(str1_data,str1_data.length,server_addr,2025);
			socket.send(client_datagram);
			server_datagram=new DatagramPacket(server_data,server_data.length);
			socket.receive(server_datagram);
			server_msg=new String(server_datagram.getData());
			System.out.println("SERVER: "+server_msg);
			System.out.println("DATA: ");
			String str2="DATA";
			byte[] str2_data=new byte[15];
			str2_data=str2.getBytes();
			client_datagram=new DatagramPacket(str2_data,str2_data.length,server_addr,2025);
			socket.send(client_datagram);
			server_datagram=new DatagramPacket(server_data,server_data.length);
			socket.receive(server_datagram);
			server_msg=new String(server_datagram.getData());
			System.out.println("SERVER: "+server_msg);
			System.out.println("Send message(end it with a single dot in a line): ");
			String line=br.readLine();
			while(line.charAt(0)!='.')
			{
				byte[]data=new byte[20];
				data=line.getBytes();
				client_datagram=new DatagramPacket(data,data.length,server_addr,2025);
				socket.send(client_datagram);
				line=new String(br.readLine());
			}
			byte[] data=new byte[20];
			data=line.getBytes();
			client_datagram=new DatagramPacket(data,data.length,server_addr,2025);
			socket.send(client_datagram);
			server_datagram=new DatagramPacket(server_data,server_data.length);
			socket.receive(server_datagram);
			server_msg=new String(server_datagram.getData());
			System.out.println("SERVER: "+server_msg);
			String str3="QUIT";
			byte[] str3_data=new byte[10];
			str3_data=str3.getBytes();
			client_datagram=new DatagramPacket(str3_data,str3_data.length,server_addr,2025);
			socket.send(client_datagram);
			server_datagram=new DatagramPacket(server_data,server_data.length);
			socket.receive(server_datagram);
			server_msg=new String(server_datagram.getData());
			System.out.println("SERVER: "+server_msg);
		}
		catch(Exception e)
		{
		}
	}
}

