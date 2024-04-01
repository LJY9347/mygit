package com.itwill.condition03;

import java.util.Scanner;

public class ConditionMain03 {

	public static void main(String[] args) {
		// Scanner 타입의 변수를 선언, 초기화.
		
		// 콘솔 창에서 Java 과목 점수(0~100 정수)를 입력받고 저장.
	
		// 콘솔 창에서 SQL 과목 점수를 입력받고 저장.
		
		// 콘솔 창에서 JavaScript 과목 점수를 입력받고 저장.
		
		// 세 과목의 총점(정수)을 계산하고 출력.
		// 세 과목의 평균(소수점까지 계산)을 계산하고 출력.
		
		// 세 과목 평균이 90점 이상이면, "A"
		// 세 과목 평균이 80점 이상이면, "B"
		// 세 과목 평균이 70점 이상이면, "C"
		// 세 과목 평균이 70점 미만이면, "F" 라고 출력.
		
		Scanner sc1 = new Scanner(System.in);
		int number = sc1.nextInt();
		System.out.println("Java 과목 점수 : " + number);
		int number1 = sc1.nextInt();
		System.out.println("SQL 과목 점수 : " + number1);
		int number2 = sc1.nextInt();
		System.out.println("JavaScript 과목 점수 : " + number2);
		System.out.println("---------------------------------");
		int result = number + number1 + number2 ; 
		System.out.println("세 과목의 총점 = " + (result));
		double result2 = (double) result / 3.0; 
		// double 다시 선언할 필요없이 (casting) 해주거나 / 정수를 실수(3.0)로 나눠주면됨.
		System.out.println("세 과목의 평균 = " + result2 );
		
		if ( result2 >= 90 ) {
			System.out.println("A");			
		} else if ( result2 >= 80 ) {
			System.out.println("B");
		} else if ( result2 >= 70 ) {
			System.out.println("C");
		} else {
			System.out.println("F");
		}
		
		

	}

}
