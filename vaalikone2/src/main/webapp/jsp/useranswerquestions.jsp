<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Questions" %>   
  <%@ page import="data.Answers" %>  
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
Kysymys: <input type='text' name='kysymys' value='${requestScope.kysymykset.kysymys}' readonly><br>
Vastaus: <input type='text' name='vastaus' value='${requestScope.vastaukset.vastaus}' ><br>
Kommentti: <input type='text' name='kommentti' value='${requestScope.vastaukset.kommentti}'><br>
<input type='submit' name='ok' value='Lähetä'><br>
</form>
</body>
</html>