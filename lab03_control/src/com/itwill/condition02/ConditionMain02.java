package com.itwill.condition02; //패키지 선언문

import java.util.Scanner; // import 문장 - 패키지 선언문과 클래스 선언문 사이
						  // 기본 타입이 아닌 변수를 사용할때

public class ConditionMain02 {

	public static void main(String[] args)  {
		// 콘솔 창에서 키보드 입력을 저장하는 방법:
		// (1) Scanner 타입의 변수를 선언하고, Scanner 객체를 저장.
		Scanner sc = new Scanner(System.in); // 입력 도구(System.in)를 만들어서 변수에 저장.
		
		// 콘솔 창에서 정수 1개를 입력받고, int 타입 변수에 저장
		System.out.println("정수 입력>>> ");
		int number = sc.nextInt(); // 콘솔에서 입력받은(sc.nextInt) 정수를 변수에 저장.
		
		System.out.println("number = " + number);
		
		// 만약 입력받은 정수가 0보다 크면, "positive"라고 출력.
		// 0이면, "zero"라고 출력.
		// 그렇지 않으면, "negative"라고 출력.
		
		if (number > 0) {
			System.out.println("positive");
		}
		else if (number == 0) {
			System.out.println("zero");
		}
		else {
			System.out.println("negative");
		}
					
	}

}
