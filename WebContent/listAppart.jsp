
      <%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <!-- CSS  -->
  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="Matrelize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="assets/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  
  <!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="engine1/style.css" />
<script type="text/javascript" src="engine1/jquery.js"></script>	<script src="https://www.youtube.com/iframe_api"></script>

<!-- End WOWSlider.com HEAD section -->


  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="grey lighten-2">
				
				
				<nav >
    <div class="nav-wrapper indigo darken-4 ">
    
      <a href="#" class="brand-logo white-text">IMOOBB  </a>
      
      <ul id="nav-mobile" class="right hide-on-med-and-down white-text">
        <li><a href="" class="white-text"><h5>s'inscire</h5></a></li>
        <li><a href=""class="white-text"><h5>Contacter nous</h5></a></li>
        <li><a href=""class="white-text"><h5>Aide</h5></a></li>
        <li><a href=""class="white-text"><h5>Travailler avce nous</h5></a></li>
    
      </ul>
   
    
    </div>
  </nav>
  
  
  
  

</br>
</br>
</br>
</br>




<div class="container col s12 ">
										
										<div class="row">
					    <div class="col s12 m6">
   										<c:forEach items="${ListAppart}" var="Appart"   >
					      <div class="card">
					        <div class="card-image">
					           <img src=${Appart.getImages().get(0)}>
					          <span class="card-title">le Type D'appartement ${Appart.getType()}</span>
					          <a class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
					        </div>
					        <div class="card-content">
					          <p> le Prix est: ${Appart.getPrix()}</p>
					          	          <p> la localité est: ${Appart.getNomLocal()}</p>
					        </div>
					      </div>
					      </c:forEach>
					    </div>
					  </div>
				  				  </div>
				  
	
			
	
  </div>
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
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
</body>
</html>