package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {
	public int inputInteger() {
		return Integer.parseInt(sc.nextLine());
	}

	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionMain03 app = new ExceptionMain03();

		while (true) {
			try {
				int x = app.inputInteger();
				System.out.println("x = " + x);
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}

		}
	}

}
