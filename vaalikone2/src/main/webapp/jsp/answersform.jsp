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

	<form action="/rest/vaalikoneservice/addanswer" method="post">
	Ehdokas id:<input type='text' name='eid' value=''><br>
	Kysymys id: <input type='text' name='kid' value=''><br>
	Vastaus: <input type='text' name='vastaus' value=''><br>
	Kommentti: <input type='text' name='kommentti' value=''><br> 
	<input type='submit' name='ok' value='Send help'>
	</form>

</body>
</html>
