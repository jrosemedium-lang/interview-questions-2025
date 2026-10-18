package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class ConsImpl implements Consumer<Integer>
{
	@Override
	public void accept(Integer t) {
		System.out.print("\nSquare of "+ t +" is " +(t*t)+1);
	}
}

public class ForEachInternalWorking {
	public static void main(String[] args) {
		List<Integer> values = Arrays.asList(5,6,7,8,9);
		Consumer<Integer> consumeNumbers = new ConsImpl();
		values.forEach(consumeNumbers);
	}
}
