package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

	public static void main(String[] args) {
		Random rand = new Random();
		// 정수를 저장하는 HashSet을 선언, 초기화
		HashSet<Integer> numbers = new HashSet<Integer>();		
		// 집합(Set)에 [0, 10) 0이상 10미만 범위의 (서로 다른)난수 5개를 저장.
		while (numbers.size() < 5) {
			numbers.add(rand.nextInt(10));
		}
		
		// 향상된 for 문장을 사용해서 집합의 내용을 출력.
		for (Integer x : numbers) {
			System.out.println(x);
		}
	}

}
