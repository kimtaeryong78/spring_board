<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${user.id}</h1>
<h1>${user.pwd}</h1>
<h1>${user.enabled}</h1>
<h1>${user.name}님 환영합니다</h1>
<h1>${user.email}</h1>
<h1>${user}</h1>
<h1><%= session.getAttribute("user") %></h1>
${sessionScope.user}
<button onclick="location.href='/logout'">로그아웃</button>
</body>
</html>