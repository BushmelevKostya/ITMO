package client.commands;

import client.ClientCommand;
import client.ClientValidator;
import client.builder.Director;
import client.builder.ProductBuilder;
import common.Request;
import common.Response;
import common.Serializator;
import common.exception.FalseTypeException;
import common.product.Product;
import common.exception.ExitException;
import common.exception.NoElementException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UpdateClientCommand extends ClientCommand {
	
	private final ClientValidator validator = new ClientValidator();
	
	private Product product;
	
	private final Serializator serializator = new Serializator();
	
	public UpdateClientCommand() {
	}
	
	@Override
	public void execute(String value) throws ExitException, NumberFormatException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		     DatagramSocket clientSocket = new DatagramSocket()) {
			InetAddress address = InetAddress.getByName("localhost");
			
			var id = validator.checkParamType(value);
			var newProduct = new Director(new ProductBuilder(id)).make();
			
			System.out.println("Вы хотите обновить старый элемент или создать новый?\nold/new");
			String str = br.readLine().strip();
			if (str.equals("old")) {
				System.out.println("Выполняется запрос элемента коллекции на сервер...");
				Request request = new Request("update", value);
				request.setRequestType("GET");
				byte[] byteRequest = serializator.serializeObject(request);
				DatagramPacket sendPacket = new DatagramPacket(byteRequest, byteRequest.length, address, 9876);
				clientSocket.send(sendPacket);
				
				byte[] receiveBytes = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(receiveBytes, receiveBytes.length);
				clientSocket.receive(receivePacket);
				Response response = serializator.deserialize(receivePacket.getData());
				Product product = response.getProduct();
				if (product != null) {
					System.out.println("Элемент коллекции получен!");
					execute(product.getId(), product);
				}
			}
			setProduct(newProduct);
		} catch (NumberFormatException exception) {
			throw new NumberFormatException("Этой команде необходимо передать параметр типа int!");
		} catch (IOException | FalseTypeException | ClassNotFoundException | NoElementException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	/**
	 * @param id      id of the element being changed
	 * @param product new value if it already exists
	 */
	public void execute(Integer id, Product product) throws IOException, ExitException, NoElementException {
		var newProduct = new Director(new ProductBuilder(id)).make(product);
		setProduct(newProduct);
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
}
