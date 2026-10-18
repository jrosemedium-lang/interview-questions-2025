package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsumerApp implements Consumer<Integer>
{
	@Override
	public void accept(Integer t) {
		System.out.println("Play with cubes : "+(t*t*t));
	}
}
/*
 * Invalid functional interface
 * 
@FunctionalInterface
interface MyCreepyConsumer{
	public void parameterAcceptor();
	public void inputAcceptor(int p);					//only one abstract method allowed
	public boolean equals(Object obj); 				//Object class cannot participate
}
*/

public class ConsumerInterfaceImpl {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(5,6,7,8);
		
		ConsumerApp consumerApp = new ConsumerApp();
		values.forEach(consumerApp);
		
		System.out.println();
		Consumer<Integer> consumerSquare = new Consumer<Integer>() {
			@Override
			public void accept(Integer t) {
				System.out.println("Play with squares : "+(t*t));
			}
		};
		values.forEach(consumerSquare);
		
		System.out.println();
		Consumer<Integer> crazyConsumer = (c) -> { 
			System.out.println("Wow! It's me the crazy consumer : " + c );
		};
		values.forEach(crazyConsumer);
		
		System.out.println();
		values.forEach((t) ->{
			System.out.println("Play as it is : "+t);
		});
		
		
		/*
		 * MyCreepyConsumer myCreepyConsumer = (String s) ->
		 * System.out.println("peeK-a-boO");
		 */
	}
}
