<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Model.Localite"%>
    <%@page import="Model.Region"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="Model.Fonctions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sufee Admin - HTML5 Admin Template</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

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

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

    <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->

</head>

<body>
        <!-- Left Panel -->

          <!-- Left Panel -->

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="/AgenceImmobiliere/Operateur.jsp"> Espace Operateur<!-- <img src="images/logo.png" alt="Logo"> --></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="/AgenceImmobiliere/Operateur.jsp"> <i class="menu-icon fa fa-dashboard"></i>Accueil </a>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-laptop"></i>Rendez-Vous</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-puzzle-piece"></i><a href="/AgenceImmobiliere/ControleRendezVous?what=add&operation=form">Fixer</a></li>
                 
                            
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Acheter</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="/AgenceImmobiliere/ChercherClientAchat.jsp">Demander Achat</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Consulter Liste rendez-vous</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="/AgenceImmobiliere/ConsulterRDVOP">Consulter Liste rendez-vous</a></li>
                        </ul>
                    </li>


                    
                    
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->

    <!-- Left Panel -->

    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <header id="header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        

                        

                        
                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="user-area dropdown float-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                        </a>

                        <div class="user-menu dropdown-menu">
                                

                                <a class="nav-link" href="/AgenceImmobiliere/LogoutServlet"><i class="fa fa-power -off"></i>Logout</a>
                        </div>
                    </div>

                    

                </div>
            </div>

        </header>

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Fixer un Rendez-vous</h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="page-header float-right">
                    <div class="page-title">
                        <ol class="breadcrumb text-right">
                            <li><a href="/AgenceImmobiliere/Operateur.jsp">Accueil</a></li>
                            <li><a href="#">Rendez-vous</a></li>
                            <li class="active">Fixer</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
		<div class="sufee-alert alert with-close alert-primary alert-dismissible fade show" id="msg" style="display : none">
            <span class="badge badge-pill badge-primary">Succès</span>
               Rendez-Vous fixé avec succès.
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
               <span aria-hidden="true">×</span>
            </button>
        </div>
        <div class="content mt-3">
            <div class="animated fadeIn">


                <div class="row">
                  

                  

                  <div class="col-lg-12">
                    <div class="card">
                      <div class="card-header">
                        <strong>Rechercher un appartement</strong> par criteres
                      </div>
                      <div class="card-body card-block">
                        <form action="/AgenceImmobiliere/ControleRendezVous" method="post" class="form-horizontal">
                          <%ArrayList<Localite> l=Fonctions.ListeLocalitees(); %>
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="localite" class=" form-control-label">Localite</label></div>
                            <div class="col-12 col-md-9">
                              <select name="localite" id="localite" class="form-control">
                                <option value="0">Choisir une localite</option>
                                <%for(Localite L : l){ %> 
                                <option value="<%=L.getIdLocalite()%>"><%=L.getNomLocalite() %></option>
                                <%} %>
                              </select>
                            </div>
                          </div>
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="region" class=" form-control-label">Region</label></div>
                            <div class="col-12 col-md-9">
                              <select name="region" id="region" class="form-control">
                                <option value="0">Choisir une region</option>
                              </select>
                            </div>
                          </div>
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="select" class=" form-control-label">Etage</label></div>
                            <div class="col-12 col-md-9">
                              <select name="etage" id="select" class="form-control">
                                <option value="0">Etage</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8">8</option>
                                <option value="9">9</option>
                                <option value="10">10</option>
                                <option value="11">11</option>
                                <option value="12">12</option>
                                <option value="13">13</option>
                                <option value="14">14</option>
                                <option value="15">15</option>
                                <option value="16">16</option>
                                
                              </select>
                            </div>
                          </div>
                          <div class="row form-group">
                            <div class="col col-md-3"><label for="select" class=" form-control-label">Type</label></div>
                            <div class="col-12 col-md-9">
                              <select name="type" id="select" class="form-control">
                                <option value="0">Type d'appartement que vous cherchez</option>
                                <option value="F3">F3</option>
                                <option value="F4">F4</option>
                                <option value="F5">F5</option>
                              </select>
                            </div>
                          </div>
                          <div class="form-group">
                          <label for="prixMax" class=" form-control-label">prix maximum</label>
                          <input type="text" id="prixMax" name="prixMax" placeholder="En DA" class="form-control">
                          </div>
                          <div>
                          <label for="prixMin" class=" form-control-label">prix minimum</label>
                          <input type="text" id="prixMin" name="prixMin" placeholder="En DA" class="form-control">
                          </div>
                         <input type="hidden" name="operation" value="infos">
                         <input type="hidden" name="what" value="add">
                        <button type="submit" class="btn btn-primary btn-sm">
                          <i class="fa fa-dot-circle-o"></i> Submit
                        </button>
                        
                        </form>
                      </div>
                      
                    </div>
                    
                  </div>

                  

                </div>


            </div><!-- .animated -->
        </div><!-- .content -->


    </div><!-- /#right-panel -->

    <!-- Right Panel -->


    
    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
        <!--  Chart js -->

	<script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script>$( "#localite" ).change(function() {
    	
    	   $.ajax({url: "http://localhost:8080/AgenceImmobiliere/api?action=idLocalite&val="+$( "#localite" ).val(),
    			   success: function(result){
    				   var Region = JSON.parse(result);
    				   
    				   $('#region').html(" ")
    					for(i=0;i<Region.length;i++){
    						$('#region').append("<option value = \""+Region[i].idRegion+"\">"+Region[i].nomRegion+"</option>");
    						
    					}
    					
    				
    	    },
    	    error :  function(error){}
    	   
    	   
    	   });
    
    
    });
    var m='<%= request.getAttribute("msg")%>';
    console.log(m);
    if(m=="OK"){
    	 $( "#msg" ).css({'display': 'block'});
    }
    
</script>

</body>
</html>
