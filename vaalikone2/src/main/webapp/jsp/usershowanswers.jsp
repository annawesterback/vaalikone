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
<!-- http://localhost:8080/rest/vaalikoneservice/all -->

</head>
<body>
<header>
<img alt="" src="/jsp/vote.png" alt="vote" class="center">
</header>
<ul>
  <li><a href='/jsp/usermainpage.jsp'>Etusivu</a></li>
  <li><a href='/jsp/answersform.jsp'>Vastaa kysymyksiin</a></li>
  <li style="float:right"><a class="active" href="/index.html">Kirjaudu ulos</a></li>
</ul>

<h1>Kandidaatti näkee kysymykset täällä</h1>

<br>
<br>


<h2> Kysymykset ja vastauksesi</h2>
<br>
		<h3><a>
	1 = täysin eri mieltä, 
	2 = jokseenkin eri mieltä, 
	3 = ei eri eikä samaa mieltä, 
	4 = jokseenkin samaa mieltä, 
	5 = täysin samaa mieltä</a></h3>

 	<ol>
 	
 	
		<c:forEach var="vastaukset" items="${requestScope.answerslist}" >
		<h3>
						
		<a>Ehdokas id: </a>${vastaukset.ehdokkaat.ehdokasId} <br>
		<a>Ehdokkaan nimi: </a>${vastaukset.ehdokkaat.sukunimi}  ${vastaukset.ehdokkaat.etunimi}<br>
		<a>Kysymys id ja kysymys: </a> ${vastaukset.kysymykset.kysymysId}
		 		${vastaukset.kysymykset.kysymys}<br>
		<a>Vastauksesi (1-5): </a>${vastaukset.vastaus}	<br>
		<a>Kommentti: </a>${vastaukset.kommentti}<br>

		</h3>			
		<h4><a href='/rest/vaalikoneservice/deleteanswer/${vastaukset.id}'>Poista</a> 
			<a href='/rest/vaalikoneservice/readtoupdateanswer/${vastaukset.id}'>Päivitä</a>

		</h4> 
		

		</c:forEach>
	</ol>
 
 
 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>