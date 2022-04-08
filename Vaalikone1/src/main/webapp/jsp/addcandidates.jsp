<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/jsp/style.css"%></style>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vaalikone</title>
</head>
<body>

<h3>Lisää uusi henkilö</h3>
<a href='/showcandidates'>Takaisin ehdokkaisiin</a> <br><br>
<a href='/mainpage'>Takaisin pääsivulle</a>

<form action='/addcandidates' method='post'>
Ehdokkaan id: <input type='text' name='ehdokas_id' value='${requestScope.ehdokkaat.id}'><br> 
Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi}'><br>
Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue}'><br>
Ehdokkaan kotikunta: <input type='text' name='kotipaikkakunta' value='${requestScope.ehdokkaat.kunta}'><br>
Ehdokkaan ammatti: <input type='text' name='ammatti' value='${requestScope.ehdokkaat.ammatti}'><br>
Ehdokkaan syy haluta eduskuntaan: <input type='text' name='miksi_eduskuntaan' value='${requestScope.ehdokkaat.miksi}'><br>
Mitä asioita haluat edistää: <input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.ehdokkaat.mita}'><br>
<input type='submit' name='ok' value='Send help'> 
</form>

</body>
</html>