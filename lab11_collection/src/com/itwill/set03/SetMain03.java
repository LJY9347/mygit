package com.itwill.set03;

import java.util.HashSet;

public class SetMain03 {

	public static void main(String[] args) {
		// Score 타입을 저장할 수 있는 HashSet을 선언, 초기화.
		HashSet<Score> scores = new HashSet<Score>();
		System.out.println(scores);
		
		// scores에 Score 객체들을 저장.
		scores.add(new Score()); // 기본 생성자로 객체 하나를 생성 후 저장.
		scores.add(new Score(0,0,0));
		scores.add(new Score(100, 50, 0));
		scores.add(new Score(50, 0, 100));
		
		System.out.println(scores);
		
	}

}
