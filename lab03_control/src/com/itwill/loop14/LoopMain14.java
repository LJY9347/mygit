package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

	public static void main(String[] args) {
		int blance = 0; // 은행 계좌의 잔고를 저장하기 위한 변수.
		boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
		Scanner sc = new Scanner(System.in); // 콘솔 입력을 위해서.

		while (run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료 ");
			System.out.println("-----------------------------");
			System.out.print("선택> ");

			int choice = sc.nextInt();

			if (choice == 1) {
				
				System.out.println("얼마 예금하시겠습니까?");
				int money = sc.nextInt();
				System.out.println("예금액>"+money);
				blance += money;
			}

			if (choice == 2) {
				System.out.println("얼마 출금하시겠습니까?");
				int submoney = sc.nextInt();
				System.out.println("출금액>"+submoney);
				blance -= submoney;
			}

			if (choice == 3) {
				System.out.println("잔고>" + blance);
			}

			if (choice == 4) {
				System.out.println("종료");
				break;
				//switch문 안의 break;는 switch 문을 종료한다.
			}
			
		}

	}

}
