<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="<%= request.getContextPath() %>/resources/pet4.jpg" width="100" height="100">
	<h3>${dto.name}님 환영합니다!!!</h3>
</body>
</html>