<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/jsp/style.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3>Lisää uusi KYSYMYS</h3>
<form action='/addquestions' method='post'>
Kysymyksen ID: <input type='text' name='kysymys_id' value='${requestScope.kysymykset.id}'><br> 
Kysymys: <input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys}'><br>
<input type='submit' name='ok' value='Send help'> 
</form>

<br>
<br>
<a href='/mainpage'>Takaisin pääsivulle</a>

</body>
</html>