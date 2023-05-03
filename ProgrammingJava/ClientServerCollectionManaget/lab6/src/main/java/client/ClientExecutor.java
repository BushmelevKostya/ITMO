package client;

import common.Serializator;
import common.product.Product;
import common.Request;
import common.Response;
import common.exception.*;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;

public class ClientExecutor {
	private final HashMap<String, ClientCommand> commandMap = new ClientCommandMap().getMap();
	private final ClientValidator validator = new ClientValidator();
	private final Serializator serializator = new Serializator();
	
	public ClientExecutor() {
	}
	
	/**
	 * this method use when program has been started
	 */
	public void run() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		     DatagramSocket clientSocket = new DatagramSocket()) {
			InetAddress address = InetAddress.getByName("localhost");
			System.out.println("Введите команду в формате: \"<команда> <ключ>\"");
			while (true) {
				String string = br.readLine().strip();
				execute(clientSocket, address, string);
				System.out.println("\nВведите команду в формате: \"<команда> <ключ>\"");
			}
		} catch (ExitException ignored) {
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	public void execute(DatagramSocket clientSocket, InetAddress address, String string) throws ExitException {
		Reader reader = new Reader(string);
		String command = reader.getCommand();
		var value = reader.getValue();
		
		try {
			if (validator.check(string) && validator.checkCommand(command) && validator.checkParam(command, value)) {
				Request request = new Request(command, value);
				var executeCommand = commandMap.get(command);
				if (executeCommand != null) {
					executeCommand.execute(value);
					Product product = executeCommand.getProduct();
					if (product != null) {
						request.setProduct(product);
					}
				}
				
				request.setRequestType("POST");
				byte[] byteRequest = serializator.serializeObject(request);
				
				DatagramPacket sendPacket = new DatagramPacket(byteRequest, byteRequest.length, address, 9876);
				clientSocket.send(sendPacket);
				
				byte[] receiveBytes = new byte[10000];
				DatagramPacket receivePacket = new DatagramPacket(receiveBytes, receiveBytes.length);
				clientSocket.receive(receivePacket);
				Response response = serializator.deserialize(receivePacket.getData());
				System.out.println("From Server : " + response.getAnswer());
			}
		} catch (IOException | ClassNotFoundException | FalseTypeException | FalseValuesException | NumberFormatException exception) {
			System.out.println(exception.getMessage());
		} catch (ExitException ignored) {
		}
	}
	
	public void runScript(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = br.readLine().strip();
			while (line != null) {
				try {
					executeScript(line);
					try {
						line = br.readLine().strip();
					} catch (NullPointerException exception) {
						line = null;
					}
				} catch (NumberFormatException exception) {
					System.out.println("Некорректные данные в файле " + fileName + " : " + exception.getMessage());
					break;
				} catch (ClassNotFoundException | FalseValuesException | NullPointerException |
				         IllegalArgumentException | FalseTypeException |
				         InfiniteException | UniqueException | NullStringException exception) {
					System.out.println(exception.getMessage());
					break;
				} catch (ExitException exception) {
					break;
				}
			}
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}

//	public void executeScript(String str, BufferedReader br) throws ExitException, IOException, NullPointerException, FalseValuesException, IllegalArgumentException, FalseTypeException, InfiniteException, UniqueException, NullStringException {
//		Reader reader = new Reader(str);
//		String command = reader.getCommand();
//		var value = reader.getValue();
//		if (validator.check(str) && validator.checkCommand(command) && validator.checkParam(command, value)) {
//			if (!command.equals("insert")) {
//				commandMap.get(command).execute(value);
//			} else {
//				new InsertScriptCommand(br).execute(value);
//			}
//		} else {
//			throw new ExitException();
//		}
//	}
	
	public void executeScript(String string) throws ExitException, IOException, ClassNotFoundException, NullPointerException, FalseValuesException, IllegalArgumentException, FalseTypeException, InfiniteException, UniqueException, NullStringException {
		try (DatagramSocket clientSocket = new DatagramSocket()) {
			InetAddress address = InetAddress.getByName("localhost");
			execute(clientSocket, address, string);
		}
	}
}
