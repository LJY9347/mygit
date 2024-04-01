package com.itwill.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		// 5 4 3 2 1
		for (int i = 5; i>0; i--) { 
			System.out.print(i);
			
			System.out.println(); // 줄바꿈												
		}
		
		// 0 2 4 6 8 10
		
		for (int n = 0; n <= 10; n += 2 ) { // n = n + 2
			System.out.print(n + " ");
		}
		System.out.println();
		
		for (int n = 0; n <= 5; n++) {
			System.out.print((n * 2));
		}
		System.out.println();
		
		for (int n = 0; n <= 10; n++) {
			if (n % 2 == 0) {
				System.out.println(n + " ");
			}
		
		// 10 8 6 4 2 0
			
		for (int x = 10; x >= 0; x -= 2) {
			System.out.println(x);
			
		}
			
			
		}
		System.out.println();
	}

}
