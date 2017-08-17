package com.learning.theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class Student extends Object implements Comparable<Student>{
	public int rollNumber;
	public int marks;
	public String name;
	
	public int compareTo(Student s) {
//		return name.compareTo(s.name);
		return -(this.rollNumber - s.rollNumber);
	}
	
	public boolean equals(Object o) {
		Student s = (Student) o;
		return this.name.equals(s.name);
	}
}
public class CompareObjects {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		Random r = new Random();
		for(int i=0;i<10;i++) {
			Student s = new Student();
			s.rollNumber=i+1;
			s.marks=10*i + 1;
			s.name="Name"+r.nextInt(20);
			studentList.add(s);
		}
		Collections.sort(studentList);
		for(int i=0;i<10;i++) {
			Student s = studentList.get(i);
			System.out.println(s.rollNumber+" > "+s.marks+" > "+s.name);
		}
	}
}
