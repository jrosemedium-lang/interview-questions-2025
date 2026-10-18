package JavaCodingExamplePkg;

interface Checkbox{
	void render();
}
interface Button{
	void click();
}

class WindowsButton implements Button{

	@Override
	public void click() {
		System.out.println("WindowsButton");
	}
	
}

class MacButton implements Button{

	@Override
	public void click() {
		System.out.println("MacButton");
	}
	
}

class WindowsCheckbox implements Checkbox{

	@Override
	public void render() {
		System.out.println("WindowsCheckbox");	
	}
	
}

class MacCheckbox implements Checkbox{

	@Override
	public void render() {
		System.out.println("MacCheckbox");
	}
}

interface GUIFactory{
	Checkbox createCheckbox();
	Button createButton();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}


class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void renderUI() {
        button.click();
        checkbox.render();
    }
}

public class NoisyAbstractFactoryPattern {
	public static void main(String[] args) {
		 GUIFactory factory;

	        String os = "Windows";  // could come from config

	        if (os.equals("Windows")) {
	            factory = new WindowsFactory();
	        } else {
	            factory = new MacFactory();
	        }

	        Application app = new Application(factory);
	        app.renderUI();
	} 
}
