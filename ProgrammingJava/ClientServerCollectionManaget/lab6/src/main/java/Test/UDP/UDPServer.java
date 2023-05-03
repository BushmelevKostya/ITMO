package Test.UDP;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class UDPServer {
	
	public static void main(String[] args) throws Exception {
		DatagramChannel channel = DatagramChannel.open();
		channel.configureBlocking(false);
		channel.bind(new InetSocketAddress("localhost", 9876));
		
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_READ);
		while (true) {
			System.out.println(channel.isOpen());
			int readyChannels = selector.select();
			if (readyChannels == 0) continue;
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
			
			while (keyIterator.hasNext()) {
				SelectionKey key = keyIterator.next();
				if (key.isReadable()) {
					DatagramChannel datagramChannel = (DatagramChannel) key.channel();
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					InetSocketAddress clientAddress = (InetSocketAddress) datagramChannel.receive(buffer);
					buffer.flip();
					String message = new String(buffer.array(), 0, buffer.limit());
					System.out.println("From client: " + clientAddress + " get message: " + message);
					buffer.clear();
					buffer.put("All is OK".getBytes());
					buffer.flip();
					datagramChannel.send(buffer, clientAddress);
					keyIterator.remove();
				}
			}
		}
	}
}