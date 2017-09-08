package com.learning.questions;

import java.util.ArrayList;

public class RotateMatrix {
	
	public static void rotate(ArrayList<ArrayList<Integer>> a) {
		int l = a.size();
		
		for(int i=l-1;i>=0;i--) {
			for(int j=0;j<l;j++) {
				a.get(j).add(a.get(i).get(0));
				a.get(i).remove(0);
			}
		}
	}
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(1);
		row.add(2);
		row.add(3);
		row.add(4);
		a.add(row);
		
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(5);
		row1.add(6);
		row1.add(7);
		row1.add(8);
		a.add(row1);
		
		ArrayList<Integer> row2 = new ArrayList<Integer>();
		row2.add(9);
		row2.add(10);
		row2.add(11);
		row2.add(12);
		a.add(row2);
		
		ArrayList<Integer> row3 = new ArrayList<Integer>();
		row3.add(13);
		row3.add(14);
		row3.add(15);
		row3.add(16);
		a.add(row3);
		
		
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.size();j++)
				System.out.print(a.get(i).get(j) + " ");
			
			System.out.println(" ");
		}
		
		
		System.out.println("\n After rotating..");
		
		rotate(a);
		
		for(int i=0;i<a.size();i++) {
			for(int j=0;j<a.size();j++)
				System.out.print(a.get(i).get(j) + " ");
			
			System.out.println(" ");
		}
	}

}
