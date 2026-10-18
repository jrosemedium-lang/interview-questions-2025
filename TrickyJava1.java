package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.Map.Entry;

public class TrickyJava1 {
	public static void main(String[] args) {
		 StringBuilder key1=new StringBuilder("K1");
		    StringBuilder key2=new StringBuilder("K2");
		    
		    Map<StringBuilder, String> map = new HashMap<>();
		    map.put(key1, "Hello");
		    map.put(key2, "World");
		    
		    System.out.println(map);
		    key1.append("00");
		    System.out.println(map);
		    
		    System.out.println("--------------");
		    String key11 = "Kstr1";
		    String key22 = "Kstr2";
		    Map<String, String> mapStr = new HashMap<>();
		    mapStr.put(key11, "Hello");
		    mapStr.put(key22, "World");
		   
		    System.out.println(mapStr);
		    key11 = "abc";
		    System.out.println(mapStr);
		    
//		    List<String> myList = Arrays.asList("123","234"); 
//		    Collection<String> unModList = Collections.unmodifiableCollection(myList);
//		    
//		    myList.add(key22);
		    
		    
		       List<String> myList3 =  new java.util.ArrayList<String>();//Arrays.asList("123","234"); 
			   Collection<String> unModList3 = Collections.unmodifiableCollection(myList3);
			   
			   myList3.add("123");
			   System.out.println(myList3);
			   System.out.println(unModList3); // not throwing exception

			   
			   try {
				   List<String> myList2 =  Arrays.asList("123","234"); 
				   Collection<String> unModList2 = Collections.unmodifiableCollection(myList2);
				   
				   myList2.add("123");
				   System.out.println(myList2);
				   System.out.println(unModList2);
			   } catch(UnsupportedOperationException e) {
				   System.out.println("UnsupportedOperationException occured as Arrays.asList gives a fixed size collection");
			   }
			   
			   System.out.println("--------------");
			   
			   HashMap<Integer,String> myMap = new HashMap<>();
			   myMap.put(1, "one");
			   Iterator<Map.Entry<Integer,String>> myIterator = myMap.entrySet().iterator();
			   while(myIterator.hasNext()) {
				   Entry myEntry = myIterator.next();
				   System.out.println(myEntry.getKey() + "--" + myEntry.getValue());
			   }
		    
			   System.out.println("--------------");
			   HashMap<Integer, String> myGCTestMap = new HashMap<Integer, String> ();
			   Integer nullKey =null;
			   myGCTestMap.put(nullKey, "nullStr");
			   
			   WeakHashMap<Integer, String> myGCTestMap2 = new WeakHashMap<Integer, String> ();
			   nullKey =null;
			   myGCTestMap2.put(nullKey, "nullStr");
			   
			   System.out.println(myGCTestMap.size());
			   System.out.println(myGCTestMap2.size());
			   System.gc();
			   System.out.println(myGCTestMap.size());
			   System.out.println(myGCTestMap2.size());
	}
}
