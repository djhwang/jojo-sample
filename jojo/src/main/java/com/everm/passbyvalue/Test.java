package com.everm.passbyvalue;

public class Test {

	public void foo(Dog d) {
//		d = new Dog("Fifi");
		d.setName("Fifi");
	}
	
	public void test() {
		Dog a = new Dog("Max");
		foo(a);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}

	private class Dog {
		private String name;
		
		public Dog(String name) {
			this.name = name;
		}
		
		private void setName(String name) {
			this.name = name;
		}
	}
}
