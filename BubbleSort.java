package JavaCodingExamplePkg;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class BubbleSort {
	static void bubbleSort(int arr[], int n){
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			//System.out.println(" i = "+i);
			for (j = 0; j < n - i - 1; j++) {
				//System.out.print(" j = "+j);

				if (arr[j] > arr[j + 1]) {
					// Swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			//System.out.println(j);
			// If no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

	// Function to print an array
	static void printArray(int arr[], int size){
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]){
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		int n = arr.length;
		bubbleSort(arr, n);
		System.out.println("Sorted array: ");
		printArray(arr, n);
		
		
		
		
		//////////////SWAP TWO INTEGERS USING JAVA LAMBDAS
		System.out.println();
		System.out.println("SWAP TWO INTEGERS USING JAVA LAMBDAS");
		int num1[] = {10};
		int num2[] = {7};

		BiConsumer<int[], int[]> swapper = (var1, var2) -> {
			var1[0] = var1[0] + var2[0]; // 10+7 = 17<=var1[0]
			var2[0] = var1[0] - var2[0]; // 17-7 = 10<=var2[0]
			var1[0] = var1[0] - var2[0];// 17-10 = 7<=var1[0]
		};
		
		swapper.accept(num1, num2);
		System.out.println("num1[0] = "+num1[0]+";; num2[0] =" + num2[0]);
		
		/*
		Why arrays why not without arrays?
				Good question! The reason we used arrays is because Java's lambda expressions 
				are designed to work with final or effectively final variables. 
				This means we cannot directly modify primitive types (like int) within a lambda expression, 
				as their values can't be changed within the lambda's scope. 
				Using arrays allows us to bypass this limitation, as arrays are mutable objects and their elements can be modified.
				if you want to swap integers without using arrays, you can use a wrapper class, such as AtomicInteger
				
				
			When was AtomicInteger Introduced? 
			Can u tell me in depth about what is Atomic? 
			What is all of this CAS, compare-and-swap instead of locks&synchronization?
			What is contention?
			
			Serializable vs Externaliable

			Arrays
				Mutability: Arrays are mutable objects, meaning their elements can be modified even 
				if the array reference is final. By using an array, we can bypass the restriction of final 
				or effectively final variables, allowing us to modify the elements within the lambda expression.
	
				Simplicity: Using arrays is a simple and straightforward way to encapsulate multiple values 
				and modify them within a lambda expression.
				
			AtomicInteger
				Thread-Safety: AtomicInteger provides atomic operations on integers, ensuring thread safety 
				and consistency. Although this may not be necessary for simple integer swaps, 
				it demonstrates a common use case for AtomicInteger in more complex scenarios.

				Mutability: Like arrays, AtomicInteger is a mutable object. Its value can be modified 
				within the lambda expression, allowing us to perform the swap without violating 
				the final or effectively final constraint.
				
				
				Is an arrayReference always final in java?
					In Java, an array reference itself is not always final. However, you can declare an array reference 
					as final if you want to ensure that the reference cannot be reassigned to a different array. 
					This means that the reference to the array will remain constant, but the elements of the array 
					can still be modified.
					
				arrayReference CAN be effectively final in java, if it never gets assigned with new ArrayObject
					Exactly! If you use only one array in your Java logic and never reassign the array reference 
					to another array object, the array reference is considered effectively final. 
					This means that the reference remains unchanged after its initial assignment, 
					allowing it to be captured in lambda expressions or anonymous classes.
		*/
		
		AtomicInteger numAtomic1 = new AtomicInteger(5);
		AtomicInteger numAtomic2 = new AtomicInteger(10);
		
		BiConsumer<AtomicInteger, AtomicInteger> atomicSwapper = (atom1, atom2) -> {
			int temp = atom1.get();
			atom1.set(atom2.get());
			atom2.set(temp);
		};
		
		atomicSwapper.accept(numAtomic1, numAtomic2);
		
		System.out.println("\nnumAtomic1 = "+numAtomic1.get()+";;numAtomic2="+numAtomic2.get());
		
		
	}
}


/*
 * 
 *  
 i = 0
 j = 0 j = 1 j = 2 j = 3 j = 4 j = 5
 i = 1
 j = 0 j = 1 j = 2 j = 3 j = 4
 i = 2
 j = 0 j = 1 j = 2 j = 3
 i = 3
 j = 0 j = 1 j = 2
 i = 4
 j = 0 j = 1
 i = 5
 j = 0
 * 
 * */
