<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
</head>
<body>
	
	<form action="/board/register" method="post">
	<ul>
		<li>제목 : <input type="text" name="title" placeholder="title" autofocus></li>
		<li>내용  <textarea rows="10" cols="100" name="content" placeholder="content"></textarea></li>
		<li>글쓴이 : <input type="text" name="writer" placeholder="writer"></li>
	</ul>
		<input type="submit" value="등록">
	</form>
</body>
</html>