package com.board;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

	String version = "v0";
	String title = "베짱이 카페" + version; 
	ArrayList<Post> posts = new ArrayList<Post>();
	int no = 0;
	
	public void run() {
		System.out.println(title);
		Scanner scanner = new Scanner(System.in);
		
		loop:			
			while(true) {
				System.out.println("[1.글 리스트 / 2.글 쓰기 / 3.글 읽기 / 4.글 삭제 / 5.글 수정 /6.프로그램 종료]");
				System.out.print("명령: ");
				String cmd = scanner.next();
				
					switch(cmd) {
						case "1":
							System.out.println("[글 리스트]");
							for(Post postList : posts) {
								postList.info();
							}
							System.out.println("[리스트 끝]");
						break;
						case "2":
							System.out.println("[글 쓰기]");
							scanner.nextLine();
							System.out.print("제목: ");
							String title = scanner.nextLine();
							
							System.out.print("내용: ");
							String content = scanner.nextLine();
							
							System.out.print("작성자: ");
							String writer = scanner.nextLine();
							
							no = no + 1;
							
							Post post = new Post(no, title, content, writer);
							posts.add(post);
							
							System.out.println("[글이 저장되었습니다.]");
						break;
						case "3":
							System.out.println("[글 번호를 입력해주세요.]");
							System.out.print("글 번호: ");
							String textNum = scanner.next();
							boolean readNum = false;
							
							for(Post postNum : posts) {
								if(Integer.toString(postNum.no).equals(textNum)) {
									postNum.textRead();
									readNum = true;
									break;
								}
							}
							if(!readNum) {
								System.out.println("해당 번호의 글이 없습니다.");
							}
						break;
						case "4":
							System.out.println("[삭제할 글 번호를 입력해주세요.]");
							System.out.print("글 번호: ");
							String textDeleteNum = scanner.next();
							boolean index = false;
							
							for(int i = 0; i < posts.size(); i = i++) {
								Post textIndex = posts.get(i);
								
								if(Integer.toString(textIndex.no).equals(textDeleteNum)) {
									posts.remove(i);
									index = true;
									break;
								}
							}
							
							if(index) {
								for(int i = 0; i < posts.size(); i++) {
									posts.get(i).no = i + 1;
								}
								no = posts.size();
								System.out.println("삭제가 완료되었습니다.");								
							}
							else {
								System.out.println("해당 번호의 글을 찾을 수 없습니다.");
								
							}
						break;
						case "5":
							System.out.println("[수정할 글 번호를 입력하세요]");
							System.out.print("글 번호: ");
							String textModifyNum = scanner.next();
							boolean modifyNum = false;
							
							for(Post postModify : posts) {
								if(Integer.toString(postModify.no).equals(textModifyNum)) {
									scanner.nextLine();
									System.out.println("[원래 내용]");
									System.out.println(postModify.content);
									System.out.println("[수정할 내용을 입력해주세요.]");
									System.out.print("내용: ");
									String newContent = scanner.nextLine();
									System.out.println("글이 수정되었습니다.");
									postModify.content = newContent;
									modifyNum = true;
									break;
								}
							}
							
							if(!modifyNum) {
								System.out.println("해당 번호의 글을 찾을 수 없습니다.");
							}
						break;
						case "6":
							System.out.println("[프로그램 종료]");
						break loop;
						default:
							System.out.println("잘못된 입력입니다");
						break;
					}
			}
	}
}
