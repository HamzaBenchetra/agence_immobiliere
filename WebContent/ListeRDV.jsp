 <%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page import="Model.RDV"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="Model.OperationsClient" %>
		<%@page import="Model.Appartement" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <!-- <link rel="stylesheet" href="assets/css/bootstrap-select.less"> -->
    <link rel="stylesheet" href="assets/scss/style.css">
    <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="Matrelize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="Matrelize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>
<%
	ArrayList<RDV> allR = (ArrayList<RDV>)request.getAttribute("RDVs");
	ArrayList<Appartement> allapp=(ArrayList<Appartement>)request.getAttribute("Apparts");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste de vos Rendez-vous</title>
</head>
<body>
<body>



                                        
                                         
                <table class="table">			
				<thead>
					<tr>
					
					<th><h1>id Rendez-vous</h1></th>
					<th><h1>Date</h1></th>
					<th><h1>Localité</h1></th>
					<th><h1>type Appartement</h1></th>
					<th><h1>Prix</h1></th>
					<th><h1>Annuler RDV</h1></th>
										
					</tr>
				</thead>
				<%for(int i=0 ; i<allR.size() ; i++){ %>				
				<tbody>
				<tr>
							
				
				<td><%= allR.get(i).getIdRDV()%></td>
				<td><%= allR.get(i).getD()%></td>
				<td><%= allapp.get(i).getNomLocal()%></td>
				<td><%= allapp.get(i).getType()%></td>
				<td><%= allapp.get(i).getPrix()%></td>
		 <form action="/AgenceImmobiliere/AnnulerRDV" method="POST">
 <input type="hidden" name="idRDV" id="what" value="<%=allR.get(i).getIdRDV()%>">
	
				<td> <input  value="Annuler Rendez vous" type="submit" id=/></td>
				
		</form>	
		 <form action="/AgenceImmobiliere/ModifierRDV" method="get">
 <input type="hidden" name="idRDV" id="what" value="<%=allR.get(i).getIdRDV()%>">
	 <input type="hidden" name="idAppart" id="what" value="<%= allapp.get(i).getIdAppart()%>">
	
				<td> <input  value="Modifier Rendez vous" type="submit" id=/></td>
				
		</form>	
				</tr>
				
			<%
				}
			%>
			</tbody>
                                   	 
		
			</table>
	
	<button><a href="/AgenceImmobiliere/ListAppartGlobale">Retour a l'accueil</a></button>
	
</body>
</body>
</html>