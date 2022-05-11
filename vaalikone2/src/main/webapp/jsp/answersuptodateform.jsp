<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.ArrayList" %>   
	 <%@ page import="model.Kysymykset" %>    
 	 <%@ page import="model.Vastaukset" %>  
  	 <%@ page import="model.Ehdokkaat" %>  
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
		
<form action='/rest/vaalikoneservice/updateanswer' method='post'>
Vastaus id: <input type='text' name='vastaus_id' value='${requestScope.answer.id }'readonly>
Ehdokas id: <input type='text' name='ehdokas_id' value='${requestScope.answer.ehdokkaat.ehdokasId }'readonly>
Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.answer.ehdokkaat.etunimi}'readonly>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.answer.ehdokkaat.sukunimi}'readonly>	
Kysymys id: <input type='text' name='kysymys_id' value='${requestScope.answer.kysymykset.kysymysId }'readonly>
Vastaus: <input type='text' name='vastaus' value='${requestScope.answer.vastaus }'>
Kommentti: <input type='text' name='kommentti' value='${requestScope.answer.kommentti }'>
<input type='submit' name='ok' value='OK'>
</form>
</body>
</html>