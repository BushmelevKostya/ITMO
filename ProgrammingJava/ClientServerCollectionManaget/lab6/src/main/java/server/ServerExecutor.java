package server;

import common.product.Product;
import common.exception.ExitException;
import common.exception.FalseValuesException;
import common.exception.NoElementException;
import common.exception.UniqueException;
import common.Request;
import common.Response;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class ServerExecutor {
	
	public ServerExecutor() {
	}
	
	public void run() throws IOException, ClassNotFoundException, ExitException {
		DatagramChannel channel = DatagramChannel.open();
		channel.configureBlocking(false);
		channel.bind(new InetSocketAddress("localhost", 9876));
		
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_READ);
		System.out.println("Server has been started!");
		while (true) {
			int readyChannels = selector.select();
			if (readyChannels == 0) continue;
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
			
			while (keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				if (key.isReadable()) {
					DatagramChannel datagramChannel = (DatagramChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(10000);
					InetSocketAddress clientAddress = (InetSocketAddress) datagramChannel.receive(buffer);
					buffer.flip();
					byte[] byteRequest = buffer.array();
					Request request = deserialize(byteRequest);
					Response response = new Response();
					try {
						if (request.getRequestType() != null && request.getRequestType().equals("GET")) {
							var id = request.getValue();
							try{
								Product product = new ServerValidator().getById(Integer.parseInt(id));
								response.setProduct(product);
							} catch (NumberFormatException exception) {
								throw new NumberFormatException("Этой команде необходимо передать параметр типа int!");
							}
						} else {
							String answer = new CommandExecutor(request.getCommand(), request.getValue(), request.getProduct()).run();
							response.setAnswer(answer);
						}
					} catch(NumberFormatException | FalseValuesException | UniqueException |
					        NoElementException exception){
						String message = response.getAnswer() + "\n" + exception.getMessage();
						response.setAnswer(message);
					}
					
					buffer.clear();
					
					byte[] byteResponse = serializeObject(response);
					
					buffer.put(byteResponse);
					buffer.flip();
					datagramChannel.send(buffer, clientAddress);
					keyIterator.remove();
				}
			}
		}
	}
	
	public Request deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
		try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
			return (Request) objectStream.readObject();
		}
	}
	
	public byte[] serializeObject(Object object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream ous = new ObjectOutputStream(baos);
		ous.writeObject(object);
		ous.flush();
		ous.close();
		return baos.toByteArray();
	}
}
