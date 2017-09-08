package com.learning.concurrency;

import java.util.concurrent.atomic.AtomicBoolean;

public class CompareAndSwap {

	private AtomicBoolean isLocked = new AtomicBoolean(false);
	
	public boolean lock() {
		return isLocked.compareAndSet(false, true);
	}
}
