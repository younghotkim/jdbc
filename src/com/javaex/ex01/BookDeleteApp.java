package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BookDeleteApp {

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
		    
			String query="";
			query +=" delete from book ";
			query +=" where book_id = ? ";
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("삭제할 책 번호입력> ");
			
			int no = sc.nextInt();
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, no);
					
			int count = pstmt.executeUpdate();
			
			if(count>0) {
			System.out.println(count + "건이 삭제되었습니다.");
			} else {
				System.out.println("삭제에 실패했습니다.");
			}
			
			
			
			
			
			
		    // 4.결과처리
			
		sc.close();

			
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
