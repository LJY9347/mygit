package com.itwill.list01;

import java.util.ArrayList;

public class ListMain01 {

	public static void main(String[] args) {
		// 정수들을 저장하는 ArrayList를 생성.
		ArrayList<Integer> numbers = new ArrayList<>(); // new ArrayList<Integer>();
		// -> 생성자 호출에서는 ArrayList의 원소 타입을 생략할 수 있음.

		// ArrayList에 저장된 원소 개수
		System.out.println("size = " + numbers.size());
		System.out.println(numbers);

		// ArrayList에 정수들을 저장.
		numbers.add(100);
		numbers.add(1); // add 순서에 따라 index 0부터 저장됨.
		numbers.add(-100);
		System.out.println("size = " + numbers.size());

		// ArrayList에 저장된 원소(값) 가져오기
		System.out.println("[1] " + numbers.get(1));
		System.out.println("[2] " + numbers.get(2));

		// 반복문
		for (int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + ", ");
		}
		System.out.println();

		for (Integer x : numbers) {
			System.out.print(x + ", ");
		}
		System.out.println();
		
		System.out.println(numbers); // toString()
		
		// ArrayList의 원소 삭제
		numbers.remove(1); // remove(int index): 해당 인덱스의 원소 삭제.
		System.out.println(numbers);
		
		numbers.remove(Integer.valueOf(-100)); // remove(Object x): 같은 값을 갖는 원소를 찾아서 삭제.
		System.out.println(numbers);
		
	}

}
