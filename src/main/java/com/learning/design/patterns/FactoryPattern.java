package com.learning.design.patterns;

enum ShapeType {
	CIRCLE, SQUARE
}

interface Shape {
	public String getShape();
}

class Circle implements Shape {

	@Override
	public String getShape() {
		return "Circle Shape";
	}
	
}

class Square implements Shape {

	@Override
	public String getShape() {
		return "Square Shape";
	}
	
}

class ShapeFactory {
	public Shape getShapeFromFactory(ShapeType type) {
		if(type.equals(ShapeType.CIRCLE))
			return new Circle();
		else
			return new Square();
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape shape = factory.getShapeFromFactory(ShapeType.SQUARE);
		System.out.println(shape.getShape());
	}
}
