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
<!-- http://localhost:8080/rest/vaalikoneservice/all -->

</head>
<body>
<header>
<img alt="" src="/jsp/vote.png" alt="vote" class="center">
</header>
<ul>
  <li><a href='/jsp/usermainpage.jsp'>Etusivu</a></li>
  <li><a href='/addquestions'>Vastaa kysymyksiin</a></li>
  <li style="float:right"><a class="active" href="/index.html">Kirjaudu ulos</a></li>
</ul>

<h1>Kandidaatti näkee kysymykset täällä</h1>

<br>
<br>


<h2> Kysymykset ja vastauksesi</h2>
<br>
	

 	<ol>
 	
 	
		<c:forEach var="vastaukset" items="${requestScope.answerslist}" >
		<h3>
		
				${vastaukset.ehdokkaat.ehdokasId}:
		 		${vastaukset.kysymykset.kysymysId} 
				${vastaukset.vastaus}	
				${vastaukset.kommentti}
	
				</h3>			
		

		</c:forEach>
	</ol>
 
 
 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>