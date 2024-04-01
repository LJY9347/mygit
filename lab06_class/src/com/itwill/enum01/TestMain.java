package com.itwill.enum01;

public class TestMain {

	public static void main(String[] args) {
		int season = Season01.SPRING;
		switch (season) {
		case Season01.SPRING:
			System.out.println("봄");
			break;
		case Season01.SUMMER:
			System.out.println("여름");
			break;
		case Season01.FALL:
			System.out.println("가을");
			break;
		case Season01.WINTER:
			System.out.println("겨울");
			break;
		default:
			System.out.println("이상기후");
		}
		
		// Season2 season2 = new Season2 (); 생성자를 private로 바꿔서 불가능해짐.
		Season02 season2 = Season02.SPRING;
		if(season2 == Season02.SPRING) {
			System.out.println("봄");
		} else if(season2 == Season02.SUMMER) {
			System.out.println("여름");
		} else {
			System.out.println("...");
		}
		
		Season03 season03 = Season03.SPRING;
		System.out.println(season03);
		System.out.println(season03.getName());
		
	}

}
