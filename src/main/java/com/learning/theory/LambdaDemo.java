package com.learning.theory;

public class LambdaDemo {
	
	private interface MathOperation {
		int operation(int a, int b);
	}
	private int operate(int a, int b, MathOperation m) {
		return m.operation(a, b);
	}
	
	private interface GreetingsInterface {
		String append(String name);
	}
	
	private String appendString(String name, GreetingsInterface i) {
		return i.append(name);
	}
	
	public static void main(String[] args) {
		LambdaDemo l = new LambdaDemo();
		MathOperation addition = (a, b) -> a+b;
		MathOperation substraction = (a, b) -> {return a-b;};
		GreetingsInterface gi = (name) -> "Hello! "+name ;
		System.out.println(l.operate(2, 3, addition));
		System.out.println(l.operate(2, 4, substraction));
		System.out.println(l.appendString("Suryakanta", gi));
	}

}
