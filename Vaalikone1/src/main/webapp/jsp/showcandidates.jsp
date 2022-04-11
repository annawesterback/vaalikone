<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidates" %>   
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
<h1>Kaikki ehdokkaat listattuna</h1>
<br>



<h2>
<a href='/addcandidates?id=${ehdokkaat.id}'>Lisää uusi ehdokas</a> <br>
<a href='/mainpage'>Takaisin etusivulle</a>
</h2>

<br>

	<ol>
		<c:forEach var="ehdokkaat" items="${requestScope.candidateslist}" >
		<h3><li>${ehdokkaat.id}: 
			${ehdokkaat.sukunimi}, 
			${ehdokkaat.etunimi}, 
			${ehdokkaat.ika}, 
			${ehdokkaat.ammatti},			
			${ehdokkaat.kunta},
			${ehdokkaat.puolue} </h3>
			<h4> ${ehdokkaat.miksi}, <br>
			${ehdokkaat.mita}	<br>
			<a href='/deletecandidates?id=${ehdokkaat.id}'>delete</a> 
			<a href='/readtoupdatecandidates?id=${ehdokkaat.id}'>update</a></h4>
		</c:forEach>
	</ol>


 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>