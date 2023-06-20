package Test.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		try (var s = new ServerSocket(8189)){
			int i = 0;
			while (true){
				Socket incoming = s.accept();
				i++;
				Runnable r = new ThreadedEchoHandler(incoming, i);
				var t = new Thread(r);
				t.start();
			}
		} catch (IOException exception){
			System.out.println(exception.getMessage());
		}
	}
}
