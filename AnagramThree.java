package JavaCodingExamplePkg;

public class AnagramThree {
	public static void main(String[] args) {
		String a = "hello";
		String b = "Hello";

		java.util.function.Function<String, java.util.LinkedHashMap<Character, Long>> myFunction 
		= mytestString -> mytestString
				.chars()
				.mapToObj(c -> (char) c)
				.collect(java.util.stream.Collectors.groupingBy(x -> Character.toLowerCase(x),
						java.util.LinkedHashMap::new, 
						java.util.stream.Collectors.counting()));

		java.util.LinkedHashMap<Character, Long> myMapA = myFunction.apply(a);
		java.util.LinkedHashMap<Character, Long> myMapB = myFunction.apply(b);

		System.out.println(myMapA);
		System.out.println(myMapB);
		
		System.out.println(java.util.Objects.deepEquals(myMapA, myMapB));
	}
}
