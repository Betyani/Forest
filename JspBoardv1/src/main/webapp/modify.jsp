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
<title>게시판 - 수정</title>
<script src ="function.js"></script>
</head>
<body>
<%@include file = "index.jsp" %>

<%
		String modifyNum = request.getParameter("num");
	
	try {
		Connection con = DbUtill.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from betyani_board where num =" + modifyNum);
		rs.next();
		String title = rs.getString("title");
		String content = rs.getString("content");
		String id = rs.getString("id");
		
%>
	<form name = "form" action = "modifyProc.jsp" method = "post" onsubmit="return validateForm()">
		<input name = "num" type = "hidden" value = "<%= modifyNum %>">
	제목: <input name = "title" value = "<%= title %>"><br>
	작성자: <input name = "id" value = "<%= id %>"><br>
	내용: <textarea name = "content" rows="10" cols="50" ><%= content %></textarea><br>
	<input type = "submit" value = "수정완료" >
	</form>
	
<% 	
	} catch (Exception e) {
		e.printStackTrace();
	}
%>

	<form action = "list.jsp" method = "get">
	 <input type = "submit" value = "이전 페이지">
	</form>
	
	
</body>
</html>