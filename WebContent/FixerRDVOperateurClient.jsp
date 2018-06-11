<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date" %>
<%@page import="java.text.DateFormat" %>
<%@page import="java.text.SimpleDateFormat" %> 
<%@page import="java.util.ArrayList" %>
	<%@page import="Model.date" %>
	<%@page import="Model.Fonctions" %>
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
                            <strong class="card-title">Dates disponibles</strong><small>     Client : <%out.println(request.getAttribute("nomClient")); %></small>
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
									    <form action="/AgenceImmobiliere/ControleRendezVous" method="post" class="post">
									    <input type="hidden" name="operation" value="dateR">
                						<input type="hidden" name="what" value="add">
									    <input type="hidden" name="date" value=<%=calendrier.get(i-1).getDate() %>>
									    <button type="submit" class="btn btn-primary" id="<%=i-1%>" name="heure" value=<%=calendrier.get(i-1).getHeur()%>><%=calendrier.get(i-1).getHeur()%></button>
									    </form>
									    </td>
									    <td>
									    <form action="/AgenceImmobiliere/ControleRendezVous" method="post" class="post">
									    <input type="hidden" name="operation" value="dateR">
                						<input type="hidden" name="what" value="add">
									    <input type="hidden" name="date" value=<%=calendrier.get(i).getDate() %>>
									    <button type="submit" class="btn btn-primary" id="<%=i%>" name="heure" value=<%=calendrier.get(i).getHeur()%>><%=calendrier.get(i).getHeur()%></button>
									    </form>
									    </td>
									    <td>
									    <form action="/AgenceImmobiliere/ControleRendezVous" method="post" class="post">
									    <input type="hidden" name="operation" value="dateR">
                						<input type="hidden" name="what" value="add">
									    <input type="hidden" name="date" value=<%=calendrier.get(i+1).getDate() %>>
									    <button type="submit" class="btn btn-primary" id="<%=i+1%>" name="heure" value=<%=calendrier.get(i+1).getHeur()%>><%=calendrier.get(i+1).getHeur()%></button>
									    </form>
									    </td>
									    <td>
									    <form action="/AgenceImmobiliere/ControleRendezVous" method="post" class="post">
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
        </div><!-- .content -->


    </div><!-- /#right-panel -->

    <!-- Right Panel -->


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

</body>
</html>
