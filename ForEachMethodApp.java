package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ForEachMethodApp {

	public static void main(String[] args) {
		List<Integer> numList = Arrays.asList(4,5,6,7,44,8,9);
		String str;
		
		System.out.println("EXTERNAL LOOP------------- Traditional For-loop::::");
		for(int i=0; i<numList.size() ; i++)
		{
			System.out.print(numList.get(i)+",");
		}
		
		System.out.println("\nEXTERNAL LOOP------------- ForEach -loop::::");
		for(int i: numList)
		{
			System.out.print(i+",");
		}
		
		System.out.println("\nEXTERNAL LOOP --------------- Iterative loop::::");
		ListIterator<Integer> iter = numList.listIterator();
		while(iter.hasNext())
		{
			System.out.println("The iter says : "+iter.next());
			if(iter.hasNext() && iter.next().compareTo(Integer.parseInt("44")) == 0)
			{
				iter.remove();
			}
		}
		
		System.out.println("\nINTERNAL LOOP------------- ForEachMethod -loop::::");
		numList.forEach(i -> System.out.print(i+",")); //lambda //Consumer Interface
		
		/* invoke a method which takes in Object type param, 
		 * which is having public modifier, which is static and it is from System class */
		System.out.println("\nPass a method as a reference...: "
				+ "Treat Methods as Higher level program members");
		numList.forEach(System::identityHashCode);
		
		System.out.println();
	}

}
