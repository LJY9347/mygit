package com.itwill.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		// 반복문
		System.out.println("Java 1");
		System.out.println("Java 2");
		System.out.println("Java 3");
		System.out.println("Java 4");
		System.out.println("Java 5");
		
		System.out.println("------------------");
		
		for (int i = 1; i <=10; i++) { // 초기화; 조건식; 변경(증감)
			System.out.println("Java " + i); // 여기서의 i는 for문 안에서만 사용가능한 지역변수.
		}
		int i = 1;
		// 지역 변수(local variable): 메서드 안에서 선언한 변수.
		// 지역 변수의 사용 범위: 
		// *지역 변수는 선언된 순간부터 변수가 포함된 블록(중괄호 안쪽{}) 안에서만 사용 가능.
		// for 문장의 초기식에서 선언된 (지역)변수는 for 블록 안에서만 사용 가능! 
		
		// 증가/감소 연산자: ++(1 증가), --(1 감소)
		// 증가/감소 연산자는 변수 이름 앞 또는 뒤에서 사용 가능: i++, ++i (의미는 조금 다름)
		int x = 1;
		int y = x++ + 1; // 덧셈(+)을 먼저 계산한 후 x 값을 1 증가시킴.
		// y = x + 1; x++;
		System.out.println("x = " + x + ", y = " + y);
		
		x = 1;
		y = ++x + 1; // x 값을 먼저 1 증가시킨 후 덧셈(+)을 수행.
		// x++; y = x + 1;
		System.out.println("x = " + x + ", y = " + y);
		
		
	}

}
