package com.itwill.class04;

public class Rectangle {
	// field
	double width; // 직사각형의 가로 길이
	double height; // 직사각형의 세로 길이
	
	// 생성자
	// (1) 기본 생성자
	public Rectangle () {
		
	}
	// (2) 가로/세로를 아규먼트로 전달받아서 초기화하는 생성자
	public Rectangle (double width, double height) {
		this.width = width;
		this.height = height;
	}
	// 메서드
	// (1) 넓이를 리턴
	// (2) 둘레길이를 리턴
	public double area () { //가로와 세로값이 초기화 된 후 호출되기 때문에 파라미터가 필요하지 않음.
		return width*height;
	}
	public double perimeter () {
		return (width + height) * 2;
	}
	
}
