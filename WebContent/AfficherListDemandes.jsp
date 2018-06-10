<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Model.Client"%>
    <%@page import="Model.Employe"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="Model.Fonctions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Espace Admin</title>
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
                <a class="navbar-brand" href="/AgenceImmobiliere/EspaceAdmin.jsp"> Espace Admin<!-- <img src="images/logo.png" alt="Logo"> --></a>
                <a class="navbar-brand hidden" href="./"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="/AgenceImmobiliere/EspaceAdmin.jsp"> <i class="menu-icon fa fa-dashboard"></i>Accueil </a>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-table"></i>Inscriptions</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="/AgenceImmobiliere/AfficherListDemandes.jsp">valider</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-th"></i>Logements</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-th"></i><a href="/AgenceImmobiliere/ControleAppartement?what=add">Ajouter un logement</a></li>
                            <li><i class="menu-icon fa fa-th"></i><a href="/AgenceImmobiliere/ControleAppartement?what=mod">Modifier un logement</a></li>
                        </ul>
                    </li>


                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Localitées</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="/AgenceImmobiliere/ControleLocalite?what=add">Ajouter une localité</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="/AgenceImmobiliere/ControleLocalite?what=mod">Modifier une localité</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Regions</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="/AgenceImmobiliere/ControleRegion?what=add">Ajouter une region</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="/AgenceImmobiliere/ControleRegion?what=mod">Modifier une region</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-tasks"></i>Batiments</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-fort-awesome"></i><a href="/AgenceImmobiliere/ControleBatiment?what=add">Ajouter un batiment</a></li>
                            <li><i class="menu-icon ti-themify-logo"></i><a href="/AgenceImmobiliere/ControleBatiment?what=mod">Modifier un batiment</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-bar-chart"></i>Clients</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-line-chart"></i><a href="/AgenceImmobiliere/ControleClient?what=block">Bloquer</a></li>
                            <li><i class="menu-icon fa fa-area-chart"></i><a href="/AgenceImmobiliere/ControleClient?what=cons">Consulter profile</a></li>
                        </ul>
                    </li>

                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-area-chart"></i>Employés</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-street-view"></i><a href="/AgenceImmobiliere/ControleAgent">Affecter des agents</a></li>
                        </ul>
                    </li>
                    <li class="menu-item-has-children dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-glass"></i>Statistiques</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="menu-icon fa fa-sign-in"></i><a href="/AgenceImmobiliere/Statistiques">Statistiques des visites</a></li>
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

                    

                </div>
            </div>

        </header><!-- /header -->
        <!-- Header-->

        <div class="breadcrumbs">
            <div class="col-sm-4">
                <div class="page-header float-left">
                    <div class="page-title">
                        <h1>Valider les inscriptions</h1>
                    </div>
                </div>
            </div>
            <div class="col-sm-8">
                <div class="page-header float-right">
                    <div class="page-title">
                        <ol class="breadcrumb text-right">
                            <li><a href="/AgenceImmobiliere/EspaceAdmin.jsp">Accueil</a></li>
                            <li><a href="#">Inscriptions</a></li>
                            <li class="active">Valider</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>

        <div class="content mt-3">
            <div class="animated">
				<div class="row">
		<%
			ArrayList<Client> allC = Fonctions.RecupererListClient();
			ArrayList<Employe> allO = Fonctions.RecupererListOperateur();
			ArrayList<Employe> allA= Fonctions.RecupererListAgent();
		%>
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Postulants pour le poste d'Operateur</strong>
                        </div>
                        	<div class="card-body">
			                <table id="bootstrap-data-table" class="table table-striped table-bordered">
			                <thead>
									<tr>
										<th>Nom</th>
										<th>Prenom</th>
										<th>Email</th>
									</tr>
							</thead>
			                <%for(int i=0 ; i<allO.size() ; i++){ %>
							<tbody>
							<tr>
							<td><%= allO.get(i).getNom()%></td>
							<td><%= allO.get(i).getPrenom()%></td>
							<td><%= allO.get(i).getMail()%></td>
							<td><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#O<%=i%>">click here</button></td>
							</tr>
								<div class="modal fade" id="O<%=i%>" >
							      <div class="modal-dialog">
							        <div class="modal-content" style="z-index:1;">
							          <div class="modal-header">
							
							          </div>
							          <div class="modal-body">
							            <h3>Nom :<%=allO.get(i).getNom()%> </h3>
							            <h3>Prenom :<%=allO.get(i).getPrenom()%></h3>
							            <h3>Mobile :<%=allO.get(i).getNumtel()%></h3>
							            <h3>Email :<%=allO.get(i).getMail()%></h3>
							            <h3>Adresse :<%=allO.get(i).getAdresse()%></h3>
							            <h3>Sexe :<%=allO.get(i).getSexe()%></h3>
							            <h3>Date de naissance :<%=allO.get(i).getDatenais()%></h3>
							          </div>
							          <div class="modal-footer">
							             <button class="btn btn-default" data-dismiss="modal">Fermer</button>
							             <form action="/AgenceImmobiliere/validation" method="post">
							             <input type="hidden" name="TypeVal" value="Operateur">
							             <input type="hidden" name="IDO" value="<%=allO.get(i).getIdemp()%>">
							             <button class="btn btn-secondary" type="submit" name="valid" value="oui">Accepter</button>
							             <button class="btn btn-secondary" type="submit" name="valid" value="non">Décliner</button>
							             </form>
							          </div>
							        </div>
							      </div>
							    </div>
							<%
								}
							%>
							</tbody>
							</table>

       						</div>
     			 	</div>
				</div>
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Postulants pour le poste d'Agent</strong>
                        </div>
                        	<div class="card-body">
			                <table id="bootstrap-data-table" class="table table-striped table-bordered">
			                <thead>
									<tr>
										<th>Nom</th>
										<th>Prenom</th>
										<th>Email</th>
									</tr>
							</thead>
			                <%for(int i=0 ; i<allA.size() ; i++){ %>
							<tbody>
							<tr>
							<td><%= allA.get(i).getNom()%></td>
							<td><%= allA.get(i).getPrenom()%></td>
							<td><%= allA.get(i).getMail()%></td>
							<td><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#A<%=i%>">click here</button></td>
							</tr>
							<div class="modal fade" id="A<%=i%>" >
							      <div class="modal-dialog">
							        <div class="modal-content" style="z-index:1;">
							          <div class="modal-header">
							
							          </div>
							          <div class="modal-body">
							            <h3>Nom :<%=allA.get(i).getNom()%> </h3>
							            <h3>Prenom :<%=allA.get(i).getPrenom()%></h3>
							            <h3>Mobile :<%=allA.get(i).getNumtel()%></h3>
							            <h3>Email :<%=allA.get(i).getMail()%></h3>
							            <h3>Adresse :<%=allA.get(i).getAdresse()%></h3>
							            <h3>Sexe :<%=allA.get(i).getSexe()%></h3>
							            <h3>Date de naissance :<%=allA.get(i).getDatenais()%></h3>
							          </div>
							          <div class="modal-footer">
							             <button class="btn btn-default" data-dismiss="modal">Fermer</button>
							             <form action="/AgenceImmobiliere/validation" method="post">
							             <input type="hidden" name="TypeVal" value="Agent">
							             <input type="hidden" name="IDA" value="<%=allA.get(i).getIdemp()%>">
							             <button class="btn btn-secondary" type="submit" name="valid" value="oui">Accepter</button>
							             <button class="btn btn-secondary" type="submit" name="valid" value="non">Décliner</button>
							             </form>
							          </div>
							        </div>
							      </div>
							    </div>
							<%
								}
							%>
							</tbody>
							</table>
       						</div>
     			 </div>
			</div>
			<div class="col-md-12">
                    <div class="card">
                        <div class="card-header">
                            <strong class="card-title">Demandes d'inscription en tant que client</strong>
                        </div>
                        	<div class="card-body">
			                <table id="bootstrap-data-table" class="table table-striped table-bordered">
			                <thead>
									<tr>
										<th>Nom</th>
										<th>Prenom</th>
										<th>Email</th>
									</tr>
							</thead>
			                <%for(int i=0 ; i<allC.size() ; i++){ %>
							<tbody>
							<tr>
							<td><%= allC.get(i).getNom()%></td>
							<td><%= allC.get(i).getPrenom()%></td>
							<td><%= allC.get(i).getMail()%></td>
							<td><button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#C<%=i%>">click here</button></td>
							</tr>
							<div class="modal fade" id="C<%=i%>" >
							      <div class="modal-dialog">
							        <div class="modal-content" >
							          <div class="modal-header">
							
							          </div>
							          <div class="modal-body">
							            <h3>Nom :<%=allC.get(i).getNom()%> </h3>
							            <h3>Prenom :<%=allC.get(i).getPrenom()%></h3>
							            <h3>Mobile :<%=allC.get(i).getNumtel()%></h3>
							            <h3>Email :<%=allC.get(i).getMail()%></h3>
							            <h3>Adresse :<%=allC.get(i).getAdresse()%></h3>
							            <h3>Sexe :<%=allC.get(i).getSexe()%></h3>
							            <h3>Date de naissance :<%=allC.get(i).getDatenais()%></h3>
							          </div>
							          <div class="modal-footer">
							             <button class="btn btn-default" data-dismiss="modal">Fermer</button>
							             <form action="/AgenceImmobiliere/validation" method="post">
							             <input type="hidden" name="TypeVal" value="Client">
							             <input type="hidden" name="IDC" value="<%=allC.get(i).getIdc()%>">
							             <button class="btn btn-secondary" type="submit" name="valid" value="oui">Accepter</button>
							             <button class="btn btn-secondary" type="submit" name="valid" value="non">Décliner</button>
							             </form>
							          </div>
							        </div>
							      </div>
							    </div>
							<%
								}
							%>
							</tbody>
							</table>
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


</body>
</html>
