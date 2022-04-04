<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Candidates" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>


<!-- Tohon hreffiin tehdään joku css filu? -->
<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h2>Tervetuloa vaalikoneeseen</h2>

<!-- AHAA eli tässä käytetään JOKO TAI eli tämä alempi (tommi sano että vaikee) ja sitten tuo array list mikä on jspjavana -->
<!-- eli sitä ois vissiin syytä käyttää. Ei toimi ainakaan vielä (videolla n. kohta 45min)-->
	<ol>
		<c:forEach var="candidates" items="${requestScope.candidateslist}" >
			<li>${ehdokkaat.id}: ${ehdokkaat.sukunimi} <a href='/deletecandidates?id=${ehdokkaat.id}'>delete</a> <a href='/editcandidates?id=${ehdokkaat.id}'>update</a>
		</c:forEach>
	</ol>

<%
ArrayList<Candidates> candidatesList=(ArrayList<Candidates>)request.getAttribute("candidateslist");

for (int i=0;candidatesList!=null && i<candidatesList.size();i++){
	Candidates f=candidatesList.get(i);
	out.println(f.getId()+": "+f.getSukunimi()+"<a href='/deletecandidates?id="+f.getId()+"'>deletecandidates</a> <a href='/?id="+f.getId()+"'>editcandidates</a>");
}
%>

<%--  <%@ include file="../html/somehtml.html" %> --%>



</body>
</html>