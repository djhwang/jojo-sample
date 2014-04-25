package com.everm.volatiletest;

import java.util.concurrent.atomic.AtomicLong;

public class VolatileTest3 implements Runnable {

	private AtomicLong longValue = new AtomicLong(0);


	public void run() {
		for (int i = 0; i < 1000000; i++) {
			add(i);
		}
	}

	public void add(int i) {
		longValue.addAndGet(i);
	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		VolatileTest3 test = new VolatileTest3();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(test.longValue);
		System.out.println((System.currentTimeMillis() - start) + "ms");
	}


}
