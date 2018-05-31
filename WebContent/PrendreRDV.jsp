<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<%
DateFormat dt= new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date();

%>
	<form action="http://192.168.43.108:8080/AgenceImmobiliere/PrendreRDV" method="post" >
		
		<input type="date" name="date" min="<%=dt.format(date)%>" required>
		
		
		
	<label class="col-md-4 control-label" for="type">heure</label>
	    
	    <select id="heure" name="heure">
	      <option value="08:00:00">8H</option>
	      <option value="10:00:00">10H</option>
	      <option value="12:00:00">12H</option>
	      <option value="14:00:00">14H</option>
	      <option value="16:00:00">16H</option>
	    </select>
  

	<button type="submit" >Réserver</button>
		
	</form>
	
		<button><a href="http://192.168.43.108:8080/AgenceImmobiliere/EspaceClient.jsp">Retour a l'accueil</a></button>
	</div>
</body>
</html>
