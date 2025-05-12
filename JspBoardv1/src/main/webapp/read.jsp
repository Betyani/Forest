<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="db.DbUtill"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 읽기</title>
</head>
<body>
<%@include file = "index.jsp" %>

<%
		String readNum = request.getParameter("num");
	
	try {
		Connection con = DbUtill.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from betyani_board where num =" + readNum);
		rs.next();
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");
		
%>
	제목:<%= title %><br>
	작성자:<%= id %><br>
	내용:<%= content %><br>
	
<% 	
	} catch (Exception e) {
		e.printStackTrace();
	}
%>
	
	<a href = "delete.jsp?num=<%= readNum %>">[삭제]</a> 
	<a href = "modify.jsp?num=<%= readNum %>">[수정]</a> 
	<br>
	<form action = "list.jsp" method = "get">
	 <input type = "submit" value = "이전 페이지">
	</form>
	
	
</body>
</html>