package com.itwill.mysql;

import com.itwill.database.Database;

public class MySqlDatabase implements Database {
	public static final int VERSION = 1;
	
	@Override
	public int select() { // public 지우면 범위가 좁아지기 때문에 컴파일 오류.
		System.out.println(">>> MySQL 테이블 검색");
		return 1;
	}
	
	@Override
	public int insert() {
		System.out.println(">>> MySQL 테이블 자료 추가");		
		return 1;
	}
}
