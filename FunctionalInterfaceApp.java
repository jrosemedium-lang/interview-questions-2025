package JavaCodingExamplePkg;

@FunctionalInterface
interface Phone
{
	void call();
	default void message()
	{
		System.out.println("Message is sent");
	}
	
	default void photoShoot()
	{
		System.out.println("photo is clicked");
	}
	
	static void playGames()
	{
		System.out.println("play subway surf");
	}
	
	static void downloadGames()
	{
		System.out.println("download subway surf");
	}
}

class AndroidPhone implements Phone{

	@Override
	public void call() {
		System.out.println("Android phone call...");
	}
	
}

public class FunctionalInterfaceApp {

	public static void main(String[] args) {
		Phone.downloadGames();
		Phone.playGames();
		
		Phone p = new AndroidPhone();
		p.message();
		p.call();
		p.photoShoot();
	}

}
