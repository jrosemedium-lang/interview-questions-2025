package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierConsumerAndThenExample {

	public static void main(String[] args) {
		/**
		 * Reference:
		 * https://stackoverflow.com/questions/28417262/java-8-supplier-consumer-explanation-for-the-layperson
		 **/
		
		// new operator itself is a supplier, of the reference to the newly created object
		Supplier<List<String>> listSupplier = ArrayList<String>::new;
		Consumer<String> printConsumer = a1 -> System.out.println(a1);
		BiConsumer<Integer, Integer> sumConsumer = (a1, a2) -> System.out.println(a1 + a2);
		
		System.out.println(listSupplier);
		printConsumer.accept("This shows yet another consumer example...");
		/*interestingly possible and weird*/
		printConsumer.andThen(printConsumer.andThen(printConsumer.andThen(printConsumer)));
		
		sumConsumer.accept(4, 4);
		
		/**
		 * https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
		 * */
		System.out.println("------------------------------------------------------------");
		
		/*Created a supplier*/
		Supplier<List<Integer>> numberSupplier = ArrayList<Integer>::new;
		
		/*Created a consumer and defined accept method to MODIFY*/
		Consumer<List<Integer>> numberModifier = list -> {
			System.out.println("numberModifier Invoked");
			for (int i = 0; i < list.size(); i++) {
				list.set(i, list.get(i) * 2);
				
				/*if(list.get(i) == 4)
					throw new NullPointerException();*/
			}
		};
		
		/*Created a consumer and defined accept method to SHOW*/
		Consumer<List<Integer>> showList = list -> {System.out.println("showList Invoked");list.stream().forEach(System.out::println);};
		
		/*Got a list using SUPPLIER*/
		List<Integer> myList = numberSupplier.get();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		myList.add(5);
		
		try
		{
			/*Accept method will take a list, perform modification, show output*/
			numberModifier.andThen(showList).accept(myList);
			numberModifier.andThen(showList);//leaving andThen without an accept will not invoke this line
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
/*See also: https://mkyong.com/java8/java-8-method-references-double-colon-operator/*/
}
