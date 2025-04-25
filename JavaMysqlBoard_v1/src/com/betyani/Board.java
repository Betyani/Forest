package com.betyani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Board {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	Scanner sc = new Scanner(System.in);
	
	void run() {
		Display.titleRun();
		
		dbInit();
		
		loop:
		while(true) {
			Display.mainMenuRun();;
			System.out.println("메뉴를 선택해주세요: ");
			String menu = sc.next();
			
			switch(menu) {
			 	case "1":
			 		Display.barRun();
			 		System.out.println("[글 리스트]");
			 		Display.barRun();
			 		dbExecuteQueryList();
			 		Display.barRun();
			 		dbPostCount();
			 	break;
			 	case "2":
			 		Display.barRun();
			 		System.out.println("[글 쓰기]");
			 		Display.barRun();
			 		sc.nextLine();
			 		System.out.println("제목: ");
			 		String title = sc.nextLine();
			 		
			 		System.out.println("내용: ");
			 		String text = sc.nextLine();
			 		
			 		System.out.println("작성자: ");
			 		String id = sc.nextLine();
			 		
			 		String content = String.format("insert into board (b_title, b_text, b_id, b_datetime, b_hit) values ('%s', '%s', '%s', now(), 0)", title, text, id);
			 		Display.barRun();
			 		
			 		dbExecuteUpdateWrite(content);
			 		
			 	break;
			 	case "3":
			 		while(true) {
			 			Display.barRun();
			 			System.out.println("글 번호를 입력해주세요: ");
			 			String textNo = sc.next();
			 			Display.barRun();
			 			
			 			boolean readNum = dbExecuteQueryRead(textNo);
			 			
			 			if(readNum) {
			 				break;
			 			}
			 			else {
			 				System.out.println("해당 번호의 글이 존재하지 않습니다.");
			 				
			 			}
			 		}
			 	break;
			 	case "4":
			 		while(true) {
			 			Display.barRun();
			 			System.out.println("수정할 글 번호를 입력하세요: ");
			 			String textNo = sc.next();
			 			Display.barRun();
			 			boolean modifyNum = dbExecuteQueryContent(textNo); 
			 			Display.barRun();
			 			
			 			if(modifyNum) {
			 				sc.nextLine();
			 				int no = Integer.parseInt(textNo);
			 				System.out.println("수정할 내용을 입력해주세요: ");
			 				String modifyText = sc.nextLine();
			 				String modifyContent = String.format("update board set b_text = '%s' where b_no = %d", modifyText, no);
			 				Display.barRun();
			 				dbExecuteUpdateModify(modifyContent);
			 				break;
			 			}
			 			else {
			 				System.out.println("해당 번호의 글이 존재하지 않습니다.");
			 				
			 			}
			 		
			 		}
			 	break;
			 	case "5":
					while(true) {
						Display.barRun();
						System.out.println("삭제할 글 번호를 입력해주세요: ");
						String textNo = sc.next();
						Display.barRun();
						boolean deleteNum = dbExecuteUpdateDelete(textNo);
						
						if(deleteNum) {
			 				break;
			 			}
			 			else {
			 				System.out.println("해당 번호의 글이 존재하지 않습니다.");
			 				
			 			}
					}
			 	break;
			 	case "6":
			 		System.out.println("프로그램이 종료됩니다");
					 
			 	break loop;
			 	default:
			 	System.out.println("잘못된 입력입니다");	
			
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	//DB 연결
	private void dbInit() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_cat", "root", "root");
			st = con.createStatement();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//리스트 불러오기
	private void dbExecuteQueryList() {
		try {
			rs = st.executeQuery("select * from board");
			
			while(rs.next()) {
				int no =rs.getInt("b_no");
				String title = rs.getString("b_title");
				String id = rs.getString("b_id");
				String datetime = rs.getString("b_datetime");
				int hit = rs.getInt("b_hit");
				System.out.printf("%d. 제목: %s | 작성자: %s | 시간: %s | 조회수: %d\n", no, title, id, datetime, hit);
				
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//글 작성
	private void dbExecuteUpdateWrite(String query) {
		try {
			int success = st.executeUpdate(query);
		
		
			if(success == 1) {
				
				System.out.println("작성이 완료되었습니다.");
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//글 읽기
	private boolean dbExecuteQueryRead(String textNo) {
		try {
			int no = Integer.parseInt(textNo);
			
			rs = st.executeQuery("select * from board where b_no = " + no);
			
			if(rs.next()) {
				int bno =rs.getInt("b_no");
				String title = rs.getString("b_title");
				String id = rs.getString("b_id");
				String datetime = rs.getString("b_datetime");
				int hit = rs.getInt("b_hit");
				String text = rs.getString("b_text");
				System.out.printf("%d. 제목: %s | 작성자: %s | 시간: %s | 조회수: %d\n내용: %s\n", bno, title, id, datetime, hit, text);
				return true;
			}
			else {
				return false;
			}
		
		}
		catch(NumberFormatException nfe) {
			System.out.println("⚠️ 숫자만 입력하세요");
			return false;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//입력한 번호가 숫자인지 확인 후 원래 내용 불러오기
	private boolean dbExecuteQueryContent(String textNo) {
		try {
			int no = Integer.parseInt(textNo);
			
			rs = st.executeQuery("select * from board where b_no = " + no);
			
			if(rs.next()) {
				String text = rs.getString("b_text");
				System.out.println("원글:\n" + text);
				return true;
			}
			else {
				return false;
			}
		
		}
		catch(NumberFormatException nfe) {
			System.out.println("⚠️ 숫자만 입력하세요");
			return false;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	//글 수정
		private void dbExecuteUpdateModify(String query) {
		try {
			int success = st.executeUpdate(query);
		
		
			if(success == 1) {
				System.out.println("수정이 완료되었습니다.");
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	
	//입력한 번호가 숫자인지 확인 후 삭제
		private boolean dbExecuteUpdateDelete(String textNo) {
			try {
				int no = Integer.parseInt(textNo);
				String delete = String.format("delete from board where b_no = %d", no);
				int success = st.executeUpdate(delete);
				
				if(success == 1) {
					System.out.println("삭제되었습니다");
					return true;
				}
				else {
					return false;
				}
			
			}
			catch(NumberFormatException nfe) {
				System.out.println("⚠️ 숫자만 입력하세요");
				return false;
			}
			
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		
		}
		
		private void dbPostCount() {	
			try {
				rs = st.executeQuery("select count(*) from board");
				rs.next();
				String count = rs.getString("count(*)");
				System.out.println("글 수:"+count);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	
	
	
	
	
}
