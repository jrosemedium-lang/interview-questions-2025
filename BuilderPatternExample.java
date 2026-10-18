package JavaCodingExamplePkg;


class MyBuilderPattern {
	private final String myName; // Mark the fields as final;
	private final Integer age;
	
	public String getMyName() {
		return myName;
	}

	public Integer getAge() {
		return age;
	}
	
	//for the constructor of our class, pass an static inner class instance
	//use the private fields of static inner class directly to assign values
	public MyBuilderPattern(MyInnerBuilder myInnerBuilderInstance) { 
		this.myName = myInnerBuilderInstance.myName;
		this.age = myInnerBuilderInstance.age;
	}
	
	//create a static inner class
	static class MyInnerBuilder {
		private String myName; //save its private fields
		private Integer age;
		
		public MyBuilderPattern build() {
			return new MyBuilderPattern(this);
		}//static inner class must call the constructor of main class and pass it's "this" instances
		
		public MyInnerBuilder setMyName(String myName) {
			this.myName = myName;
			return this;//setter for each field must return the "this" instance
		}
		public MyInnerBuilder setAge(Integer age) {
			this.age = age;
			return this;//setter for each field must return the "this" instance
		}
	}

	@Override // have a toString
	public String toString() {
		return "myBuilderPattern [myName=" + myName + ", age=" + age + "]";
	}

}
public class BuilderPatternExample {
	public static void main(String[] args) {
		MyBuilderPattern myBuilderPattern = new MyBuilderPattern.MyInnerBuilder()
				.setAge(10)
				.setMyName("Alphapha")
				.build();

		System.out.println(myBuilderPattern);
	}
}
