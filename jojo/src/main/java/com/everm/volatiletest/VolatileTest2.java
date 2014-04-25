package com.everm.volatiletest;

public class VolatileTest2 implements Runnable {

	private volatile long longValue;

	public void run() {
		for (int i = 0; i < 1000000; i++) {
			add(i);
		}
	}

	public synchronized void add(int i) {
		longValue += i;
	}


	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		VolatileTest2 test = new VolatileTest2();
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
