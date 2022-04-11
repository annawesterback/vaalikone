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
<h1>Täällä näet kysymykset</h1>

<br>
<br>


<h2> <a href='/addquestions'>Lisää uusi kysymys</a> <br>


<a href='/mainpage'>Takaisin pääsivulle</a>
</h2>
<br>
	<ol>
		<c:forEach var="kysymykset" items="${requestScope.questionslist}" >
		<h3><li>${kysymykset.id}:
			${kysymykset.kysymys} </h3>
		<h4><a href='/deletequestions?id=${kysymykset.id}'>delete</a> 
			<a href='/readtoupdatequestions?id=${kysymykset.id}'>update</a></h4>
		</c:forEach>
	</ol>
 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>