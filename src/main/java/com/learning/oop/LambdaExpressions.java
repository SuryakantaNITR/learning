package com.learning.oop;

import java.util.ArrayList;
import java.util.List;

interface LambdaInterface {
	public void abstractMethod(int x);
	
	default void NonAbstractMethod() {
		System.out.println("Non abstract method");
	}
}
public class LambdaExpressions {
	public static void main(String[] args) {
		
		// lambda expression to implement above
        // functional interface. This interface
        // by default implements abstractMethod()
		LambdaInterface li = (int x)->System.out.println(3*x);
		li.abstractMethod(5);
		
		li.NonAbstractMethod();
		
		List<Integer> list = new ArrayList<Integer>(); 
		list.add(3);
		list.add(2);
		list.add(4);
		
//		list.forEach(n -> System.out.println(n));
		list.forEach(n -> {
			if(n%2 == 0 ) {
				System.out.println(n);
			}
			});
	}

}
