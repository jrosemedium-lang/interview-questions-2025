package JavaCodingExamplePkg;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class StreamUniqueEmailDomain {
	public static void main(String[] args) {
		List<String> emails = Arrays.asList(
			    "John@gmail.com",
			    "alice@GMAIL.com",
			    "John@gmail.com",
			    "bob@yahoo.com",
			    "Bob@YAHOO.com",
			    "carol@Gmail.COM"
			);
		
		//{gmail.com=3, yahoo.com=2}
		
		
		//open a stream
		//convert it to string buffer
		//you have every list item as string
		//reverse it
		//substring by @ 
		//part before @ will be normalized key, but reverse it again and add it as key
		//part after @ will be name as is, but reverse it again and add it as value
		//all into a map but name will be given a counter function as downstream collector
		
		System.out.println(
		emails.stream()
					.map(str -> new StringBuffer(str).reverse())
					.collect(Collectors.groupingBy(
								eachEntryK ->  new StringBuffer(new StringBuffer(eachEntryK).reverse().substring(new StringBuffer(eachEntryK).reverse().indexOf("@")+1)).toString().toLowerCase(),
								Collectors.mapping(
										eachEntryV -> new StringBuffer(new StringBuffer(eachEntryV).reverse().substring(0,new StringBuffer(eachEntryV).reverse().indexOf("@"))).toString(),
										Collectors.toSet()
										)
								))
							);
		System.out.println("--------");
		
		Map<String, Set<String>>	 setifiedMap =  emails.stream()
							.map(str -> new StringBuffer(str).reverse())
							.collect(Collectors.groupingBy(
										eachEntryK ->  new StringBuffer(new StringBuffer(eachEntryK).reverse().substring(new StringBuffer(eachEntryK).reverse().indexOf("@")+1)).toString().toLowerCase(),
										Collectors.mapping(
												eachEntryV -> new StringBuffer(new StringBuffer(eachEntryV).reverse().substring(0,new StringBuffer(eachEntryV).reverse().indexOf("@"))).toString(),
												Collectors.toSet()
												)
										));
		
		
		System.out.println(
				setifiedMap.entrySet().stream().collect(
						Collectors.toMap(
								Map.Entry::getKey,
								entry -> (long)entry.getValue().size()
								)
						)
				);
		
		
		System.out.println("--------");
//					.forEach(str -> {
//						System.out.println(str.getClass());
//					});
		
		
//		String sample = "carol@Gmail.COM";
//		StringBuffer strBuffer = new StringBuffer(sample);
//		strBuffer.reverse();
//		System.out.println(strBuffer);
//		String key = (strBuffer.substring(0,strBuffer.indexOf("@")));
//		String value = strBuffer.substring(strBuffer.indexOf("@")+1);
//		System.out.println(key);
//		System.out.println(value);
//		String actualKey = new StringBuffer(key).reverse().toString().toLowerCase();
//		String actualValue = new StringBuffer(value).reverse().toString();
//		System.out.println(actualKey);
//		System.out.println(actualValue);
		
		
		String sample = "carol@Gmail.COM";
		String key = new StringBuffer(new StringBuffer(sample).reverse().substring(0,new StringBuffer(sample).reverse().indexOf("@"))).reverse().toString().toLowerCase();
		System.out.println(key);
		String value = new StringBuffer(new StringBuffer(sample).reverse().substring(new StringBuffer(sample).reverse().indexOf("@")+1)).reverse().toString();
		System.out.println(value);
		
		
		
		System.out.println("--------Older attempts----------");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
		
		//{gmail.com=3, yahoo.com=2}
		
		
		System.out.println( "This---SPLIT WAY WRONG WAY------ "+
		emails.stream().map(eachEmail -> eachEmail.split("@"))
									 .flatMap(splitArray -> Arrays.stream(splitArray))
									 .filter(eachEntry -> eachEntry.contains("com"))
									 .collect(Collectors.groupingBy(
											 String::toLowerCase,
											 Collectors.counting()
											 ))
		);
		
		List<String> eachDomain = emails.stream().map(eachEmail -> eachEmail.split("@"))
									 .flatMap(splitArray -> Arrays.stream(splitArray))
									 .filter(eachEntry -> eachEntry.contains("com"))
									 .map(str -> str.toLowerCase())
									 .distinct()
									 .collect(Collectors.toList());
		
		System.out.println("eachDomain===" +eachDomain);
		
		
		System.out.println("-Tragedy---");
		System.out.println(
				emails.stream()
				.filter(eachEntry ->
				eachEntry.regionMatches(
						true,
						eachEntry.length() - "@gmail.com".length(),
						"@gmail.com",
						0,
						"@gmail.com".length()
						)
						)
				.collect(Collectors.toMap(
						eachEntry -> eachEntry.substring(0, eachEntry.indexOf("@")),
						eachEntry -> 1L,
						Long::sum
						))
				);
		
		
		System.out.println(
				emails.stream()
				.filter(eachEntry -> 
							eachEntry.regionMatches	(true, eachEntry.length()-"@yahoo.com".length(), "@yahoo.com", 0, "@yahoo.com".length())
						).count()
						);
		
		
		;
		LinkedHashMap<String, Long> domainData = new LinkedHashMap<>();
		eachDomain.stream().forEach(domain -> {
			domainData.put(domain, sillyDomainCounter(emails, domain));
		});
		System.out.println(domainData);
	}
	
	public static long sillyDomainCounter(List<String> emails, String currentDomain) {
		return
				emails.stream()
				.filter(eachEntry -> 
							eachEntry.regionMatches	(true, eachEntry.length()- currentDomain.length(), currentDomain, 0, currentDomain.length())
						).count();
	}
}


/*
 * 
 * 
 * 
 * 
 * The actual fix — two-stage pattern:

	groupingBy(domainClassifier, mapping(localPartExtractor, Collectors.toSet())) 
	— groups by domain, and for each domain collects local parts into a Set
	 (which auto-deduplicates). You had used this mapping() downstream collector
	  before (per your own admission, "last week") but had fully forgotten it 
	  — needed a completely separate example (city/country grouping) before 
	  the pattern re-clicked.
	
	
	
	Map<String, Set<String>> → 
	Map<String, Long> via entrySet().stream()
		.collect(Collectors.toMap(
		Map.Entry::getKey, entry -> (long) entry.getValue().size())) 
	— a map-to-map transform pattern: same keys, reshaped values. 
	You correctly identified, once hinted, 
	that this is "apply a stream over the result of part one" 
	— confirmed with a plain "yes."
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
