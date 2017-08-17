package com.learning.oop;

interface AnonymousDemo {
	int x=21;
	public void demo();
	
}
interface Age
{
    int x = 21;
    void getAge();
}
public class AnonymousClass {
	int b;
	public static void main(String[] args) {
		final int a =10;
		Age oj1 = new Age() {
			static final int b=10;
            
			@Override
            public void getAge() {
                 // printing  age
                System.out.print("Age is "+x);
                
                //can access member of the enclosing class
                AnonymousClass ac = new AnonymousClass();
                ac.b=10;
                
                // can refer to a local final variable as variable "a" stays in heap even if scope goes out of main method
                
                
                // shadows local variable "a" 
                System.out.println(a);
            }
        };
        oj1.getAge();
	}
}
