<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 <style><%@include file="/jsp/style.css"%></style>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
</head>
<body>
<h1>Muokkaa vaalikonetta</h1>
<h2>
<a href='/ShowQuestions'>takaisin</a>
</h2>

<form action='/editquestions' method='post'>
Kysymys ID: <input type='text' name='kysymys_id' value='${requestScope.kysymykset.id}' readonly><br> 
Kysymys: <input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>