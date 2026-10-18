package JavaCodingExamplePkg;

interface Shape{
	public void draw();
}

class SquareShape implements Shape{

	@Override
	public void draw() {
		System.out.println("Square Shape");
	}
	
}
class CircleShape implements Shape {
	@Override
	public void draw() {
		System.out.println("CircleShape");
	}
}

class ShapeFactory {
	public static Shape drawShape(String type) {
		if("Circle".equals(type)) {
			return new CircleShape();
		} else if("Square".equals(type)) {
			return new SquareShape();
		} else {
			throw new IllegalArgumentException();
		}
	}
}
public class FactoryPatternExample {
	public static void main(String[] args) {
		Shape myShape = ShapeFactory.drawShape("alddlkj");
		myShape.draw();
	}
}
