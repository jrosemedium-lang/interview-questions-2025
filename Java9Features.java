package JavaCodingExamplePkg;

import java.lang.System.Logger;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class Java9Features {

	public static void main(String[] args) {
		System.out.println("---1--------");
		Stream.of(1, 2, 3, 4, 5).takeWhile(i -> i == 1).forEach(System.out::println);
		System.out.println("takeWhile prints 1");
		System.out.println("--2---------");

		Stream.of(1, 2, 3, 4, 5).takeWhile(i -> i == 4).forEach((i) -> {
			System.out.println("Prints Nothing");
			System.out.println("i=" + i);
		});

		System.out.println("--3---------");

		Stream.of(1, 2, 3, 4, 5).dropWhile(i -> i < 4).forEach((i) -> {
			System.out.println("Prints 4,5");
			System.out.println("i=" + i);
		});

		System.out.println("--4---------");
		String name = null;
		Optional<String> optionalName = Optional.ofNullable(name);
		System.out.println(optionalName.isPresent()); // Output: false
//	       System.out.println(optionalName.get());//gives exception
		System.out.println(optionalName.orElse("Default")); // Output: Default

		System.out.println("--5---------");
		Stream.iterate(1, n -> n <= 5, n -> n + 1).forEach(System.out::println); // Output: 1, 2, 3, 4, 5

	}
}

class CustomLogger implements Logger {
	@Override
	public String getName() {
		return "CustomLogger";
	}

	@Override
	public boolean isLoggable(Level level) {
		return true; // Enable logging for all levels
	}

	@Override
	public void log(Level level, String msg) {
		System.out.printf("[%s] %s%n", level, msg);
	}

	@Override
	public void log(Level level, String msg, Throwable thrown) {
		System.out.printf("[%s] %s - %s%n", level, msg, thrown.getMessage());
	}

	@Override
	public void log(Level level, ResourceBundle bundle, String msg, Throwable thrown) {
		// TODO Auto-generated method stub

	}

	@Override
	public void log(Level level, ResourceBundle bundle, String format, Object... params) {
		// TODO Auto-generated method stub

	}
}
