package com.learning.theory;


class Shape {
	public void getShape() {
		System.out.println("In Shape factory");
	}
}

class Rectangle extends Shape {
	public void rectangleShape() {
		System.out.println("In rectangle Shape");
	}
}

class Circle extends Shape {
	public void circleShape() {
		System.out.println("In circle Shape");
	}
}

public class IsARelation {
	public static void testShape(Shape s) {
		s.getShape();
	}
	public static void main(String[] args) {
		Circle c = new Circle();
		Rectangle r = new Rectangle();
		testShape(c);
		testShape(r);
		c.circleShape();
		
	}

}
