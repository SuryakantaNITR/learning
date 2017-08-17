package com.learning.oop;

public class LambdaExpressionsTwo {
	interface InterfaceOne {
		int function(int x, int y);
	}
	
	interface InterfaceTwo {
		String sayMessage(String message);
	}
	
	private int operate(int x, int y, InterfaceOne in){
		return in.function(x, y);
	}
	
	public static void main(String[] args) {
		InterfaceOne add = (int x, int y) ->  x+y;
		InterfaceOne mul = (int x, int y) ->  x*y;
		
		LambdaExpressionsTwo lt = new LambdaExpressionsTwo();
		lt.operate(3, 5, add);
		lt.operate(2, 10, mul);
		
		InterfaceTwo printLine = (String message) -> message;
		
	}

}
