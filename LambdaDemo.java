package JavaCodingExamplePkg;

interface LambdaInterface{
	public void show();
}

interface LamdaParameterized{
	public void showInt(int i);
}

class LambdaInterfaceImpl implements LambdaInterface{
	@Override
	public void show() {
		System.out.println("Pinky pink pinks when pinched...");
	}
}

public class LambdaDemo {
	public static void main(String[] args) {
		LambdaInterface lambdaInterface;
		
		System.out.println("Traditional approach when using interface implementation...");
		lambdaInterface = new LambdaInterfaceImpl();
		lambdaInterface.show();
		
		System.out.println("\nAnnonymous Inner Class approach for interface implementation...");
		lambdaInterface = new LambdaInterface() {
			@Override
			public void show() {
				System.out.println("The Annonymous inner class is implemented...");
			}
		};
		lambdaInterface.show();
		
		System.out.println("\nLambda 8 interface implementation...");
		lambdaInterface = () -> {
			System.out.println("Lambda 8 expression is implemented...");
		};
		lambdaInterface.show();
		
		System.out.println("\nOne Liner Lambda 8 interface implementation...");
		lambdaInterface = () -> System.out.println("Lambda 8 One Liner is implemented...");
		lambdaInterface.show();
		
		
		System.out.println("\nUsing java 8 interface with parameterized method and lambda expression...");
		LamdaParameterized paramMethodImpl = (int i) -> System.out.println("ok with params: "+i);
		paramMethodImpl.showInt(8);
		
		
		System.out.println("\nRemove type, Using java 8 interface with parameterized method and lambda expression...");
		LamdaParameterized paramMethodImpl2 = (i) -> System.out.println("ok with params: "+i);
		paramMethodImpl2.showInt(7);
		
		System.out.println("\nRemove brackets, Using java 8 interface with parameterized method and lambda expression...");
		LamdaParameterized paramMethodImpl3 = i -> System.out.println("ok with params: "+i);
		paramMethodImpl3.showInt(6);
		
	}
}
