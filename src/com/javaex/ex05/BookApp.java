package com.javaex.ex05;

import java.util.List;

import com.javaex.ex04.AuthorVo;

public class BookApp {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		List<BookVo> bookList;
		
		//리스트출력     0x777
		//DB에서 데이터 가져오기
		bookList = bookDao.getBookList();
		//리스트를 for문으로 출력 --> 메소드로 정의
		printList(bookList);
		
		
		//작가등록
		BookVo iBookVo = new BookVo(0, "김영하", "대치동", "강남구", 0, "영하", null);
		int iCount = bookDao.bookInsert(iBookVo);
		if(iCount>0) {
			System.out.println("[등록되었습니다.]");
		}else {
			System.out.println("[관리자에게 문의하세요(" + iCount + ")]");
		}
		
		
		//리스트출력     0x777
		//DB에서 데이터 가져오기
		bookList = bookDao.getBookList();
		//리스트를 for문으로 출력 --> 메소드로 정의
		printList(bookList);
		
		
		
		
		//작가수정  iCount 사용은 생략했음
		BookVo uBookVo = new BookVo(3, "영하킴", "강남구대치동", null, iCount, null, null);
		int uCount = bookDao.bookUpdate(uBookVo);
		
		//리스출력
		//DB에서 가져오기
		bookList = bookDao.getBookList();
		//리스트를 for문으로 출력 --> 메소드로 정의
		printList(bookList);
		
	
		
			
		//작가삭제
		
		int dCount = bookDao.bookDelete(7);
		
		//리스출력
		//DB에서 가져오기
		bookList = bookDao.getBookList();
		//리스트를 for문으로 출력 --> 메소드로 정의
		printList(bookList);
		
		
		/*
		/*
		//작가 1명의 정보
		??? = authorDao.getAuthorOne(3);
		*/

	}
	
	
	//리스트 출력 메소드
	public static void printList(List<BookVo> bookList) {
		
		for(int i=0; i<bookList.size(); i++) {
			
			
			BookVo bookVo = bookList.get(i);
			System.out.println(bookVo.getBookId() + "," + bookVo.getTitle() + "," + bookVo.getPubs() + "," + bookVo.getPubDate());
			
			/*
			AuthorVo authorVo = authorList.get(i);
			
			int authorId = authorVo.getAuthorId();
			String authorName = authorVo.getAuthorName();
			String authorDesc = authorVo.getAuthorDesc();
			
			System.out.println(authorId + "\t" + authorName + "\t\t" + authorDesc);
			*/
			
			
			/*
			int authorId = authorList.get(i).getAuthorId();
			String authorName = authorList.get(i).getAuthorName();
			String authorDesc = authorList.get(i).getAuthorDesc();
			
			System.out.println(authorId + "\t" + authorName + "\t\t" + authorDesc);
			*/
		}
		
		System.out.println("=================================");
		System.out.println("");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
