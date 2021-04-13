<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 작성</title>
<style type="text/css">
body{
    width: 900px;
    margin: 20px auto 0px;
    background-color: #dddddd4f;
}
.container{display: block;background-color: #eee;padding-top: 1px;}
li {border-bottom: 1px; padding: 5px 10px; list-style: none;}
input[type="text"] {height: 30px; width: 400px;}
input[name="writer"]{position: relative;}
input[type="submit"]{position: relative; bottom: 60px; left:490px; width: 100px; height: 40px;}
</style>
</head>
<body>
	<div class="container">
		<form action="/board/register" method="post">
			<ul>
				<li><input type="text" name="title" placeholder="title" autofocus></li>
				<li><textarea rows="10" cols="100" name="content" placeholder="content"></textarea></li>
				<li><input type="text" name="writer" placeholder="writer"></li>
			</ul>
			<input type="submit" value="등록">
		</form>
	</div>
</body>
</html>
