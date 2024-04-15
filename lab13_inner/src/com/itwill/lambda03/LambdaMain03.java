package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Stream 클래스 & 메서드

		Random rand = new Random();

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			numbers.add(rand.nextInt(100));
		}
		System.out.println(numbers);

		// numbers의 원소들 중에서 짝수들만 선택(필터링)한 새로운 리스트를 만들고, 출력.
		ArrayList<Integer> even = new ArrayList<Integer>();
		for (Integer x : numbers) {
			if (x % 2 == 0) {
				even.add(x);
			}
		}
		System.out.println(even);

		List<Integer> evens = numbers.stream().filter((n) -> n % 2 == 0).toList();
		System.out.println(evens);

		// Stream을 사용해서, numbers의 원소들 중에서 홀수들만 선택한 리스트를 만들고 출력
		List<Integer> odds = numbers.stream().filter((x) -> x % 2 == 1).toList();
		System.out.println(odds); // filter의 리턴값은 boolean

		// Stream 사용해서, numbers의 원소들의 제곱을 저장하는 리스트를 만들고 출력
		List<Integer> squares = numbers.stream().map((x) -> x * x).toList();
		System.out.println(squares);
		// map은 우선 모든수가 통과된 후 원하는 return 값을 돌려줌.

		// Stream 사용해서, numbers의 원소들 중 홀수들의 제곱을 저장하는 리스트를 만들고 출력
		List<Integer> odds1 = numbers.stream().filter((x) -> x % 2 == 1).map((x) -> x * x).toList();
		System.out.println(odds1);
	}

}
