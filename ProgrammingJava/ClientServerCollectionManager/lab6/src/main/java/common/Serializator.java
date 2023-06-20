package common;

import java.io.*;

public class Serializator {
	
	public Serializator() {
	}
	
	public byte[] serializeObject(Object object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream ous = new ObjectOutputStream(baos);
		ous.writeObject(object);
		ous.flush();
		ous.close();
		return baos.toByteArray();
	}
	
	public Response deserialize(byte[] bytes) throws IOException, ClassNotFoundException{
		ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
		try (ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {
			return (Response) objectStream.readObject();
		}
	}
}
