package com.learning.ds;

import java.util.Arrays;

public class SegmentTree {
	int[] st;
	
	public SegmentTree(int[] arr, int n) {
		int height = (int) Math.ceil(Math.log(n)/Math.log(2));
		
		int sizeSt = 2*(int)Math.pow(2, height)-1;
		st=new int[sizeSt];
		
		segmentTreeUtil(arr, 0, n-1, 0);
		
	}
	public int segmentTreeUtil(int[] arr, int ss, int se, int si) {
		if(ss==se){
			st[si]=arr[ss];
			return arr[ss];
		}
		int mid = (ss+se)/2;
		st[si] = segmentTreeUtil(arr, ss, mid, (si*2)+1)+
				segmentTreeUtil(arr, mid+1, se, (si*2)+2);
		return st[si];
	}
	
	public int sumUtil(int ss, int se, int qs, int qe, int si) {
		if(ss>qe || se<qs)
			return 0;
		if(qs<=ss && qe>=se)
			return st[si];
		int mid = (ss+se)/2;
		return sumUtil(ss, mid, qs, qe, (si*2)+1)+sumUtil(mid+1, se, qs, qe, (si*2)+2);
	}
	
	public int sum(int n, int qs, int qe) {
		return sumUtil(0, n-1, qs, qe, 0);
	}
	public static void main(String[] args) {
		int[] arr = new int[] {1, 3, 5, 7, 9, 11};
		SegmentTree segmentTree = new SegmentTree(arr, arr.length);
		System.out.println(Arrays.toString(segmentTree.st));
		
		System.out.println(segmentTree.sum(arr.length, 1, 3));
	}
}
