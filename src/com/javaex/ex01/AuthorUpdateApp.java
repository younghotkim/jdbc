package com.javaex.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AuthorUpdateApp {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
			conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "webdb", "webdb");
			
			
			
			String sql = "update author set author_name=?, author_desc=?"
					+ "where author_id=?";
			
			Scanner sc = new Scanner(System.in);
			
		
			System.out.print("수정할 작가 번호입력> ");
			int no = sc.nextInt();

			System.out.print("수정할 작가 이름> ");
			String name = sc.next();
			
			System.out.print("수정할 작가 설명> ");
			String add = sc.next();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, add);
			pstmt.setInt(3, no);
		
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
