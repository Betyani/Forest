<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 - 글쓰기</title>
<script src="function.js"></script>
</head>
<body>
<%@include file = "index.jsp" %>
	<form name = "form" action = "writeProc.jsp" method = "post" onsubmit="return validateForm()">
	제목: <input name = "title"><br>
	작성자: <input name = "id"><br>
	내용: <textarea name = "content" rows="10" cols="50"></textarea><br>
	<input type = "submit" value = "작성완료" >
	</form>
	
	<form action = "list.jsp" method = "get">
	 <input type = "submit" value = "이전 페이지">
	</form>

	
</body>
</html>