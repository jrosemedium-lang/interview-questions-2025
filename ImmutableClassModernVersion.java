package JavaCodingExamplePkg;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


final class MyImmutableClass {
	private final String myString;
	private final List<Integer> myIntegerList;
	private final Map<Integer, String> myMap;

	public MyImmutableClass(String myString, List<Integer> myIntegerList, Map<Integer, String> myMap) {
		super();
		this.myString = myString;
		this.myIntegerList = Collections.unmodifiableList(myIntegerList);
		this.myMap = Collections.unmodifiableMap(myMap);
	}

	public String getMyString() {
		return myString;
	}

	public List<Integer> getMyIntegerList() {
		return myIntegerList;
	}

	public Map<Integer, String> getMyMap() {
		return myMap;
	}
}

public class ImmutableClassModernVersion {
	public static void main(String[] args) {
		List<String> myList = Arrays.asList("A", "B", "C", "D");
		List<String> arrayList = new ArrayList<>();
		arrayList.addAll(myList);

		MyImmutableClass myImmutableClass = new MyImmutableClass("testString", List.of(1, 2, 3),
				Map.of(1, "k1", 2, "k2"));

		List<Integer> myListCopy = myImmutableClass.getMyIntegerList();
//		myListCopy.add(4);
//		myListCopy.set(0, 11);

		Map<Integer, String> myMap = myImmutableClass.getMyMap();
//		myMap.put(3, "k3");
//		myMap.remove(2);

		System.out.println(myMap);

		try {
			Field field = MyImmutableClass.class.getDeclaredField("myIntegerList");
			field.setAccessible(true); // Allows access to private field

			List<Integer> mutableList = new ArrayList<>(myImmutableClass.getMyIntegerList());
			mutableList.add(4);
			System.out.println(myImmutableClass.getMyIntegerList());
			field.set(myImmutableClass, mutableList);
			
			///////////////////////////////////////////////////////////
			
			Field field2 = MyImmutableClass.class.getDeclaredField("myMap");
			field2.setAccessible(true); // Allows access to private field
			
			Map<Integer, String> mutableMap = new HashMap<>(myImmutableClass.getMyMap());
			mutableMap.put(100,"century");
			System.out.println(myImmutableClass.getMyMap());
			field2.set(myImmutableClass, mutableMap);
			System.out.println(myImmutableClass.getMyMap());
			

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}
}
