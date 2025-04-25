package com.betyani;

public class Display {

	static private String TITLE_BAR = "🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧🐧";
	static private String TITLE = "🐧🐧🐧🐧🐧🐧🐧🐧🐧   게시판   🐧🐧🐧🐧🐧🐧🐧🐧🐧";

	static private String BAR = "========================================";
	static private String MAIN_MENU = "[1.리스트][2.쓰기][3.읽기][4.수정][5.삭제][6.종료]";
	
	public static void titleRun() {
		System.out.println(TITLE_BAR);
		System.out.println(TITLE);
		System.out.println(TITLE_BAR);
		
	}
	
	public static void mainMenuRun() {
		System.out.println(BAR);
		System.out.println(MAIN_MENU);
		System.out.println(BAR);
		
		
	}
	
	public static void barRun() {
		System.out.println(BAR);
		
	}
	
	
	
	
	
}
