<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style><%@include file="/jsp/style.css"%></style>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
</head>
<body>


<h1>Lisää uusi henkilö</h1><br>
<h2>
<a href='/showcandidates'>Takaisin ehdokkaisiin</a> <br>
<a href='/mainpage'>Takaisin pääsivulle</a></h2>




<form action='/addcandidates' method='post'>
Ehdokkaan id: <input type='text' name='ehdokas_id' value='${requestScope.ehdokkaat.id}'><br> 
Ehdokkaan sukunimi: <input type='text' name='sukunimi' value='${requestScope.ehdokkaat.sukunimi}'><br>
Ehdokkaan etunimi: <input type='text' name='etunimi' value='${requestScope.ehdokkaat.etunimi}'><br>
Ehdokkaan ikä: <input type='text' name='ika' value='${requestScope.ehdokkaat.ika}'><br>
Ehdokkaan puolue: <input type='text' name='puolue' value='${requestScope.ehdokkaat.puolue}'><br>
Ehdokkaan kotikunta: <input type='text' name='kotipaikkakunta' value='${requestScope.ehdokkaat.kunta}'><br>
Ehdokkaan ammatti: <input type='text' name='ammatti' value='${requestScope.ehdokkaat.ammatti}'><br>
Ehdokkaan syy haluta eduskuntaan: <input type='text' name='miksi_eduskuntaan' value='${requestScope.ehdokkaat.miksi}'><br>
Mitä asioita haluat edistää: <input type='text' name='mita_asioita_haluat_edistaa' value='${requestScope.ehdokkaat.mita}'><br>
<input type='submit' name='ok' value='Send help'> 
</form>

</body>
</html>