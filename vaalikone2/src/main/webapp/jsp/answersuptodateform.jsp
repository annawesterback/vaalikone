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
<form action='rest/vaalikoneservice/updateanswer' method='post'>
Ehdokas id: <input type='text' name='ehdokas_id' value='${requestScope.vastaukset.ehdokas_id }'>
Kysymys id: <input type='text' name='kysymys_id' value='${requestScope.vastaukset.kysymys_id }'>
Vastaus: <input type='text' name='vastaus' value='${requestScope.vastaukset.vastaus }'>
Kommentti: <input type='text' name='kommentti' value='${requestScope.vastaukset.kommentti }'>
<input type='submit' name='ok' value='OK'>
</form>
</body>
</html>