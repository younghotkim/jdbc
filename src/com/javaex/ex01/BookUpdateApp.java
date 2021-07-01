package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookUpdateApp {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");
			
			
			
			String sql = "update book set title=?, pubs=?, pub_date=?"
					+ "where book_id=?";
			
			Scanner sc = new Scanner(System.in);
			
		
			System.out.print("수정할 책 번호입력> ");
			int no = sc.nextInt();

			System.out.print("수정할 책 제목> ");
			String title = sc.next();
			
			System.out.print("수정할 출판사명> ");
			String pub = sc.next();
			
			System.out.print("수정할 출판날짜> ");
			String pub_date = sc.next();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, pub);
			pstmt.setString(3, pub_date);
			pstmt.setInt(4, no);
		
			int count = pstmt.executeUpdate();
			
			sc.close();
			
		
			System.out.println(count + "건이 수정되었습니다.");
		
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
