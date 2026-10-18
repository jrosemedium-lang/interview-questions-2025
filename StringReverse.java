package JavaCodingExamplePkg;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Objectify {
	int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Objectify() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Objectify(int num) {
		super();
		this.num = num;
	}
	
}

public class StringReverse {
	public static void main(String[] args) {
		String str = new String("ABCDE");
		
		//"Alphonso";
		Stream.of(str);
		
		str.chars().forEach(c -> {
			System.out.println(c);
		});
		
		System.out.println("---------------");
		
		
		str.chars().mapToObj(cSurrogateCode -> (char) cSurrogateCode).forEach(cChar -> {
			System.out.println(cChar);
		});
		
		str.chars()
		.mapToObj(cSurrogateCode -> (char) cSurrogateCode)
		.collect(Collectors.collectingAndThen(Collectors.toList(), list ->{ 
			java.util.Collections.reverse(list);
			return Stream.of(list);
		})).forEach(cChar -> {
			System.out.println("---");
			System.out.println(cChar);
		});
		
		String newString = str.chars()
		.mapToObj(cSurrogateCode -> (char) cSurrogateCode)
		.collect(Collectors.collectingAndThen(Collectors.toList(), list ->{ 
			java.util.Collections.reverse(list);
			return Stream.of(list);
		}))
		.map(String::valueOf) // we need this because collect needs list of String and not of character
		.collect(Collectors.joining());
				
		System.out.println("Final Answer - " + newString);

		String newString2 = str.chars()
				.mapToObj(cSurrogateCode -> (char) cSurrogateCode)
				.collect(Collectors.collectingAndThen(Collectors.toList(), list ->{ 
					java.util.Collections.reverse(list);
					return Stream.of(list);
				}))
				.map(String::valueOf) // we need this because collect needs list of String and not of character
				.collect(Collectors.joining());
		
		String input = "Hello, World!";
        String reversed = IntStream.range(0, input.length())
            .mapToObj(i -> {System.out.println(i); return input.charAt(input.length() - 1 - i);}) //if we pass the i, it works as the i of forloop
            .map(String::valueOf)
            .collect(Collectors.joining());

        System.out.println(reversed); 
		
		Objectify objectified = new Objectify(10);
		objectified.getNum();
	}
}
