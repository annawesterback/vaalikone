<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style><%@include file="/jsp/style.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaalikone</title>
</head>
<body>




<h1>Lisää uusi kysymys</h1>
<br>

<h2>
<a href='/ShowQuestions'>Takaisin kysymyksiin</a> <br>
<a href='/mainpage'>Takaisin pääsivulle</a>
</h2>


<form action='/addquestions' method='post'>
Kysymyksen ID: <input type='text' name='kysymys_id' value='${requestScope.kysymykset.id}'><br> 
Kysymys: <input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys}'><br>
<input type='submit' name='ok' value='Send help'> 
</form>

<br>
<br>





</body>
</html>