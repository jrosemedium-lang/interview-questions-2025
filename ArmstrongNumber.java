package JavaCodingExamplePkg;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArmstrongNumber {
	public static void main(String[] args) {
		int n=153,r,sum=0,temp;    
		temp=n;    
		while(n>0)    
		{    
			r=n%10;						//153%10 = 3;    ||  15%10 = 5 || 1 % 5 = 1
			sum=sum+(r*r*r); //0 + (3*3*3) = 27 || 27+(5*5*5) = 152 || 152 + 1 = 153
			n=n/10; 						//153 / 10 = 15 || 15 / 10 = 1 || 1 / 10 = 0 then break
		}    
		if(temp==sum)    
			System.out.println("armstrong  number ");    
		else    
			System.out.println("not armstrong number");    
		
		
		//*********************
		
		//To apply Streams on a number below is the method and snippet - 
		int myInt = 5, intBlank;
		IntStream.of(myInt)
			.forEach(System.out::println);
		
		//You can also apply it on an array
		int myIntArray []= {1,2,4,3,5};
		IntStream.of(myIntArray)
						.forEach(System.out::println);
	
		//For ArmStrong though, we just need a number so we will stick to myInt
		//To perform armStrong we must iterate and have control of each iteration
		//IntStream provides us with iterate method from java8
		/*
		 * As is from github co-pilot below code is error prone because - 
		 * 
		 * 
		 	IntStream.iterate(0,myInt->myInt/10)
								.forEach(System.out::println);
		
		 * The error occurs because the parameter name myInt in the lambda expression myInt -> myInt / 10 
		 * conflicts with the variable myInt defined in the enclosing scope. 
		 * When you use IntStream.of(myInt), it does not involve a lambda expression, so there's no conflict. 
		 * However, when using IntStream.iterate, the lambda expression parameter name must be unique 
		 * and not conflict with any variable names in the enclosing scope.
		 * 
		 * 
		 * Just use a different variable, See in the logic, you cannot keep one variable myInt to hold two values, one being
		 * our seed value=153 others would be the intermediate calculation values say 153/10
		 * 
		 * What matters for scope is what we define/declare right before the lambda symbol
		 * here nBrandNew is in scope, myInt if tried and kept in scope u get the golden error stating
		 * Lambda expression's parameter myInt cannot redeclare another local variable defined in an enclosing scope. 
		*/
		
		IntStream.iterate(myInt,nBrandNew->myInt/10)
							.limit(0)
							.forEach(System.out::println);
						
		//Now we are happy because nBrandNew is a fully new variable to hold values in intermediate calculation
		//myInt = 153;//is not possible
		
		//Local variable myInt defined in an enclosing scope must be final or effectively final, re-initializing is also not possible
		//effectively final means, compiler knows that you as coder has not re-initialized myInt again, 
		//it is final even without mentioning and it's value won't change if not touched by Streams and lambdas
		
		System.out.println("myInt is no longer 153 because of above stream and because we cannot re-initialize it again! ---- "+myInt);
		
		IntStream.iterate(myInt,anotherBlank->myInt/10)
			.limit(0) //uncomment to see infinite loop as 5/10 will give 0
			.forEach(System.out::println);
		
		int myNewInt=153;
		IntStream.iterate(myNewInt, anotherBlank->myNewInt>0, anotherBlank->myNewInt/10);
		 //.forEach((anotherBlank)->{
		//	   System.out.println(anotherBlank);
		//	   System.out.println(myNewInt);
		 //  });//This is wrong because now myNewInt will always remain 153 and reassignment won't occur to anotherBlank with new intermediate value as it naturally should

		//	anotherBlank->myNewInt>0 -- Similar to n> 0 condition of while loop
		// anotherBlank->myNewInt/10 -- Similar to n=n/10;
		
		System.out.println("-----------------------------myNewInt2");
		int myNewInt2=153;
		IntStream.iterate(myNewInt2, anotherBlank->anotherBlank>0, anotherBlank->anotherBlank/10)
						   .forEach((anotherBlank)->{
							   System.out.println("values intermediately -  "+anotherBlank);
							   System.out.println(myNewInt);
						   });
		
		
		System.out.println("-----------------------------myNewInt3");
		int myNewInt3=153;
		int armStrongerNum = IntStream.iterate(myNewInt3, anotherBlank->anotherBlank>0, anotherBlank->anotherBlank/10)
							.map(n1 -> n1%10)
							.map(n2 -> (int) Math.pow(n2, 3))
							.sum()
							;
		
		System.out.println(armStrongerNum);
		
		System.out.println("-----------------------------myNewInt4");
		int myNewInt4=153;
		OptionalInt tempAgain = IntStream.iterate(myNewInt3, anotherBlank->anotherBlank>0, anotherBlank->anotherBlank/10)
							.map(n1 -> n1%10)
							.map(n2 -> (int) Math.pow(n2, 3))
							.reduce((accumulator, n3)-> n3+accumulator);
							
		System.out.println("See "+tempAgain.getAsInt());
		
		System.out.println("-----------------------------myNewInt5");
		boolean resultIs = false;
		int myNewInt5=153;
		resultIs = IntStream.iterate(myNewInt5, anotherBlank->anotherBlank>0, anotherBlank->anotherBlank/10)
							.map(n1 -> n1%10)
							.map(n2 -> (int) Math.pow(n2, 3))
							.reduce((accumulator, n3)-> n3+accumulator).getAsInt()
							== 153;
						
							
		System.out.println("myNewInt5 is an armstrong nUmber is  - "+resultIs);
		
		System.out.println("-----------------------------myNewInt6");
		resultIs = false;
		resultIs = IntStream.iterate(myNewInt5, anotherBlank->anotherBlank>0, anotherBlank->anotherBlank/10)
							.map(n1 -> n1%10)
							.map(n2 -> (int) Math.pow(n2, 3))
							.reduce(Integer::sum).getAsInt()
							== 153;
						
							
		System.out.println("myNewInt5 is an armstrong nUmber is  - "+resultIs);
		sum = String.valueOf(n) // "153"
				.chars()                // IntStream of Unicode values of '1', '5', '3'
				.map(ch -> ch - '0')    // Convert char to int
				.map(d -> d * d * d)    // Cube each digit
				.sum();                 // Sum them

		System.out.println(sum);    // 153
		System.out.println(sum == n ? "Armstrong" : "Not Armstrong");
	}
}
