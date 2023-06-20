package Test;

import server.jwt.JWTToken;

import java.io.*;

public class TestGenerator {
	private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static void main(String[] args) throws IOException {
//		System.out.println(generateRandomKey(32));
//		try {
//			String pathToFile = "src/main/java/common/data/ScriptInsert.txt";
//			OutputStream os = Files.newOutputStream(Paths.get(pathToFile));
//			for (int i = 0; i < 8000; i++) {
//				String string = "insert\nproduct\n-3\n4\n" + i + "\n" + i + "\n9999\nGRAMS\nHW\n" + i + "\n7\n9889\nTRUST\n\n";
//				byte[] bytes = string.getBytes();
//				os.write(bytes);
//			}
//		} catch (IOException exception) {
//			System.out.println(exception.getMessage());
//		}
	}
}
//	public static String generateRandomKey(int length) {
//		SecureRandom random = new SecureRandom();
//		StringBuilder sb = new StringBuilder(length);
//
//		for (int i = 0; i < length; i++) {
//			int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
//			char random_char = ALLOWED_CHARACTERS.charAt(randomIndex);
//			sb.append(random_char);
//		}
//		return sb.toString();
//	}
