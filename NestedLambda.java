package JavaCodingExamplePkg;

@FunctionalInterface
interface MultiplyFunction<T,R> {
	int multiply(int a, int b);
}

@FunctionalInterface
interface AddFunctionNested<T, U,R> {
	MultiplyFunction<T,R> add(int a, int b);
}

public class NestedLambda {
	public static void main(String[] args) {
		MultiplyFunction<Integer, Integer> multiplyFunction = (a,b) -> a * b;

		AddFunctionNested<Integer,Integer, Integer> addFunction = (a, b) -> (x, y) ->  x * y;

		multiplyFunction = addFunction.add(2, 3);//sum = 5

		int result2 = multiplyFunction.multiply(4, 5);// 4 * 5 = 100

		System.out.println("Result: " + result2);
	}
}
