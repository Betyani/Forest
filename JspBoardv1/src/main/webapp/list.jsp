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
<title>게시판</title>
</head>
<body>
	<%@include file = "index.jsp" %>
글 번호 | 제목 | 작성자id 
<br>
===================================
<br>
	
	<%
		try {
			Connection con = DbUtill.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from betyani_board order by num");
			int viewNumber = 1;
			
			while(rs.next()) {
				String num = rs.getString("num");
				String title = rs.getString("title");
				String id = rs.getString("id");
	%>
        <div>
	    <a href="read.jsp?num=<%=num%>" style="text-decoration: none; color: inherit;">
            <%= viewNumber %> | <%= title %> | <%= id %>
    	</a>
        </div>
<% 			
				viewNumber++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
%>	
<br>
===================================
<br>
<a href = "write.jsp" style="text-decoration: none; color: inherit;">[글쓰기]</a>

	
</body>
</html>