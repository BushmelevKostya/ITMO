package client.main;

import client.ClientExecutor;

public class UDPClient {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Добрый день! Используйте help для получения перечня команд.\n");
		new ClientExecutor().run();
	}
}