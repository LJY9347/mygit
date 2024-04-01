package com.itwill.switch01;

public class SwitchMain01 {

	public static void main(String[] args) {
		// switch-case 구문: 
		// switch에서 검사를 해서 해당 case 위치로 이동해서 break; 문장을 만날 때까지 실행.
		// 해당하는 case가 없으면 default 블록을 실행.
		// default 블록은 switch 구문에서 항상 가장 마지막에 작성.
		// default 블록은 없어도 됨.
		// switch (변수 또는 식)에서 사용할 수 있는 타입: 
		// (1) 정수: byte, short, int, long, char
		// (2) 문자열: String
		// (3) enum 타입
		// (주의) switch-case 구문에서는 실수(float,double), boolean 타입은 사용 불가!
		
		String season = "가을";
		switch (season) {
		case "봄": // 컨트롤+/ 현재 커서가 있는 문장에 주석생성.
			System.out.println("Spring");
			break; // break가 들어있는 코드 블록을 중지.
		case "여름": // :(콜론)은 라벨,포스트잇 개념 (실행문이 아님).
			System.out.println("Summer");
			break;
		case "가을":
			System.out.println("Fall");
			break;
		case "겨울":
			System.out.println("Winter");
			break;
		default: // 해당하는 케이스가 없음.
			System.out.println("몰라요~");
		}
		
		int number = 123;
		
		switch (number % 2) { // 계산문은 사용 가능하지만 조건식 ex) number % 2 == 0 은 사용불가.
		case 0:
			System.out.println("짝수");
			break;
		case 1:	//마지막 문장이기 때문에 break; 안적어도 됨 / case 1: 대신 default 적어도 됨.				
			System.out.println("홀수");
		}

	}

}
