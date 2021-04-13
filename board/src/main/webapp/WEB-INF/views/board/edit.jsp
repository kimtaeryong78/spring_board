<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>${board.bno}</td>
		</tr>	
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" value="${board.title}"></td>
		</tr>	
		<tr>
			<td>내용</td>
			<td><textarea rows="5" cols="5" name="content">${board.content}</textarea></td>
		</tr>	
		<tr>
			<td>작성자</td>
			<td><input type="text" name="title" value="${board.writer}"></td>
		</tr>	
		<tr>
			<td>작성일</td>
			<td>${board.regdate}</td>
		</tr>	
	</table>
</body>
</html>
