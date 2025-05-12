<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="db.DbUtill"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	String modifyNum = request.getParameter("num");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String id = request.getParameter("id");
	
	try {
		Connection con = DbUtill.getConnection();
		Statement st = con.createStatement();
		String sql = String.format("update betyani_board set title = '%s', content = '%s', id = '%s' where num = %s", title, content, id, modifyNum);
		System.out.println("전송하려는 sql: " + sql);
		int resultCount = st.executeUpdate(sql);
		if(resultCount == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}

	response.sendRedirect("list.jsp");
	
%>