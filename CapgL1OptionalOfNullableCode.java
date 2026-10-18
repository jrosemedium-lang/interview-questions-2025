package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * 
 * 
 Assume that you have a list of names and your list contains
 a mix of names that are ending with "lal" and not ending with lal as well.

1) Your code must list the names ending with "lal".

For eg if the list of names is {Ram,Vinitha,Mohanlal,Jawaharlal} your 
code must display only Mohanlal and Jawaharlal.

2)Your code must display the names not ending with "lal" - 
it must display only Ram and Vinitha from above list.

3)Add null as input to your list i.e. {Ram,Vinitha,Mohanlal,Jawaharlal,null} - 
your code must not throw null pointer exception and as well display names not ending with "lal"

 * 
 * */
public class CapgL1OptionalOfNullableCode {
	public static void main(String[] args) {
		List<String> namesList = Arrays.asList("Ram","Vinitha","Mohanlal","Jawaharlal",null);
		String testString = "lal";
		
		Predicate<Optional<String>> isStrPresent = str -> str.isPresent();
		Predicate<Optional<String>> isTestStringOptPresent = str -> str.get().endsWith(testString);
		Predicate<String> isTestStringPresent = str -> str.endsWith(testString);
		
		System.out.println(
			namesList.stream()
							  .map(eachString -> Optional.ofNullable(eachString))
							  .filter(isStrPresent)
							  .filter(isTestStringOptPresent)
							  .map(eachNullableOptional -> eachNullableOptional.get())
							  .collect(Collectors.toList())
	   );
		
		System.out.println(
				namesList.stream()
								  .map(eachString -> Optional.ofNullable(eachString))
								  .filter(isStrPresent)
								  .filter(isTestStringOptPresent.negate())
								  .map(eachNullableOptional -> eachNullableOptional.get())
								  .collect(Collectors.toList())
		 );
		
		
		System.out.println(
				namesList.stream()
								  .filter(each -> each!=null)
								  .filter(isTestStringPresent)
								  .collect(Collectors.toList())
		   );
			
			System.out.println(
					namesList.stream()
									  .filter(each -> each!=null)
									  .filter(isTestStringPresent.negate())
									  .collect(Collectors.toList())
			 );
	}
}