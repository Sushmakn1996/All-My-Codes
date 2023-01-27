package com.te.java8.stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamObjectCreation {

	public static void main(String[] args) throws IOException {

		// From Empty Stream
		Stream<String> stream = Stream.empty();
		System.err.println(stream);

		// From Collection
		List<Integer> list = Arrays.asList(2, 3);
		Stream<Integer> stream2 = list.stream().sorted(Comparator.naturalOrder());
		stream2.forEach(System.err::println);

		// From Arrays
		String[] arr = new String[] { "a", "b", "c" };
		Stream<String> streamOfArrayFull = Arrays.stream(arr);
		System.err.println(streamOfArrayFull);

		// From Stream Builder
		Stream<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c").build();
		System.err.println(streamBuilder);
		
		// From Stream Generate
		Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
		System.err.println(streamGenerated);
		
		// From Stream Iterate
		Stream<Integer> streamIterated = Stream.iterate(1, n -> n + 2).limit(5);
		System.err.println(streamIterated);
		
		// From Stream of file
//		Path path = Paths.get("C:\\file.txt");
//		Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);
//		System.err.println(streamWithCharset);
		
		// From Stream of primitives
//		IntStream intStream = IntStream.range(1, 3);
//		LongStream longStream = LongStream.rangeClosed(1, 3);
//		System.err.println(intStream+" "+longStream);
		
	}

}
