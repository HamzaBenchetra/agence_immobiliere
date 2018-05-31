
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Model.Appartement"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="Model.OperationsClient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" type="text/css" href="Tableau.css">
<%
	ArrayList<Appartement> allA = (ArrayList<Appartement>)request.getAttribute("Apparts");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Appartements</title>
</head>
<body>
<body>
		<table class="container">			
				<thead>
					<tr>
					<th><h1>Type d'appartement</h1></th>
					<th><h1>Etage</h1></th>
					<th><h1>Prix (En DA)</h1></th>					
					</tr>
				</thead>
				<%for(int i=0 ; i<allA.size() ; i++){ %>				
				<tbody>
				<tr>
				<td><%= allA.get(i).getType()%></td>
				<td><%= allA.get(i).getEtage()%></td>
				<td><%= (int)allA.get(i).getPrix()%></td>
				<td><div align="center">
	<form   action="http://192.168.43.108:8080/AgenceImmobiliere/ConsuListApparts"  method = "post">
				<input type="hidden" name ="IDA" value="<%=allA.get(i).getIdAppart() %>" >		
		  		<input type=submit value="Voir Détails"/>
	</form>
	</div>
				</td>
					
				
				</tr>
				
				
			<%
				}
			%>
			</tbody>
			</table>
	
	<button><a href="http://192.168.43.108:8080/AgenceImmobiliere/EspaceClient.jsp">Retour a l'accueil</a></button>
	
</body>
</body>
</html>