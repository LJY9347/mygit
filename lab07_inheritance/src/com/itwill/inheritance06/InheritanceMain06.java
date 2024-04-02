package com.itwill.inheritance06;

public class InheritanceMain06 {

	public static void main(String[] args) {
		Point p1 = new Point();
		System.out.println(p1); // = p1.toString()
		
		//아규먼트를 갖는 생성자를 사용해서 Point 타입 객체 생성
		Point p2 = new Point(0,0);
		System.out.println(p2.toString());
		
		System.out.println(p1 == p2); // stack 의 주소값이 같은지 비교. 무조건 false
		// 객체의 동등비교에서는 비교 연산자(==, !=)를 사용하면 안됨. 비교 연산자는 기본타입 비교만.		
		System.out.println(p1.equals(p2)); 
		
	}

}
