package com.itwill.exception04;

/*
 * 예외 클래스들의 상속 관계:
 * Object
 *   |__ Throwable 
 *   		|__ Exception
 *   				|__ RuntimeException
 *   							|__ ArithmeticException, NumberFormatException, NullPointException, ...
 */

public class ExceptionMain04 {

	public static void main(String[] args) {
		// finally: 예외 상황 발생 여부와 상관 없이 항상 실행되는 블록.
		// try 또는 catch 블록에 return 문장이 있더라도,
		// 항상 finally 블록이 실행된 후에 return 문장이 실행됨!!
		// catch를 여러개 작성할 경우 먼저 작성하는 catch에서 상위타입 Exception을 먼저 작성할경우 컴파일에러.
		
		try {
			int x = 100;
			int y = 0;
			System.out.println("목 = " + (x / y));
			System.out.println("end try");
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("end catch");
			return; // main 메서드 종료.
		} finally {
			System.out.println("언제 출력될까요?"); // 18번줄 실행되기 전에 실행됨.
		}
		
		System.out.println("end main"); // 실행되지 않음
	}

}
