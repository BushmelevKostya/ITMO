package Test.UDP;

import java.net.*;
import java.io.*;

public class UDPClient {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String request;
		String response;
		byte[] sendBytes;
		byte[] receiveBytes = new byte[1024];

		try (DatagramSocket clientSocket = new DatagramSocket()){
			InetAddress address = InetAddress.getByName("localhost");
			while (true) {
				System.out.println("Ente message: ");
				request = br.readLine();
				sendBytes = request.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendBytes, sendBytes.length, address, 9876);
				clientSocket.send(sendPacket);
				
				DatagramPacket receivePacket = new DatagramPacket(receiveBytes, receiveBytes.length);
				clientSocket.receive(receivePacket);
				response = new String(receivePacket.getData(), 0, receivePacket.getLength());
				System.out.println("From Server : " + response);
			}
		}
	}
}