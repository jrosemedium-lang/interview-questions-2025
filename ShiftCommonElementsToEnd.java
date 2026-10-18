package JavaCodingExamplePkg;
import java.util.*;
import java.util.stream.Collectors;
public class ShiftCommonElementsToEnd {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 5, 0, 3, 0 };

		System.out.println(
				Arrays.stream(arr).boxed()
							.collect(Collectors.toMap(key -> key, value -> 1, Integer::sum, LinkedHashMap::new))
		);

		LinkedHashMap<Integer, Integer> myUniqueInteger = Arrays.stream(arr).boxed()
				.collect(Collectors.toMap(key -> key, value -> 1, Integer::sum, LinkedHashMap::new));

		LinkedHashMap<Integer, Integer> myDuplicateMap = new LinkedHashMap<Integer, Integer>();
		myUniqueInteger.entrySet().stream().filter(eachEntry -> eachEntry.getValue() > 1).forEach((eachEntry) -> {
			myDuplicateMap.put(eachEntry.getKey(), eachEntry.getValue());
		});
		
		System.out.println(myDuplicateMap);
		
		LinkedHashMap<Integer, Integer> myAnswerMap = new LinkedHashMap<Integer, Integer>();
		
		myDuplicateMap.keySet().stream().forEach((dupKey) -> {
			myUniqueInteger.remove(dupKey);
		});
		
		System.out.println(myUniqueInteger);
		
		ArrayList<Integer> myArrayList = new ArrayList();
		myArrayList.addAll(myUniqueInteger.keySet());
		
		myDuplicateMap.entrySet().stream().forEach((eachEntry)->{
			Integer key =  eachEntry.getKey();
			Integer value = eachEntry.getValue();
			
			while(value>0) {
				myArrayList.add(key);
				value--;
			}
		});
		
		System.out.println(myArrayList);
	}
}
