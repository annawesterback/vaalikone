<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="model.Kysymykset" %>    
  <%@ page import="model.Vastaukset" %>  
 <style><%@include file="/jsp/style.css"%></style>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
</head>
<body>
<ul>
	  <li><a href='/rest/vaalikoneservice/allanswers'>Takaisin</a></li>
</ul>		  
	<h3>Vastaa kysymyksiin numeroilla 1-5 <br>
	1 = täysin eri mieltä <br>
	2 = jokseenkin eri mieltä <br>
	3 = ei eri eikä samaa mieltä <br>
	4 = jokseenkin samaa mieltä <br>
	5 = täysin samaa mieltä</h3>

	<form action="/rest/vaalikoneservice/addanswer" method="post">
	Ehdokas id:<input type='text' name='eid' value=''><br>
	Kysymys id: <input type='text' name='kid' value=''><br>
	Vastaus: <input type='text' name='vastaus' value=''><br>
	Kommentti: <input type='text' name='kommentti' value=''><br> 
	<input type='submit' name='ok' value='Send help'>
	</form>

</body>
</html>
