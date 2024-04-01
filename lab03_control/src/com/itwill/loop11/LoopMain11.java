package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력
		int x = 1;
		int sum = 0;
		while (x < 11) {	
			 sum += x;			
			x++;			
		}
		System.out.println(" sum "+ " = " + sum);
		// Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력
		int y = 1;
		int sum1 = 0;
		while (y < 101) {
			if(y % 2 == 0) {
				sum1 += y;
			}
			y++;
		}
		System.out.println(" sum "+ " = " + sum1);
		
		// Ex3. 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력
		
		int z = 1;
		int sum2 = 0;
		while (z < 100) {
			sum2 += z;
			z += 2;
		}
		System.out.println(" sum "+ " = " + sum2);
	}

}
