<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 조회</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${board.bno}</td>
		</tr>	
		<tr>
			<td>제목</td>
			<td>${board.title}</td>
		</tr>	
		<tr>
			<td>내용</td>
			<td>${board.content}</td>
		</tr>	
		<tr>
			<td>작성자</td>
			<td>${board.writer}</td>
		</tr>	
		<tr>
			<td>작성일</td>
			<td>${board.regdate}</td>
		</tr>	
	</table>
</body>
</html>
