package com.itwill.jdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.itwill.jdbc.model.Blog;

import oracle.jdbc.OracleDriver;

import static com.itwill.jdbc.OracleJdbc.*; 
import static com.itwill.jdbc.model.Blog.Entity.*; // 컬럼 이름들

// MVC 아키텍쳐에서 Controller를 담당하는 클래스. DAO(Data Access Object)
// CRUD(Create, Read, Update, Delete) 기능 담당: insert, select, update, delete SQL
public class BlogDao {
	
	//----- singleton
	private static BlogDao instance = null;
	
	private BlogDao() {
		try {
			// Oracle 드라이버(라이브러리)를 등록. 드라이버는 한번만 호출되면 되기때문에 한번만 생성되는 싱글톤 생성자에 드라이버를 등록.
			DriverManager.registerDriver(new OracleDriver());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BlogDao getInstance() {
		if(instance == null) {
			instance = new BlogDao();
		}
		
		return instance;
	}	
	//----- singleton
	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제.
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 * @param rs ResultSet 객체
	 */

	private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * CRUD 메서드들에서 사용했던 리소스들을 해제.
	 * @param conn Connection 객체
	 * @param stmt Statement 객체
	 */
	private void closeResources(Connection conn, Statement stmt) {
		closeResources(conn, stmt, null);
	}
	
	// read() 메서드에서 사용할 SQL 문장: select * from blogs order by id desc
	private static final String SQL_SELECT_ALL = String.format(
			"select * from %s order by %s desc", 
			TBL_BLOGS, COL_ID);
	
	/**
	 * 데이터베이스 테이블 BLOGS 테이블에서 모든 레코드(행)를 검색해서 
	 * ID(고유키)의 내림차순으로 정렬된 리스트를 반환.
	 * 테이블에 행이 없는 경우 빈 리스트를 리턴.
	 * @return Blog를 원소로 갖는 ArrayList.
	 */
	
	public List<Blog> read(){
		List<Blog> result = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // 데이터베이스에 접속
			stmt = conn.prepareStatement(SQL_SELECT_ALL); // 실행할 SQL 문장을 갖고 있는 PreparedStatement 객체를 생성.
			rs = stmt.executeQuery(); // SQL 문장을 데이터베이스로 전송해서 실행.
			while(rs.next()) { // 결과 처리
				int id = rs.getInt(COL_ID);
				String title = rs.getString(COL_TITLE);
				String content = rs.getString(COL_CONTENT);
				String wfriter = rs.getString(COL_WRITER);
				LocalDateTime create = rs.getTimestamp(COL_CREATED_TIME).toLocalDateTime();
				LocalDateTime modifieTime = rs.getTimestamp(COL_MODIFIED_TIME).toLocalDateTime();
				
				Blog blog = new Blog(id, title, content, wfriter, create, modifieTime);
				result.add(blog);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
		
		return result;
	}
	
	// create (Blog blog) 메서드에서 사용할 SQL:
	// insert into blogs (title, content, writer) values (?, ?, ?)
	private static final String SQL_INSERT = String.format(
			"insert into %s (%s, %s, %s) values (?, ?, ?)",
			TBL_BLOGS, COL_TITLE, COL_CONTENT, COL_WRITER);
	
	/**
	 * 데이터베이스에 BLOGS 테이블에 행을 삽입.
	 * @param blog 테이블에 삽입할 제목, 내용, 작성자 정보를 가지고 있는 객체.
	 * @return 테이블에 삽입된 행의 개수.
	 */
	public int create (Blog blog) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD); // DB 접속
			stmt = conn.prepareStatement(SQL_INSERT); // Statement 객체 생성.
			stmt.setString(1, blog.getTitle()); // Statement의 첫번째 ? 채움.
			stmt.setString(2, blog.getContent()); //Statement의 두번째 ? 채움
			stmt.setString(3, blog.getWriter()); //Statement의 세번째 ? 채움
			result = stmt.executeUpdate(); // SQL 실행.
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	// delete(int id) 메서드에서 사용할 SQL: delete from blogs where id = ?
	private static final String SQL_DELETE = String.format(
			"delete from %s where %s = ?", 
			TBL_BLOGS, COL_ID);
	
	/**
	 * 테이블 BLOGS에서 고유키(PK) id에 해당하는 레코드(행)를 삭제.
	 * @param id 삭제하려는 레코드의 고유키.
	 * @return 테이블에서 삭제된 행의 개수.
	 */
	public int delete(int id) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, id);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt);
		}
		
		return result;
	}
	
	
}
