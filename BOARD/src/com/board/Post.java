package com.board;

public class Post {

	int no = 0;
	String title;
	String content;
	String writer;
	
	public Post(int no, String title, String content, String writer) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;	
	}
	
	
	public void info() {
		String textInfo = String.format("글 번호: %s 제목: %s 작성자: %s", no, title, writer);
		System.out.println(textInfo);
		
	}
	
	public void textRead() {
		String textInfo = String.format("글 번호: %s 제목: %s 작성자: %s", no, title, writer);
		System.out.println("[글을 불러왔습니다]");
		System.out.println(textInfo);
		System.out.println(content);
		System.out.println("[끝]");
	}
	
}
