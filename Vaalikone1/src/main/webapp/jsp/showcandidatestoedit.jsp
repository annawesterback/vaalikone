<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 <style><%@include file="/jsp/style.css"%></style>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
</head>
<body>
<h1>Muokkaa vaalikonetta</h1>
<h2>
<a href='/showcandidates'>Takaisin</a>
</h2>

<form action='/editcandidates' method='post'>
Ehdokkaan id: <input type='text' name='ehdokas_id' value='${requestScope.ehdokkaat.id}' readonly><br> 
<%-- Ehdokkaan id: <input type='text' name='ehdokas_id' value='${requestScope.ehdokas_id}' readonly><br>  --%>
Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi}'><br>
Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi}'><br>
Ehdokkaan ikä: <input type='text' name='ika' value='${requestScope.ehdokkaat.ika}'><br>
Ehdokkaan kunta: <input type='text' name='kotipaikkakunta' value='${requestScope.ehdokkaat.kunta}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue}'><br>
Ehdokkaan ammatti: <input type='text' name='ammatti' value='${requestScope.ehdokkaat.ammatti}'><br>
Miksi eduskuntaan: <input type='text' name='miksi_eduskuntaan' value='${requestScope.ehdokkaat.miksi}'><br>
Mitä asioita haluat edistää : <input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.ehdokkaat.mita}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>