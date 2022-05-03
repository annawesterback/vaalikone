<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style><%@include file="/jsp/style.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Vaalikone</title>

</head>

<body>

<h2>Kanditaatti vastaa kysymyksiin</h2>
<form action="/rest/vaalikoneservice/useranswerquestions" method='post'>
Kysymyksen ID: <input type='text' name='kysymys_id' value='${requestScope.kysymykset.id}' readonly><br> 
Kysymys: <input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys} readonly'><br>
<input type='submit' name='ok' value='Lähetä'><br>
</form>
</body>
</html>