<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>list.jsp<br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	size : ${list.size() }
	<table border="1">
	 	<tr>
	 		<th>id</th> <th>pwd</th> <th>name</th>
	 	</tr>
	 	
	 	<c:if test="${list.size() == 0 }">
	 		<tr>
	 			<th colspan="3">데이터 없음!!!</th>
	 		</tr>
	 	</c:if>
	 	
	 	<c:forEach var="dto" items="${list }">
	 	<tr>
	 		<td>${dto.id }</td>
	 		<td>${dto.pwd }</td>
	 		<td>
	 			<a href="info?id=${dto.id }">${dto.name }</a>
	 		</td>
	 	</tr>
	 	</c:forEach>
	 	<tr>
	 		<td colspan="3">
	 			<a href="index">index 이동</a>
	 		</td>
	 	</tr>
	</table>
</body>
</html>