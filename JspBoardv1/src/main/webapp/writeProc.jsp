<%@page import="java.sql.Statement"%>
<%@page import="db.DbUtill"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	
	
	
	try {
		Connection con = DbUtill.getConnection();
		Statement st = con.createStatement();
		String sql = String.format("insert into betyani_board (title, content, id) values ('%s', '%s', '%s')", title, content, id);
		
		System.out.println("전송하려는 sql: " + sql);
		int resultCount = st.executeUpdate(sql);
		if(resultCount == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
			
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	response.sendRedirect("list.jsp");
	
	
%>
