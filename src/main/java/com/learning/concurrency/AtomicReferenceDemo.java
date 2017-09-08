package com.learning.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo<T> {
	
	AtomicReference<T> atomicReference;
	
	public AtomicReferenceDemo(T initial) {
		if(initial != null)
			atomicReference = new AtomicReference<>(initial);
		else
			atomicReference = new AtomicReference<>();
	}
	
	public boolean compareAndSwap(T initialVal, T finalVal) {
		return atomicReference.compareAndSet(initialVal, finalVal);
	}
	
	public static void main(String[] args) {
		AtomicReferenceDemo<String> a = new AtomicReferenceDemo<String>("init");
		String newVal = "final";
		
		System.out.println(a.compareAndSwap("init", newVal));
		System.out.println(a.compareAndSwap("init", newVal));
	}

}
