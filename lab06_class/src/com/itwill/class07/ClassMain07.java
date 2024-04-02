package com.itwill.class07;

public class ClassMain07 {

	public static void main(String[] args) {
		//ThisTest 객체를 여러가지 생성자들을 이용해서 생성
		
		ThisTest test5 = new ThisTest(4, 5, 6);
		test5.info();
		ThisTest test1 = new ThisTest(4, 8);
		test1.info();
	}

}
