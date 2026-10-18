package JavaCodingExamplePkg;


interface TestInterface
{
    // abstract method
    public void square(int a);
  
    // default method
    default void show()
    {
      System.out.println("Default Method Executed");
    }
    static void showstatic()
    {
      System.out.println("static Method Executed TestInterface");
    }
}

interface TestInterfaceDuplicate
{
    // abstract method
    public void square(int a);
  
    // default method
    default void show()
    {
      System.out.println("Default Method Executed");
    }
    static void showstatic()
    {
      System.out.println("static Method Executed TestInterfaceDuplicate");
    }
}
  
class TestClass implements TestInterface, TestInterfaceDuplicate
{
    // implementation of square abstract method
    public void square(int a)
    {
        System.out.println(a*a);
    }

    // implementation of show method
    public void show()
    {
      System.out.println("Default Method Overrided in Implementation Interface");
    }
    
    static void showstatic()
    {
      System.out.println("static Method Executed TestClass showstatic");
    }
}

public class DefaultInterfaceExample {
	public static void main(String[] args) {
		TestClass d = new TestClass();
		d.square(4);

		// default method executed
		d.show();
		TestInterface.showstatic();
	}
}
