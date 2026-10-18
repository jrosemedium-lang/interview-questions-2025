package JavaCodingExamplePkg;

final class ImmutableClass{
	private final String fruitname;

	public ImmutableClass(String fruitname) {
		super();
		this.fruitname = fruitname;
	}
	
	public String getFruitname() {
		return fruitname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fruitname == null) ? 0 : fruitname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImmutableClass other = (ImmutableClass) obj;
		if (fruitname == null) {
			if (other.fruitname != null)
				return false;
		} else if (!fruitname.equals(other.fruitname))
			return false;
		return true;
	}
	
}


public class ImmutableClient {
	public static void main(String[] args) {
		ImmutableClass immutableClass = new ImmutableClass("apple");
		
		//another instance...
		immutableClass = new ImmutableClass("banana");
		
		//cannot do anything without assignment and creating new operation
	}
}
