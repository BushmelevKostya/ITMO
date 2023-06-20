package Test;

import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		Stream<Double> randoms = Stream.generate(Math::random);
		System.out.println(randoms.count());
	}
}
