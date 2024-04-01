package com.itwill.inheritance02;

public class InheritanceMain02 {

	public static void main(String[] args) {
		// BusinessPerson 타입 객체 생성:
		BusinessPerson person1 = new BusinessPerson(); // sub클래스 객체가 생성되기 전에 super클래스 생성자가 먼저 생성.
		System.out.println(person1.getName() + " : " + person1.getCompany());
		
		BusinessPerson person2 = new BusinessPerson("아이티윌");
		System.out.println(person2.getName() + " : " + person2.getCompany());
		
		BusinessPerson person3 = new BusinessPerson("오쌤","아이티윌");
		System.out.println(person3.getName() + " : " + person3.getCompany());
		
	}

}
