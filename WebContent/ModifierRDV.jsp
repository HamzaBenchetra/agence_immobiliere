<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %> 
<%@page import="java.util.ArrayList" %>
	<%@page import="Model.date" %>
	<%@page import="Model.Fonctions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body>

<nav >
    <div class="nav-wrapper indigo darken-4 ">
    
      <a href="#" class="brand-logo white-text">IMOOBB  </a>
      
       <ul id="nav-mobile" class="right hide-on-med-and-down white-text">
        <li><a href="" class="white-text"><h5>MonCompte</h5></a></li>
        <li><a href=""class="white-text"><h5>Contacter nous</h5></a></li>
        <li><a href=""class="white-text"><h5>Aide</h5></a></li>
        <li><a href="/AgenceImmobiliere/SignupEmp"class="white-text"><h5>Travailler avec nous</h5></a></li>
                            <li><a href="/AgenceImmobiliere/ListeRDV" class="white-text"><h5>Mes Rendez vous</h5></a></li>
        
                    <li><a href="/AgenceImmobiliere/LogoutServlet" class="white-text"><h5>Se deconnecter</h5></a></li>
        
    
      </ul>
   
    
    </div>
  </nav>
<div>
<div class="content mt-3">
            <div class="animated fadeIn">
<%
DateFormat dt= new SimpleDateFormat("yyyy-MM-dd");
Date date=new Date();
ArrayList<date> calendrier=(ArrayList<date>)request.getAttribute("List");
%>
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Dates disponibles</strong><small>   
                        </div>
                        <div class="card-body">
		                            <table class="table">
		                              <thead>
		                                <tr>
		                                  <th scope="col">Jour</th>
		                                  <th scope="col" colspan="4">Horaire</th>
		                                  
		                              </tr>
		                          </thead>
		                          <tbody>
		                            
		                            <%for(int i=1;i<=calendrier.size();i+=4){ %>
		                            <tr>
		                              <th scope="row"><%out.print(calendrier.get(i).getDate()); %></th>
		                              <td>
									    <form action="/AgenceImmobiliere/ModifierRDV" method="post" class="post">
									    <input type="hidden" name="operation" value="dateR">
                						<input type="hidden" name="what" value="add">
									    <input type="hidden" name="date" value=<%=calendrier.get(i-1).getDate() %>>
									    <button type="submit" class="btn btn-primary" id="<%=i-1%>" name="heure" value=<%=calendrier.get(i-1).getHeur()%>><%=calendrier.get(i-1).getHeur()%></button>
									    </form>
									    </td>
									    <td>
									    <form action="/AgenceImmobiliere/ModifierRDV" method="post" class="post">
									    <input type="hidden" name="operation" value="dateR">
                						<input type="hidden" name="what" value="add">
									    <input type="hidden" name="date" value=<%=calendrier.get(i).getDate() %>>
									    <button type="submit" class="btn btn-primary" id="<%=i%>" name="heure" value=<%=calendrier.get(i).getHeur()%>><%=calendrier.get(i).getHeur()%></button>
									    </form>
									    </td>
									    <td>
									    <form action="/AgenceImmobiliere/ModifierRDV"" method="post" class="post">
									    <input type="hidden" name="operation" value="dateR">
                						<input type="hidden" name="what" value="add">
									    <input type="hidden" name="date" value=<%=calendrier.get(i+1).getDate() %>>
									    <button type="submit" class="btn btn-primary" id="<%=i+1%>" name="heure" value=<%=calendrier.get(i+1).getHeur()%>><%=calendrier.get(i+1).getHeur()%></button>
									    </form>
									    </td>
									    <td>
									    <form action="/AgenceImmobiliere/ModifierRDV" method="post" class="post">
									    <input type="hidden" name="operation" value="dateR">
                						<input type="hidden" name="what" value="add">
									    <input type="hidden" name="date" value=<%=calendrier.get(i+2).getDate() %>>
									    <button type="submit" class="btn btn-primary" id="<%=i+2%>" name="heure" value=<%=calendrier.get(i+2).getHeur()%>><%=calendrier.get(i+2).getHeur()%></button>
									    </form>
									    </td>
		                           </tr>
		                           <%} %>
		                           
		                           
		                      </tbody>
		                  </table>
                        </div>
                    </div>
                </div>
            </div><!-- .animated -->
        </div>


<script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
	<script>
	var i;
	<%for(int i=1;i<=calendrier.size();i++){%>	
		var e='<%=calendrier.get(i-1).getEtat()%>';
		i='<%=i-1%>';
		if(e=="false"){
			console.log(e);
			console.log(i);
			document.getElementById(i).disabled = true;
			document.getElementById(i).setAttribute('class','btn btn-danger')
		}
	<%}%>
	</script>
</div>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br></br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</br>
</body>
<footer class="page-footer  blue ">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
</html>