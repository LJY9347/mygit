package com.itwill.condotion07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교/논리 연산자 연습
		
		// 난수(random number)를 생성할 수 있는 타입의 변수를 선언, 초기화.
		Random rand = new Random();
		
		// rand.nextInt(x): 0이상 x보다 작은 정수 난수를 반환.
		// rand.nextInt(x,y): x이상 y 미만의 정수 난수를 반환.
		
		int java = rand.nextInt(101); // 0이상 101 미만의 정수 난수를 저장.		   
		System.out.println("java: " + java);
		
		int sql = rand.nextInt(101);
		System.out.println("sql: " + sql);
		
		int javascript = rand.nextInt(101);
		System.out.println("javascript: " + javascript);
		
		// 세 과목이 모두 40점 이상이고, 평균이 60점 이상이면 "합격",
		// 그렇지 않으면 "불합격"을 출력.
		
		int result = (java + sql + javascript) / 3;
	    String total = (java >= 40 && sql >=40 && javascript>=40 && result >=60) ? "합격" : "불합격" ;
	    System.out.println(total);
		
		
		}

}
