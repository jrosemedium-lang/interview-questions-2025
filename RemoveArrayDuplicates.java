package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


//This is wrong coz, we don't want intValue, seems like streams won't autoboxing
//also intValue is not a static method
//Why? because while trying to do mapToObj, internal input is an int, 
//Example int aNum; So think like this, can you invoke aNum.intValue? Answer is NO.
//however you can still pass aNum to a Integer Constructor as in new Integer(aNum)
//Or else go for a legendary method boxed()
public class RemoveArrayDuplicates {
	public static void main(String[] args) {
		int myArray[] = {11,22,33,44,44,55,66,77,77,77,11};
		
		List<Object> myCleanArray = IntStream.range(0, myArray.length)
											.map(i -> myArray[i])
											.distinct()
											.mapToObj(Integer::toString)
											.collect(Collectors.toList());
		
		System.out.println(myCleanArray);
		
		int myNum = 19; 
		Integer myNewInt = new Integer(myNum);//Valid but Deprecated from java9 onwards 
		myNewInt.toString(myNum); // is valid but deprecated.
		
		myCleanArray = Arrays.stream(myArray)
				.distinct()
				.mapToObj(Integer::toString)
				.collect(Collectors.toList());

		System.out.println(myCleanArray);
		
		
//		.mapToObj(Integer::intValue) // not possible
		Integer million = 20;
		int myIntMillion = million.intValue();
		int million2 = 10;
//		million2.intValue(); // not possible


		int aNum = 10; new Integer(aNum);
		myCleanArray = Arrays.stream(myArray)
									.distinct()
									.mapToObj(Integer::new) //Valid but deprecated
									.collect(Collectors.toList());
		
		
		System.out.println(myCleanArray);

		List<Integer> myCleanIntArray = 
				Arrays.stream(myArray)
							.distinct()
							.boxed()//To auto-box it directly, it will take your int and box it automatically into an Integer
							.collect(Collectors.toList());//Happily take it into list then :)

		System.out.println(myCleanIntArray);
		
		myCleanIntArray = Arrays.stream(myArray)
													 .distinct()
													 .mapToObj(Integer::valueOf)// You can use valueOf as it is taking the input of an int, and it is an instance method, as in int aNum is acceptable;
													 .collect(Collectors.toList());
		
		int bNum = 20; 
		new Integer(bNum).valueOf(bNum); //happily valid, though deprecated
		
		System.out.println(myCleanIntArray);
		
	}
}
