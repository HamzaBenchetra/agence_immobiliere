<%@page import="Model.Appartement"%>

<!DOCTYPE html>

<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Details de l'appartement</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/css/materialize.min.css">

  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.5/js/materialize.min.js"></script>

 

	 <script src="js/jquery.min.js"></script>
	 <script src="js/materialize.min.js"></script>
	 <link rel="stylesheet" href="css/materialize.min.css">

	<style>
      body{ background:#ddd; }
    </style>
</head>
<body>
	<script>
 	$(document).ready(function(){
 		$('.materialbox').materialbox();
 		
 	});
    </script>

<%  
	Appartement Ap = (Appartement)request.getAttribute("Appart");
%>

    <!-- Image Gallery -->

<nav >
    <div class="nav-wrapper indigo darken-4 ">
    
      <a href="#" class="brand-logo white-text">IMOOBB  </a>
      
       <ul id="nav-mobile" class="right hide-on-med-and-down white-text">
        <li><a href="" class="white-text"><h5>MonCompte</h5></a></li>
        <li><a href=""class="white-text"><h5>Contacter nous</h5></a></li>
        <li><a href=""class="white-text"><h5>Aide</h5></a></li>
        <li><a href="http://localhost:8080/AgenceImmobiliere/SignupEmp"class="white-text"><h5>Travailler avec nous</h5></a></li>
                                    <li><a href="/AgenceImmobiliere/ListeRDV" class="white-text"><h5>Mes Rendez vous</h5></a></li>
        
                    <li><a href="/AgenceImmobiliere/LogoutServlet" class="white-text"><h5>Se deconnecter</h5></a></li>
        
    
      </ul>
   
    
    </div>
  </nav>
    <div class="container ">
  	<h1>Details de l'appartement</h1>

  	<div class="row card">
  		
  		<div class="col s6 m6 l4">
  			<img src="<%=Ap.getImages().get(0)%>" class="materialbox responsive-img card">
  		</div>
  		<div class="col s6 m6 l4">
  			<img src="<%=Ap.getImages().get(1)%>" class="materialbox responsive-img card">
  		</div>
  		<div class="col s6 m6 l4">
  			<img src="<%=Ap.getImages().get(2)%>" class="materialbox responsive-img card">
  		</div>


  		
  	 </div>
  	 <div align="left">
  		
  		<h4>Type de l'appartement : <%=Ap.getType()%> </h4>
  		<h4>Etage  : <%=Ap.getEtage()%> </h4>
  		<h4>Secteur :<%=Ap.getNomRegion()%> </h4>
  		<h4>Localité  : <%=Ap.getNomLocal()%> </h4>
   		<h4>Prix :<%=Ap.getPrix()%> </h4>
  		<h4>Description  : <%=Ap.getDescription()%> </h4>
  		
  	 </div>
  	 <form action="/AgenceImmobiliere/FixerRDVClient" Class="fixed" method="get"  >
                        <div class="form-group">

                                   <button class="btn waves-effect waves-light" type="submit" name="action">Fixer un rendez vous
                                    <i class="material-icons right"></i>
                                    <input type="hidden" name="idAppart" id="what" value="<%=Ap.getIdAppart()%>">

                                   </button>
  </div>
  </div>
  </form>

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
          <div class="footer-copyright">
            <div class="container">
            © 2014 Copyright Text
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
  <!--  Scripts-->
  
	
</body>
</html>