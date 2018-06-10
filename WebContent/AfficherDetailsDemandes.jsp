<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Model.Appartement"%>
    <%@page import="Model.Client"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Responsable des ventes</title>
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

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu" aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="/AgenceImmobiliere/responsabledesventes.jsp"> Espace Responsable des ventes<!-- <img src="images/logo.png" alt="Logo"> --></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="/AgenceImmobiliere/responsabledesventes.jsp"> <i class="menu-icon fa fa-dashboard"></i>Accueil </a>
                    </li>
                    
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Achat</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="/AgenceImmobiliere/DemandesAchat">Demandes d'achat</a></li>
                        </ul>
                    </li>
				<li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Statistiques</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="/AgenceImmobiliere/Statistiques">Statistiques</a></li>
                            
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

                

                <div class="col-sm-5">
                    <div class="user-area dropdown float-right">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img class="user-avatar rounded-circle" src="images/admin.jpg" alt="User Avatar">
                        </a>

                        <div class="user-menu dropdown-menu">
                                

                                <a class="nav-link" href="/AgenceImmobiliere/LogoutServlet"><i class="fa fa-power -off"></i>Logout</a>
                        </div>
                    </div>

                    <div class="language-select dropdown" id="language-select">
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown"  id="language" aria-haspopup="true" aria-expanded="true">
                            <i class="flag-icon flag-icon-us"></i>
                        </a>
                       
                    </div>

                </div>
            </div>

        </header><!-- /header -->
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Acceuil</h1>
                    </div>
                </div>
            </div>
        </div>
	<%
	HttpSession s=request.getSession(true);
	Client Client=(Client)s.getAttribute("C");
	Appartement Appartement=(Appartement)request.getAttribute("A");
	%>
	<div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">
              <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Detail du Client </strong>
                        </div>
                        <div class="card-body">
                  <table id="bootstrap-data-table" class="table table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>ID Client</th>
                        <th>Nom Client</th>
                        <th>Prenom Client</th>
                        <th>Numero telephone</th>
                        <th>Adresse</th>
                        <th>Date de nais</th>
                        <th>Email</th>
                        <th>sexe</th>
                        
                      </tr>
                    </thead>
				<tbody>
				<tr>				
				<td><%=Client.getIdc()%></td>
				<td><%=Client.getNom() %></td>
				<td><%=Client.getPrenom() %></td>
				<td><%=Client.getNumtel() %></td>
				<td><%=Client.getAdresse() %></td>
				<td><%= Client.getDatenais()%></td>
				<td><%= Client.getMail()%></td>
				<td><%= Client.getSexe()%></td>
				
				
			
				</tr>
				
                </tbody>
                  </table>
                        </div>
                    </div>
                </div>


                </div>
            </div><!-- .animated -->
        </div><!-- .content -->
        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Detail l'appartement </strong>
                        </div>
                        <div class="card-body">
                  <table id="bootstrap-data-table" class="table table-striped table-bordered">
                    <thead>
                      <tr>
                        <th>ID de l'Appart</th>
                        <th>ID du batiment</th>
                        <th>Prix</th>
                        <th>Etage</th>
                          <th>Type</th>
                      </tr>
                    </thead>
				<tbody>
				<tr>				
				<td><%=Appartement.getIdAppart() %></td>
				<td><%=Appartement.getIdBatiment() %></td>
				<td><%=(int)Appartement.getPrix() %></td>
				<td><%= Appartement.getEtage()%></td>
				<td><%= Appartement.getType()%></td>
				
				
				</tr>
				
                </tbody>
                  </table>
                        </div>
                    </div>
                </div>


                </div>
                <form   action="/AgenceImmobiliere/EtablirContrat"  method = "post">
				<input type="hidden" name="IDC" value=<%=Client.getIdc()%>>
				<input type="hidden" name="IDA" value=<%=Appartement.getIdAppart()%>>
		  		<input type=submit  value="EtablirContrat"/>
				</form>
            </div><!-- .animated -->
        </div><!-- .content -->
    </div><!-- /#right-panel -->

    <!-- Right Panel -->
	

    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
        <!--  Chart js -->
    <script src="assets/js/lib/chart-js/Chart.bundle.js"></script>
    <script src="assets/js/lib/chart-js/chartjs-init.js"></script>

</body>
</html>
