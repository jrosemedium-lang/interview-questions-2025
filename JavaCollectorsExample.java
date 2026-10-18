package JavaCodingExamplePkg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person{
	private String firstName;
	private String lastName;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}

public class JavaCollectorsExample {
	public static void main(String[] args) {
		ArrayList<Integer>  numList = new ArrayList<>();
		numList.add(100);
		numList.add(99);
		numList.add(98);
		numList.add(97);
		numList.add(96);
		numList.add(95);
		
		numList.sort(Comparator.naturalOrder());
		
		System.out.println(numList.toString());
		
		
		List <Person> personList = new ArrayList<Person>();
		personList.add(new Person("DDDD",""));
	}
}
