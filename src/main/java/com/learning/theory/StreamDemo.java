package com.learning.theory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StudentDemo {
	private String name;
	
	public StudentDemo(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
public class StreamDemo {
	
	public static void main(String[] args) {
		List<StudentDemo> studentList = new ArrayList<>();
		studentList.add(new StudentDemo("Avishek"));
		studentList.add(new StudentDemo("Nibo"));
		studentList.add(new StudentDemo("Vivek"));
		studentList.add(new StudentDemo("Amitabh"));
		studentList.add(new StudentDemo("Suryakanta"));
		studentList.add(new StudentDemo("Amul"));
		
		List<String> nameList = studentList
				.stream()
				.map(StudentDemo::getName)
				.filter(n->n.startsWith("A"))
//				.limit(1)
				.collect(Collectors.toList());
		System.out.println(nameList);
		
	}
	
}
