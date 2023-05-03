package Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketTest {
	public static void main(String[] args) throws IOException {
//		InetAddress[] addresses = InetAddress.getAllByName("google.com");
//		for (InetAddress address : addresses) {
//			System.out.println(address);
//		}
		InetAddress myadd = InetAddress.getLocalHost();
		System.out.println(myadd);

//        try (var s = new Socket("time-a.nist.gov", 13);
//        var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8)) {
//            while (in.hasNextLine()) {
//                String line = in.nextLine();
//                System.out.println(line);
//                InetAddress inetAddress = InetAddress.getByName("time-a.nist.gov");
//                System.out.println(inetAddress);
//            }
//        }
	}
}
