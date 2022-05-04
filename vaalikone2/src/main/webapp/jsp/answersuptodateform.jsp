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
<form action='../updateanswer' method='post'>
<input type='text' name='ehdokas_id' value='${requestScope.vastaukset.ehdokas_id }'>
<input type='text' name='kysymys_id' value='${requestScope.vastaukset.kysymys_id }'>
<input type='text' name='vastaus' value='${requestScope.vastaukset.vastaus }'>
<input type='text' name='kommentti' value='${requestScope.vastaukset.kommentti }'>
<input type='submit' name='ok' value='OK'>
</form>
</body>
</html>