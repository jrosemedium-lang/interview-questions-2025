package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DellL1InterviewQuestion {
	public static void main(String[] args) {
		 List<String> names = Arrays.asList(
	                "aaryanna",
	                "aayanna",
	                "airianna",
	                "alassandra",
	                "allanna",
	                "allannah",
	                "allessandra",
	                "allianna",
	                "allyanna",
	                "anastaisa",
	                "anastashia",
	                "anastasia",
	                "annabella",
	                "annabelle",
	                "annebelle"
	        );
	        
	        names.stream()
	                .filter(str -> str.startsWith("aa"))
	                .map(str -> Mapper.getDistinctCharactersCount(str).apply(str))
	                .forEach(str -> {
	                	System.out.println(str);
	                });
		
	 }
}
class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;
    
    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }
    
    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}
class Mapper {
	static Function<String, CharactersCount> getDistinctCharactersCount(String str) {
	 Function <String, CharactersCount> resultFunction = (test) -> {
		 LinkedHashMap<Character, Integer> countMap = test.chars().mapToObj(ch ->(char) ch).collect(Collectors.toMap(
					key -> key,
					value -> 1,
					Integer::sum,
					LinkedHashMap::new
					));
		 Integer count = (int) countMap.entrySet().stream().filter((eachEntry) -> eachEntry.getValue() == 1).count();
		 return new CharactersCount(test, count);
	 };
	 return resultFunction;
	}
}