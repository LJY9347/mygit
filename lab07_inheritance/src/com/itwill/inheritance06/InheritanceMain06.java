package com.itwill.inheritance06;

public class InheritanceMain06 {

	public static void main(String[] args) {
		Point p1 = new Point();
		System.out.println(p1); // = p1.toString()
		
		//아규먼트를 갖는 생성자를 사용해서 Point 타입 객체 생성
		Point p2 = new Point(0,0);
		System.out.println(p2.toString());
		
		System.out.println("비교 연산자 == 결과: " + (p1 == p2)); // stack 의 주소값이 같은지 비교.
		// 생성자를 통해 생성된 객체들은 항상 주소값이 다르기때문에 결과는 false
		// 객체의 동등비교에서는 비교 연산자(==, !=)를 사용하면 안됨. 비교 연산자는 기본타입 비교만.		
		System.out.println("equals() 메서드 결과: " + p1.equals(p2)); 
		
		System.out.println("p1 hashCode = " + p1.hashCode());
		System.out.println("p2 hashCode = " + p2.hashCode());
		
		// String 객체의 동등(equals) 비교
		String s1 = new String ("hello");
		String s2 = new String ("hello");
		System.out.println("s1 == s2 결과: " + (s1 == s2)); // 주소 비교
		System.out.println("s1.equals(s2) 결과: " + s1.equals(s2)); 
		
		
	}

}
