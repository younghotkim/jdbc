package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class BookInsertApp {

	public static void main(String[] args) {
		
		
		// 0. import java.sql.*;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null; 셀렉트문에서 리턴값으로 사용
		//변수세팅
		
		//1. JDBC 드라이버 (Oracle) 로딩
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		//2. Connection 얻어오기
			
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");
			
			////////////여기까진 고정//////////////
			
		//3. SQL문 준비 / 바인딩 / 실행
			
			//쿼리문은 직접 작성
			
			String query= ""; //쿼리문 문자열로 만들기 --> ? 주의
			query += " insert into book ";
			query += " values(seq_book_id.nextVal, ?, ?, ?) "; //테이블명 앞뒤로 띄어주기
			
			pstmt = conn.prepareStatement(query); //쿼리문으로 만들기
			pstmt.setString(1, "영하"); //?(물음표) 중 1번째 --> 순서 중요
			pstmt.setString(2, "무야호"); //?(물음표) 중 2번째 --> 순서 중요
			pstmt.setString(3, "무야호");
			//바인딩문
			
			int count = pstmt.executeUpdate(); // 리턴값으로 성공여부 판단
			//실행문
			
			//INSERT INTO author VALUES(seq_author_id.NEXTVAL, '김영하', '알쓸신잡');
			
			
			//4.결과처리
			
			System.out.println(count + "건이 저장되었습니다.");
			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 -" + e);
			
		} catch (SQLException e) {
			System.out.println("eroor:" + e);
		} finally {
			
			
			//5.자원정리
			
			try {
				
				if (pstmt !=null) {
					
					pstmt.close();
					
				}
				
				if (conn !=null) {
					
					conn.close();
					
				}
						
			} catch (SQLException e) {
				System.out.println("error." + e);
			}
			
			
		}

		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
