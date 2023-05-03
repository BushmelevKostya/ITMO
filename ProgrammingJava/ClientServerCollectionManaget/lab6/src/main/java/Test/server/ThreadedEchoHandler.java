package Test.server;

import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable {
	private final Socket incoming;
	private final int count;
	
	public ThreadedEchoHandler(Socket incoming, int count) {
		this.incoming = incoming;
		this.count = count;
	}
	
	@Override
	public void run() {
		try {
			InputStream inStream = incoming.getInputStream();
			OutputStream outStream = incoming.getOutputStream();
			
			try (var in = new Scanner(inStream, StandardCharsets.UTF_8)) {
				var out = new PrintWriter(new OutputStreamWriter(outStream, StandardCharsets.UTF_8), true);
				out.println("Hello! Enter BYE to exit.");
				out.println("You are our " + count + " user!");
				var done = false;
				while (!done && in.hasNextLine()) {
					String line = in.nextLine();
					out.println("Echo: " + line);
					if (line.strip().equals("BYE")) done = true;
				}
			}
		} catch (IOException exception){
			System.out.println(exception.getMessage());
		}
	}
}
