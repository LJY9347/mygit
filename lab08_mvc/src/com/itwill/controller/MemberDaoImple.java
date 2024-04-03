package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스 -> 싱글턴으로 구현.
public class MemberDaoImple implements MemberDao {
	
	//----- singleton 구현
	private static MemberDaoImple instance = null;
	
	private MemberDaoImple () {}
	
	public static MemberDaoImple getInstance() {
		if (instance == null) {
			instance = new MemberDaoImple();
		}
		return instance;
	}
	//----- singleton 구현
	
	// 회원 정보를 저장할 배열 선언
	private Member[] members = new Member[MAX_LENGTH];
	
	// 회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
	private int count = 0; // 배열에 원소가 추가될 때마다 ++.
	
	@Override
	public int create(Member member) {
		members[count] = member;
		count++;
		
		return 1;
	}

	@Override
	public Member[] read() {
		
		return members;
	}

	@Override
	public Member read(int index) {
		
		return members[index];
	}

	@Override
	public int update(int index, String password) {
		members[index].setPassword(password);
		
		return 1;
	}

}
