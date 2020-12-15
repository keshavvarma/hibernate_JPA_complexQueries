<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book</title>
</head>
<body>
<table>
<c:forEach items="${books}" var="book">
<tr>
	<td>${book.bookId}</td>
	<td>${book.bookName}</td>
	<td>${book.createdOn}</td>
	<td>${book.updatedOn}</td>
</tr>
</c:forEach>
</table>
</body>
</html>