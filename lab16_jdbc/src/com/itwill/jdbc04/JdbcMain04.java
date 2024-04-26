package com.itwill.jdbc04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*;

public class JdbcMain04 {

	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new OracleDriver());
		
		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		final String sql = "delete from blogs where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.setInt(1, 2);
		
		int result = stmt.executeUpdate();
		
		System.out.println(result + "개 행이 삭제되었습니다.");
		
		stmt.close();
		conn.close();
		
	}

}
