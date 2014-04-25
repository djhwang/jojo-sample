package com.everm.volatiletest;

public class VolatileTest1 implements Runnable {

	private static long[] longArray = {0x000000A00000000Dl, 0x0000000B000000C0l};

	private long longValue;


	@Override
	public void run() {
		int i = 0;
		int length = longArray.length;

		while (true) {
			longValue = longArray[i % length];
			i = (i < length) ? i + 1 : 0;

			checkValue(longValue);

		}

	}

	private void checkValue(long l) {
		for (int i = 0; i < longArray.length; i++) {
			if (l == longArray[i]) {
				return;
			}
		}
		System.out.println("값이 다릅니다. " + Long.toHexString(l));
		System.exit(-1);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VolatileTest1 test = new VolatileTest1();
		Thread t1 = new Thread(test);
		Thread t2 = new Thread(test);
		t1.start();
		t2.start();
	}

}
