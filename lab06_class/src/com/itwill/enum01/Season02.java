package com.itwill.enum01;

public class Season02 {
	
	public static final Season02 SPRING = new Season02("봄");
	public static final Season02 SUMMER = new Season02("여름");
	public static final Season02 FALL = new Season02("가을");
	public static final Season02 WINTER = new Season02("겨울");
	
	private String name;
	
	private Season02(String name) {
		this.name = name;
	}
	
	public String gerName() {
		return this.name;
	}
}
