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

<a href='/mainpage'>Takaisin pääsivulle</a> <br> <br>
<h3> <a href='/addcandidates?id=${ehdokkaat.id}'>Lisää uusi ehdokas</a> </h3>
<br>

	<ol>
		<c:forEach var="ehdokkaat" items="${requestScope.candidateslist}" >
		<h3><li>${ehdokkaat.id}: 
			${ehdokkaat.sukunimi}, 
			${ehdokkaat.etunimi}, 
			${ehdokkaat.ammatti},			
			${ehdokkaat.kunta},
			${ehdokkaat.puolue} </h3>
			<h4> ${ehdokkaat.miksi}, <br>
			${ehdokkaat.mita}	<br>
			<a href='/deletecandidates?id=${ehdokkaat.id}'>delete</a> 
			<a href='/readtoupdatecandidates?id=${ehdokkaat.id}'>update</a></h4>
		</c:forEach>
	</ol>

<%
// SCRIPLETTI - jos ei käytetä taglibrarya, niin käytä javakoodia
// tämä voiso olla DO-GET metodin sisällä HelloAppEngine

%>

<%--  <%@ include file="../html/somehtml.html" %> --%>

<!-- <h3>Lisää uusi henkilö</h3> -->
<!-- <form action='/addcandidates' method='post'> -->
<%-- Ehdokkaan id: <input type='text' name='ehdokas_id' value='${requestScope.ehdokkaat.id}'><br>  --%>
<%-- Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi}'><br> --%>
<%-- Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi}'><br> --%>
<%-- Ehdokkaan puolue: <input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue}'><br> --%>
<%-- Ehdokkaan kotikunta: <input type='text' name='kotipaikkakunta' value='${requestScope.ehdokkaat.kunta}'><br> --%>
<%-- Ehdokkaan ammatti: <input type='text' name='ammatti' value='${requestScope.ehdokkaat.ammatti}'><br> --%>
<%-- Ehdokkaan syy haluta eduskuntaan: <input type='text' name='miksi_eduskuntaan' value='${requestScope.ehdokkaat.miksi}'><br> --%>
<%-- Mitä asioita haluat edistää: <input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.ehdokkaat.mita}'><br> --%>
<!-- <input type='submit' name='ok' value='Send help'>  -->
<!-- </form> -->

 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>