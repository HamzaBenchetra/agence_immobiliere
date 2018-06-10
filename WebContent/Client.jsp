   <%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="Matrelize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="Matrelize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  
  <!-- Start WOWSlider.com HEAD section -->
<link rel="stylesheet" type="text/css" href="slide/engine1/style.css" />
<script type="text/javascript" src="slide/engine1/jquery.js"></script>	<script src="https://www.youtube.com/iframe_api"></script>

<!-- End WOWSlider.com HEAD section -->
</head>


  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Internaute</title>
</head>
<body>


	
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
<!-- Start WOWSlider.com BODY section -->
<div id="wowslider-container1">
<div class="ws_images"><ul>
		<li><img src="slide/data1/images/1.jpg" alt="1" title="1" id="wows1_0"/></li>
		<li><img src="slide/data1/images/2.jpg" alt="2" title="2" id="wows1_1"/></li>
		<li><img src="slide/data1/images/3.jpg" alt="3" title="3" id="wows1_2"/></li>
		<li><img src="slide/data1/images/4.jpg" alt="4" title="4" id="wows1_3"/></li>
		<li><a href="http://wowslider.net"><img src="slide/data1/images/bgbody.jpg" alt="bootstrap slider" title="bgbody" id="wows1_4"/></a></li>
		<li><iframe width="100%" height="100%" src="https://www.youtube.com/embed/t7ogDmH4M2Y?autoplay=0&rel=0&enablejsapi=1&playerapiid=ytplayer&wmode=transparent" frameborder="0" allowfullscreen></iframe><img src="slide/data1/images/t7ogdmh4m2y.png" alt="PUB - Agence Immobilière - Juillet 2016" title="PUB - Agence Immobilière - Juillet 2016" id="wows1_5"/></li>
	</ul></div>
	<div class="ws_bullets"><div>
		<a href="#" title="1"><span><img src="slide/data1/tooltips/1.jpg" alt="1"/>1</span></a>
		<a href="#" title="2"><span><img src="slide/data1/tooltips/2.jpg" alt="2"/>2</span></a>
		<a href="#" title="3"><span><img src="slide/data1/tooltips/3.jpg" alt="3"/>3</span></a>
		<a href="#" title="4"><span><img src="slide/data1/tooltips/4.jpg" alt="4"/>4</span></a>
		<a href="#" title="bgbody"><span><img src="slide/data1/tooltips/bgbody.jpg" alt="bgbody"/>5</span></a>
		<a href="#" title="PUB - Agence Immobilière - Juillet 2016"><span><img src="slide/data1/tooltips/t7ogdmh4m2y.png" alt="PUB - Agence Immobilière - Juillet 2016"/>6</span></a>
	</div></div><div class="ws_script" style="position:absolute;left:-99%"><a href="http://wowslider.net">javascript photo gallery</a> by WOWSlider.com v8.8</div>
<div class="ws_shadow"></div>
</div>	
<script type="text/javascript" src="slide/engine1/wowslider.js"></script>
<script type="text/javascript" src="slide/engine1/script.js"></script>
<!-- End WOWSlider.com BODY section -->
 

<div class="row">

     
	<div class="col s12   blue-grey lighten-4">
</br>
</br>
</br>



 
 <div class="container row">
 
 <B><h5>Rechercher un Appartement</h5></B>
                                <form action="/AgenceImmobiliere/ListAppartRech" method="POST">
                           
                                    <ul class="collapsible" data-collapsible="accordion">
                                      <li>
                                        <div class="collapsible-header">
                                          <i class="material-icons">home</i>
                                         Choisir Type Appart
                                          </div>
                                        <div class="collapsible-body">
                                               <p>
                                             
                                               <c:forEach items="${ListType}" var="type"   >
                                          <input name="type" value=${type} type="radio" id=${type} required />
                                          <label for=${type}>${type}</label>
                                        </p>
                                   	 </c:forEach>
                                        
                                       
                                          </div>     
                                       
                                      </li>
                                      
                                    
                                      <li>
                                        <div class="collapsible-header">
                                          <i class="material-icons">location_on</i>
                                         Choisir Localité
                                          </div>
                                        <div class="collapsible-body">
                                               <p>
                                               <c:forEach items="${ListLocalite}" var="localite"   >
					    
					    	<input name="localite" value="${localite}" type="radio" id=${localite} required />
                                          <label for=${localite}>${localite}</label>
					    
					    			</br>
					     				 </c:forEach>
                                          
                                        </p>
                                        
                                       
                                          </div>     
                                       
                                      </li>
                                        
                                        <li>
                                        <div class="collapsible-header">
                                          <i class="material-icons">location_on</i>
                                         Choisir Secteur
                                          </div>
                                        <div class="collapsible-body">
                                               <p>
                                               <c:forEach items="${Secteur}" var="s"   >
					    
					    	<input name="Secteur" value=${s} type="radio" id=${s} required />
                                          <label for=${s}>${s}</label>
					    
					    			</br>
					     				 </c:forEach>
                                          
                                        </p>
                                        
                                       
                                          </div>     
                                       
                                      </li>
                                        <li>
                                        <div class="collapsible-header">
                                          <i class="material-icons">format_list_numbered</i>
                                         Choisir Etage
                                          </div>
                                        <div class="collapsible-body">
                                               <select name="etage" id="select" class="form-control" required>
                                <option value="0">Etage</option>
                                <c:forEach items="${ListEtage}" var="etage"   >
					    
					    			<option value=${etage}>${etage}</option>
					      </c:forEach>
                              
                                
                              
                                
                              </select>
                                          </div>     
                                       
                                      </li>
                                       
                                      
                        
                                       <li>
                                        <div class="collapsible-header">
                                          <i class="material-icons">monetization_on</i>
                                          Budget (En Million)
                                          </div>
                                        <div class="collapsible-body">  
                                                   <div class="row">
                                    <div class="input-field col s6 ">
                                      <input placeholder="Min price"  name="minPrix" id="min_price" type="number" class="validate" required>
                                      <label for="min_price">Min price (En Million)</label>
                                    </div>
                                    <div class="input-field col s6 ">
                                      <input placeholder="Max price" name="maxPrix" id="max_price" type="number" class="validate" required>
                                      <label for="max_price">Max price (En Million)</label>
                                    </div>
                                  </div>
                                                 
                                                 </div>
                                      </li>
                                          
                                      
                              
                                     
                                 
                                    </ul>
                                   <button class="btn waves-effect waves-light" type="submit" name="action">Rechercher
                                    <i class="material-icons right">search</i>
                                   </button>
                                    </form>
                                </div>
</br>
</br>
</br>
	<div class="container col s12">
										<div style="overflow-y: scroll;auto; height:950px;">
										
										<div class="row">
					    <div class="col s12 m6">
   										<c:forEach items="${ListAppart}" var="Appart"   >
					      <div class="card">
					        <div class="card-image">
					          <img src=${Appart.getImages().get(0)}>
					          <span class="card-title">le Type D'appartement ${Appart.getType()}</span>
					          <a href="/AgenceImmobiliere/DetailsAppart?id=${Appart.getIdAppart()}" class="btn-floating halfway-fab waves-effect waves-light red"><i class="material-icons">add</i></a>
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
  <script src="Matrelize/js/materialize.js"></script>
  <script src="Matrelize/js/init.js"></script>

</body>
</html>                
    