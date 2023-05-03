package server.main;

import server.ServerValidator;
import server.Starter;
import server.ServerExecutor;

public class UDPServer {
	
	public static void main(String[] args) throws Exception {
		
		String fileName = new ServerValidator().checkFileName(args);
		new Starter(fileName.strip()).run();
		new ServerExecutor().run();
	}
}