package JavaCodingExamplePkg;

@FunctionalInterface
interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}

public class TriFunctionInterface {
	public static void main(String[] args) {
		float P = 10000.0f,  R = 5,  T = 5;

		// Lambda to calculate simple interest
		TriFunction<Float, Float, Float, Float> calculateSI =
				(principal, rate, time) -> (principal * rate * time) / 100;

				// Calculate simple interest
				float SI = calculateSI.apply(P, R, T);

				// Print the result
				System.out.println("Simple interest = " + SI);
	}
}
