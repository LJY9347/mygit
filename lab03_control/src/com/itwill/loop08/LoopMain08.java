package com.itwill.loop08;

public class LoopMain08 {

	public static void main(String[] args) {
		// while 반복문
		
		System.out.println("-----[1]-----");
		int n = 1;
		while (n<=5) { // 어떤 조건을 만족하는 동안에
			System.out.print(n + " ");
			n++; // n += 1; n = n + 1; 
		}
		System.out.println(n); // 여기서 n의 값은 6
		// int n = 1; 불가능
		n = 7; // 가능
		
		System.out.println("-----[2]-----");
		
		// 5 4 3 2 1 출력
		int x = 5;
		while (x>=1) {
			System.out.print(x + " ");
			x--;
		}
		System.out.println();
		
		System.out.println("-----[3]-----");
		
		// 1 3 5 7 9 출력
		int y = 1;
		while (y<=9) {
			System.out.print(y + " ");
			y += 2;
		}
		System.out.println();
		y = 1;
		while (y<=9) {
			if (y % 2 == 1) {
				System.out.print(y + " ");
			} y++;
		}
		System.out.println();
		System.out.println("-----[4]-----");
		
		// while문을 사용해서 구구단 9단을 출력.
		
		n = 1;
		while (n <= 9) {
			System.out.println("9x " + n + " =  " + (9*n));
			n += 1;
		}
		
		
	}

}
