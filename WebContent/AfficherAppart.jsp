<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="Model.Appartement"%>
<html>
<head>

 <link rel="stylesheet" type="text/css" href="Tableau.css">
<%  
	Appartement Ap = (Appartement)request.getAttribute("appartement");
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Afficher details client</title>
</head>
<body>
<body>

		<table class="container">
				
				<thead>
				<tr>
					<th><h1>IdAppartement</h1></th>
					<th><h1>Batiment n:</h1></th>
					<th><h1>type</h1></th>
					<th><h1>Etage</h1></th>
					<th><h1>Localité</h1></th>
					<th><h1>prix</h1></th>
				
					</tr>
				</thead>
				<tbody>
				<tr>
				<td><%= Ap.getIdAppart()%></td>
				<td><%= Ap.getIdBatiment()%></td>
				<td><%= Ap.getType()%></td>
				<td><%= Ap.getEtage()%></td>
				<td><%= Ap.getNomLocal()%></td>
				<td><%= (int)Ap.getPrix()%></td>
				<td>
				<div align="center">
					<form   action="http://192.168.43.108:8080/AgenceImmobiliere/PrendreRDV"  method = "get">
						<input type="hidden" name ="IDApp" value="<%=Ap.getIdAppart() %>" >		
		  				<input type=submit value="Prendre Rendez-Vous!"/>
					</form>
				</div>
				</td>
				</tr>
			</tbody>
			</table>
			<div align="center">
			<form   action="http://192.168.43.108:8080/AgenceImmobiliere/ConsuListApparts"  method = "get">
			<button type="submit">Retour</button>
		    </form>
	</div>
			
</body>
</body>
</html>