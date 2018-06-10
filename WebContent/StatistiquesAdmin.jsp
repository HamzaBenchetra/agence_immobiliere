<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="Model.StatsAgent"%>
    <%@page import="Model.StatsType"%>
    <%@page import="Model.StatsLocalite"%>
    <%@page import="java.util.ArrayList"%>
	<%@page import="Model.OperationsRESP" %>
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
                        <h1>Acceuil</h1>
                    </div>
                </div>
            </div>
        </div>
		<div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">
                        <form action="/AgenceImmobiliere/StatsExcel" method="get">
                        	<input type="hidden" name="TypeI" value="Excel">
                        	<button type="submit" class="btn btn-primary">Exporter en excel</button>
                        </form>
				</div>

            </div><!-- .animated -->
        </div>
        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="mb-3">Nombre de visites par agent </h4>
                                    <canvas id="myChart" width="200" height="200"></canvas>
                                </div>
                            </div>
                        </div><!-- /# column -->
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="mb-3">Nombre de visites par localite </h4>
                                    <canvas id="myChart1" width="200" height="200"></canvas>
                                </div>
                            </div>
                        </div>
				</div>

            </div><!-- .animated -->
        </div><!-- .content -->
        
        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="mb-3">Nombre de visites par type d'appartement </h4>
                                    <canvas id="myChart2" width="200" height="200"></canvas>
                                </div>
                            </div>
                        </div><!-- /# column -->
                        <div class="col-lg-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="mb-3">Ratio des ventes </h4>
                                    <canvas id="myDoughnutChart " width="100" height="100"></canvas>
                                </div>
                            </div>
                        </div>
				</div>

            </div><!-- .animated -->
        </div>
        <!-- .content -->


    </div><!-- /#right-panel -->

    <!-- Right Panel -->

	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.bundle.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js"></script>
    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
        <!--  Chart js -->
    <script src="assets/js/lib/chart-js/Chart.bundle.js"></script>
    <script src="assets/js/lib/chart-js/chartjs-init.js"></script>
    <%ArrayList<StatsAgent> LA=(ArrayList<StatsAgent>)request.getAttribute("ListA"); %>
    <%ArrayList<StatsLocalite> LL=(ArrayList<StatsLocalite>)request.getAttribute("ListL"); %>
	<%ArrayList<StatsType> LT=(ArrayList<StatsType>)request.getAttribute("ListT"); %>
	 
	<script>
		var ctx = document.getElementById("myChart").getContext('2d');
		var myChart = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: [<%for(StatsAgent s: LA) {%><%="\""+s.getNom()+" "+s.getPrenom()+"\","%><%}%>],
		        datasets: [{
		            label: '# de visites',
		            data: [<%for(StatsAgent s: LA) {%><%=s.getCountA()+","%><%}%>],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)',
		                'rgba(75, 192, 192, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)',
		                'rgba(75, 192, 192, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
	</script>
	<% float R=(float)request.getAttribute("Ratio");%>
	<script>
	var ctx = document.getElementById("myDoughnutChart").getContext('2d');

	var myDoughnutChart = new Chart(ctx, {
	    type: 'pie',
	    data:  {
	    	    datasets: [{
	    	        data: [<%=R*100%>,<%=(100-(R*100))%>]
	    	    }],

	    	    // These labels appear in the legend and in the tooltips when hovering different arcs
	    	    labels: [<%="\""+R+"\""%>,
	    	       ' '
	    	    ]
	    	},
	});
	</script>
	<script>
		var ctx = document.getElementById("myChart1").getContext('2d');
		var myChart1 = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: [<%for(StatsLocalite s: LL) {%><%="\""+s.getNomLocalite()+"\","%><%}%>],
		        datasets: [{
		            label: '# de visites',
		            data: [<%for(StatsLocalite s: LL) {%><%=s.getCountL()+","%><%}%>],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
	</script>
	
	<script>
		var ctx = document.getElementById("myChart2").getContext('2d');
		var myChart2 = new Chart(ctx, {
		    type: 'bar',
		    data: {
		        labels: [<%for(StatsType s: LT) {%><%="\""+s.getType()+"\","%><%}%>],
		        datasets: [{
		            label: '# de visites',
		            data: [<%for(StatsType s: LT) {%><%=s.getCountT()+","%><%}%>],
		            backgroundColor: [
		                'rgba(255, 99, 132, 0.2)',
		                'rgba(54, 162, 235, 0.2)',
		                'rgba(255, 206, 86, 0.2)'
		            ],
		            borderColor: [
		                'rgba(255,99,132,1)',
		                'rgba(54, 162, 235, 1)',
		                'rgba(255, 206, 86, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		        scales: {
		            yAxes: [{
		                ticks: {
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
	</script>
	
</body>
</html>
