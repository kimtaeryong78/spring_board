<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 수정</title>
</head>
<body>
	<form action="/board/edit" method="post" id="form">
		<table border="1">
			<tr>
				<td>번호</td>
				<td><input type="text" name="bno" value="${board.bno}" readonly></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="5" cols="22" name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${board.writer}-수정" readonly></td>
			</tr>
			<tr>
				<td>작성일</td>
				<td>${board.regdate}</td>
			</tr>
		</table>
		<button onclick="form.submit">수정</button>
	</form>
</body>
</html>
