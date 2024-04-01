package com.itwill.loop12;

import java.util.Random;

public class LoopMain12 {

	public static void main(String[] args) {
		// 주사위 2개를 던졌을 때 결과를 (x, y) 형식으로 출력.
		// 주사위 2개의 눈의 합이 5가 되면 실행을 멈춤.
		Random dice = new Random();

		while (true) {
			int x = dice.nextInt(1,7);
			int y = dice.nextInt(1,7);
			System.out.println(x+","+y);
			if (x+y==5) {
				break;
			}
		}
		

		// 4x + 5y = 60 방정식을 만족하는 x와 y를 찾기
		// 단, x와 y는 10 이하의 자연수
		
		while (true) {
			int x = dice.nextInt(11);
			int y = dice.nextInt(11);
			if ((4*x)+(5*y)==60) {
				System.out.println("x = "+ x + " , y = " + y);
				break;
			}
			// for 사용해보기
		
			
		}
	}

}
