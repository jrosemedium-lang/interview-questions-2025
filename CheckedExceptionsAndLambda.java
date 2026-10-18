package JavaCodingExamplePkg;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface CheckedFunction<T, R> {
    R apply(T t) throws Exception;
}
public class CheckedExceptionsAndLambda {
	public static <T, R> Function<T, R> handleCheckedException(CheckedFunction<T, R> checkerLogic) {
	    return item -> {
	    	 try {
		            return checkerLogic.apply(item);
		        } catch (Exception e) {
		        	System.err.println("Error processing: " + item + " - " + e.getMessage());
		            return null;
		        }
	    };
	}
	public static void main(String[] args) {
		
		List<String> data = List.of("1", "2", "a", "4");
		List<Integer> result = data.stream()
		    .map(handleCheckedException(str -> Integer.parseInt(str)))//Integer::parseInt
		    .collect(Collectors.toList());
		
		
		List<Integer> result2 = data.stream()
			    .map(handleCheckedException(str ->Integer.parseInt(str) + 100))//Integer::parseInt
			    .collect(Collectors.toList());
		
		
		List<Integer> result3 = data.stream()
			    .flatMap(item -> {
			        try {
			            return Stream.of(Integer.parseInt(null));
			        } catch (NumberFormatException e) {
			            return Stream.empty(); // Skip invalid elements
			        }
			    })
			    .collect(Collectors.toList());
		
		System.out.println(result3);
	}

}
