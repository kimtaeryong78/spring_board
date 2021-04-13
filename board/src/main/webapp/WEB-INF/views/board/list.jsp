<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<div id="container">
	<h1>게시판</h1>
		<table border="1">
			<c:forEach var="board" items="${list}">
				<tr>
					<td>${board.bno}</td>
					<td>${board.title}</td>
					<td>${board.writer}</td>
					<td>${board.regdate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>