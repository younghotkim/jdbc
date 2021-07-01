package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorSelectOneApp {

	public static void main(String[] args) {
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩

			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기

			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");
			
		    // 3. SQL문 준비 / 바인딩 / 실행
			
			String query ="";
			
			query += " select author_id, ";
			query += "        author_name, ";
			query += "        author_desc ";
			query += " from author";
			query += " where author_id = ? ";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 5);
			
			rs = pstmt.executeQuery();
			
		
		    
		    // 4.결과처리
			
				while(rs.next()) {
				
				int authorId = rs.getInt("author_id");
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				
				System.out.println(authorId + ", " + authorName + ", " + authorDesc);
				
			}

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}

		
		

	}

}
