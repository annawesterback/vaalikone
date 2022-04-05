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
<header> TÄHÄN JOKU LOGO??
</header>
<h2>Tervetuloa vaalikoneeseen</h2>


	<ol>
		<c:forEach var="ehdokkaat" items="${requestScope.candidateslist}" >
		<h4><li>${ehdokkaat.id}: 
			${ehdokkaat.sukunimi}, 
			${ehdokkaat.etunimi}, 
			${ehdokkaat.ammatti},			
			${ehdokkaat.kunta},
			${ehdokkaat.puolue} </h4> <br>
			${ehdokkaat.miksi}, <br>
			${ehdokkaat.mita}	<br>
			<a href='/deletecandidates?id=${ehdokkaat.id}'>delete</a> 
			<a href='/readtoupdatecandidates?id=${ehdokkaat.id}'>update</a>
		</c:forEach>
	</ol>

<%
// ArrayList<Candidates> candidatesList=(ArrayList<Candidates>)request.getAttribute("candidateslist");

// for (int i=0;candidatesList!=null && i<candidatesList.size();i++){
// 	Candidates f=candidatesList.get(i);
// 	out.println(f.getId()+": "+f.getSukunimi()+
// 			"<a href='/deletecandidates?id="+f.getId()+
// 			"'>deletecandidates</a> <a href='/readtoupdatecandidates?id="+f.getId()+
// 			"'>editcandidates</a>");
// }
%>

<%--  <%@ include file="../html/somehtml.html" %> --%>

<h3>Lisää uusi henkilö</h3>
<form action='/jsp/addcandidates.jsp' method='post'>
Ehdokkaan id: <input type='text' name='ehdokas_id' value='${requestScope.ehdokkaat.id}'><br> 
Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi}'><br>
Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue}'><br>
Ehdokkaan kotikunta: <input type='text' name='kotikunta' value='${requestScope.ehdokkaat.kunta}'><br>
Ehdokkaan ammatti: <input type='text' name='ammatti' value='${requestScope.ehdokkaat.ammatti}'><br>
Ehdokkaan syy haluta eduskuntaan: <input type='text' name='miksi_eduskuntaan' value='${requestScope.ehdokkaat.miksi}'><br>
Ehdokkaan edistaminen: <input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.ehdokkaat.mita}'><br>
<input type='submit' name='ok' value='Send help'> 
</form>

 
<footer>
© Ansa Holttinen, Johanna Sieranoja & Anna Westerback
</footer>
</body>

</html>