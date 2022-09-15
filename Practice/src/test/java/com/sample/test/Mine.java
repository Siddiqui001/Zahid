package com.sample.test;

public class Mine {

	public static void main(String[] args) {
		
		int num = 12341234;
		int result = 0;
		int rem = 0;
		int actual = 0;

		while (num > 0) {
			rem = num % 10;
			result = (result * 10) + rem;
			actual = num / 10;
			num = actual;
		}
		System.out.println(result);
	}
}