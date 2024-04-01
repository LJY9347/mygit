package com.itwill.class07;

public class ThisTest {
	// field
	int x;
	int y;
	int z;
	int g;
	String name;
	// constructor
	public ThisTest() {}
	
	public ThisTest(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		//-> this: ThisTest 타입으로 생성된 객체(인스턴스)
	}
	
	public ThisTest(int g) {
		//this.x = x;
		this();// -> this(); ThisTest 클래스의 다른 생성자 호출 // 컨트롤 클릭
		this.g =  g;
		// (주의) this(...) 다른 생성자를 호출하는 코드는 다른 실행문들보다 가장먼저 실행되어야 함.
	}
	
	public ThisTest(int g, int x) {
		this(); // 현재 클래스의 다른 생성자를 호출하는 문장.
		
	}
	public ThisTest(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	public void info() {
		System.out.printf("x=%d, y=%d, z=%d\n" , x, y, z);
		System.out.println(g);
	}
	
	
	
}
