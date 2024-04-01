package com.itwill.loop13;

public class LoopMain13 {

	public static void main(String[] args) {


		for (int x = 1; x < 5; x++) {
			for (int y = 0; y < x; y++) {
				System.out.print("*");
			}
			System.out.println();
		}


		for ( int x = 1; x <=4; x++) {
			for (int y = 4; y >= 1; y--) {
				if (y > x) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

	}
}
