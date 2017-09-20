<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="5">
	<tr>
		<th>User Name</th>
		<th>Email</th>
		<th>Age</th>
		<th>Country</th>
	</tr>	
	<c:forEach var="user" items="${UserList}">
	<tr>	
		<td><c:out value="${user.name}"></c:out></td>
		<td><c:out value="${user.email}"></c:out></td>
		<td><c:out value="${user.age}"></c:out></td>
		<td><c:out value="${user.country}"></c:out></td>		
	</tr>
	</c:forEach>
	</table>
</body>
</html>