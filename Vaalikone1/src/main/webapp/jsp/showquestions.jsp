<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Questions" %>   
 <style><%@include file="/jsp/style.css"%></style>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>


</head>
<body>
<header>
<img alt="" src="jsp/vote.png" alt="vote" class="center">
</header>
<h2>Täällä näet kysymykset</h2>

	<ol>
		<c:forEach var="kysymykset" items="${requestScope.questionslist}" >
		<h3><li>${kysymykset.kysymys_id}: 
			${kysymykset.kysymys}, </h3>
			<a href='/deletequestions?id=${kysymykset.id}'>delete</a> 
			<a href='/readtoupdatequestions?id=${kysymykset.id}'>update</a></h4>
		</c:forEach>
	</ol>

<%
// SCRIPLETTI - jos ei käytetä taglibrarya, niin käytä javakoodia
// tämä voiso olla DO-GET metodin sisällä HelloAppEngine

%>

<%--  <%@ include file="../html/somehtml.html" %> --%>

<h3>Lisää uusi KYSYMYS</h3>
<form action='/addquestions' method='post'>
<input type='submit' name='ok' value='Send help'> 
</form>

 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>