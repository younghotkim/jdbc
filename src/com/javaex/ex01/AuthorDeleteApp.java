package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AuthorDeleteApp {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");
			
			
			
			String sql = "delete from author where author_id=?";
			
			Scanner sc = new Scanner(System.in);
			
		
			System.out.print("삭제할 작가 번호입력> ");
			
			int no = sc.nextInt();

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
		
			int count = pstmt.executeUpdate();
			
			sc.close();
			
		
			System.out.println(count + "건이 삭제되었습니다.");
		
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
