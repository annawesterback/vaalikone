<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='../addanswer' method='post'>
<input type='text' name='ehdokas_id' value=''>
<input type='text' name='kysymys_id' value=''>
<input type='text' name='vastaus' value=''>
<input type='text' name='kommentti' value=''>
<input type='submit' name='ok' value='OK'>
</form>
<ol>
<c:forEach var="vastaukset" items="${requestScope.answerslist }">
	<li>${fish} <a href='/rest/vaalikoneservice/deleteanswer/${vastaukset.ehdokas_id}'>Delete</a>
	 <a href='../readtoupdateanswers?id=${vastaukset.ehdokas_id}'>Update</a>
</c:forEach>
</ol>
</body>
</html>
