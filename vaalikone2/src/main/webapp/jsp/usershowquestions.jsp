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
<!-- http://localhost:8080/rest/vaalikoneservice/all -->

</head>
<body>
<header>
<img alt="" src="/jsp/vote.png" alt="vote" class="center">
</header>
<ul>
  <li><a href='/mainpage'>Etusivu</a></li>
  <li><a href='/addquestions'>Vastaa kysymyksiin</a></li>
  <li style="float:right"><a class="active" href="/index.html">Kirjaudu ulos</a></li>
</ul>

<h1>Kandidaatti näkee kysymykset täällä</h1>

<br>
<br>


<h2> Kysymykset ja vastauksesi</a>
</h2>
<br>
	<ol>
		<c:forEach var="kysymykset" items="${requestScope.questionslist}" >
		<h3><li>${kysymykset.id}:
		${kysymykset.kysymys} 
</h3>			
		<h4><a href='/deletequestions?id=${kysymykset.id}'>Poista</a> <!-- vaihda linkit osoittamaan resteihin -->
			<a href='/readtoupdatequestions?id=${kysymykset.id}'>Päivitä</a></h4> <!-- vaihda linkit osoittamaan resteihin -->

		</c:forEach>
	</ol>
	
 
 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>