package com.learning.oop;

class Test implements Cloneable{
	
	@Override
	public Test clone() throws CloneNotSupportedException{
		return (Test)super.clone();
	}
}

public class ObjectDeclaration {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Test t1 = new Test();
		Test t2 = (Test)Class.forName("com.learning.oop.Test").newInstance();
		try {
			Test t3 = (Test)t1.clone();
		}
		catch(CloneNotSupportedException ex) {
			System.out.println("Clone not supported");
		}
		
		
		
		
	}

}
