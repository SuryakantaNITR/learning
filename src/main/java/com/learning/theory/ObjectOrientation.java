package com.learning.theory;

public class ObjectOrientation {
	public static void main(String[] args) {
		ObjectOrientation o1 = new ObjectOrientation();
		ObjectOrientation o2 = new ObjectOrientation();
		
		if(!o1.equals(o2))
			System.out.println("o1 is not equal to o2");
		if(o1 instanceof ObjectOrientation)
			System.out.println("o1 is Instance of ObjectOrientation");
		
		String s1="Hello";
		String s2=new String("Hello");
		
		System.out.println(System.identityHashCode(s1)+" "+System.identityHashCode(s2));
		
		
		if(s1.equals(s2))
			System.out.println("Strings are equal"+s1.hashCode()+" "+s2.hashCode());
		if(s1==s2)
			System.out.println("String objects are equal");
	}

}
