package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionMain03 app = new ExceptionMain03();

		int x = app.inputInteger2();
		System.out.println("x = " + x);
	}
	
	public int inputInteger2 () {
		try {
			System.out.print("정수 입력> ");
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("정수로 입력하세요...");
			return inputInteger2(); // 재귀호출 - 자기자신을 다시한번 호출함.
		}
	}
	
	public int inputInteger() {
		int result = 0;

		while (true) {
			try {
				System.out.print("정수 입력> ");
				result = Integer.parseInt(sc.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("정수를 입력하세요.");
			}
		}
		return result;

	}
}
