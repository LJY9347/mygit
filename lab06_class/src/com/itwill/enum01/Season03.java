package com.itwill.enum01;

public enum Season03 {
	SPRING("봄"),
	SUMMER("여름"),
	FALL("가을"),
	WINTER("겨울");
	
	private String name;
	
	// enum의 생성자의 접근 수식어는 private만 사용 가능. private는 생량가능.
	private Season03 () {}
	private Season03 (String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
