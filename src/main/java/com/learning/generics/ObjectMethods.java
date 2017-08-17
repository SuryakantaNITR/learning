package com.learning.generics;

public class ObjectMethods {
	
	public String toString() {
		return "String: "+this.getClass()+":"+this.hashCode();
	}
	public static void main(String[] args) {
		ObjectMethods om = new ObjectMethods();
		System.out.println(om.toString());
		
		try {om.finalize();}
		catch(Throwable t) {};
	}

}
