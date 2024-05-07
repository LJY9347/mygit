package com.itwill.myhome.controller;

import static com.itwill.login.OracleLogin.*;
import static com.itwill.myhome.model.MyHome.Entity.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itwill.myhome.model.MyHome;

import oracle.jdbc.OracleDriver;

public class MyHomeDao {
	
private static MyHomeDao instance = null;
    
    private MyHomeDao() {
        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static MyHomeDao getInstance() {
        if (instance == null) {
            instance = new MyHomeDao();
        }
        
        return instance;
    }
    private List<MyHome> myhome;

    private void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static final String SQL_INSERT = String.format(
    		"insert into %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", 
    		TBL_MyHOME, COL_ADDRESS, COL_WAY, COL_FEET, COL_ROOM_COUNT, 
    		COL_CONTENT, COL_OPTION1, COL_OPTION2, COL_OPTION3,COL_OPTION4,COL_OPTION5,COL_CITY,COL_BOROUGH);
    public int create(MyHome myhome) {
    	int result = 0;
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, myhome.getAddress());
			stmt.setString(2, myhome.getWay());
			stmt.setString(3, myhome.getFeet());
			stmt.setString(4, myhome.getRoom_count());
			stmt.setString(5, myhome.getContent());
			stmt.setBoolean(6, myhome.isOption1());
			stmt.setBoolean(7, myhome.isOption2());
			stmt.setBoolean(8, myhome.isOption3());
			stmt.setBoolean(9, myhome.isOption4());
			stmt.setBoolean(10, myhome.isOption5());
			stmt.setString(11, myhome.getCity());
			stmt.setString(12, myhome.getBorough());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, null);
		}  	
    	
    	return result;
    }
    
    private static final String SQL_SELECT_ALL = String.format(
    		"select * from %s", 
    		TBL_MyHOME);
    
    public List<MyHome> read(){
    	List<MyHome> result = new ArrayList<>();
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				MyHome myhome = makeMyHomeFromResultSet(rs);
				result.add(myhome);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}  	  	
    	return result;
    }
    private static final String SQL_SELECT_BY_ID = String.format(
            "select * from %s where %s = ?", 
            TBL_MyHOME, COL_ID);
    
    public MyHome read(int MyHomeId){
    	MyHome myhome = null;
    	
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, MyHomeId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				myhome = makeMyHomeFromResultSet(rs);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}  	  	
    	return myhome;
    }
    
    
    private MyHome makeMyHomeFromResultSet(ResultSet rs) throws SQLException{
    	int id = rs.getInt(COL_ID);
    	String address = rs.getString(COL_ADDRESS);
    	String way = rs.getString(COL_WAY);
    	String feet = rs.getString(COL_FEET);
    	String room_count = rs.getString(COL_ROOM_COUNT);
    	String content = rs.getString(COL_CONTENT);
    	boolean option1 = rs.getBoolean(COL_OPTION1);
    	boolean option2 = rs.getBoolean(COL_OPTION2);
    	boolean option3 = rs.getBoolean(COL_OPTION3);
    	boolean option4 = rs.getBoolean(COL_OPTION4);
    	boolean option5 = rs.getBoolean(COL_OPTION5);
    	String city = rs.getString(COL_CITY);
    	String borough = rs.getString(COL_BOROUGH);
    	
    	MyHome myhome = new MyHome(id, address, way, feet, room_count, content, option1, option2, option3, option4, option5, city, borough);
    	return myhome;
    }
    private static final String SQL_DELETE = String.format(
            "delete from %s where %s = ?", 
            TBL_MyHOME, COL_ID);
    
    public int delete (int id) {
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
			closeResources(conn, stmt, null);
		}  	
    	return result;
    }
    private static final String SQL_UPDATE = String.format(
            "update %s set %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ?, %s = ? where %s = ? ", 
            TBL_MyHOME, COL_ADDRESS, COL_WAY, COL_FEET, COL_ROOM_COUNT , COL_CONTENT, COL_OPTION1, COL_OPTION2, COL_OPTION3, COL_OPTION4, COL_OPTION5,
            COL_CITY, COL_BOROUGH, COL_ID);
    
    public int update(MyHome myhome,int id) {
    	int result = 0;
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, myhome.getAddress());
			stmt.setString(2, myhome.getWay());
			stmt.setString(3, myhome.getFeet());
			stmt.setString(4, myhome.getRoom_count());
			stmt.setString(5, myhome.getContent());
			stmt.setBoolean(6, myhome.isOption1());
			stmt.setBoolean(7, myhome.isOption2());
			stmt.setBoolean(8, myhome.isOption3());
			stmt.setBoolean(9, myhome.isOption4());
			stmt.setBoolean(10, myhome.isOption5());
			stmt.setString(11, myhome.getCity());
			stmt.setString(12, myhome.getBorough());
			stmt.setInt(13, id);
			result = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, null);
		}
	
    	return result;
    }
    
    private static final String SQL_SELECT_BY_CITY = String.format(
    	    "select * from %s where lower(%s) like ? or lower(%s) like ? or lower(%s) like ? ", 
    	    TBL_MyHOME,COL_ADDRESS ,COL_CITY, COL_BOROUGH);
    
    private static final String SQL_SELECT_BY_FEET = String.format(
    		"select * from %s where lower(%s) like ?", 
    		TBL_MyHOME,COL_FEET);

    public List<MyHome> search(int type, String keyword){
    	List<MyHome> result = new ArrayList<MyHome>();
    	
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	String searchKeyword = "%" + keyword.toLowerCase() + "%";
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			switch(type) {
			case 0:
				stmt = conn.prepareStatement(SQL_SELECT_BY_CITY);
				stmt.setString(1, searchKeyword);
				stmt.setString(2, searchKeyword);
				stmt.setString(3, searchKeyword);
				break;
			
			case 1:
				stmt = conn.prepareStatement(SQL_SELECT_BY_FEET);
				stmt.setString(1, searchKeyword);
				break;

			}
			rs = stmt.executeQuery();
			while (rs.next()) {
				MyHome myhome = makeMyHomeFromResultSet(rs);
				result.add(myhome);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
    	
    	
    	return result;
    }
    
    private static final String SQL_SELECT_CITY = "select distinct city from country";
    public List<String> getcities(){
    	List<String> cities = new ArrayList<>();
    	
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	
    	
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_CITY);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String city = rs.getString(COL_CITY);
				cities.add(city);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	finally {
			closeResources(conn, stmt, rs);
		}
    	return cities;
    }
    
    private static final String SQL_SELECT_BOROUGH = "select borough from country where city = ? order by borough";
    public List<String> getborough(String city){
    	List<String> borough = new ArrayList<String>();
    	Connection conn = null;
    	PreparedStatement stmt = null;
    	ResultSet rs = null;
    	try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(SQL_SELECT_BOROUGH);
			stmt.setString(1, city);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String boroughs = rs.getString(COL_BOROUGH);
				borough.add(boroughs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(conn, stmt, rs);
		}
    	
    	
    	
    	return borough;
    }
    
    
    
}
