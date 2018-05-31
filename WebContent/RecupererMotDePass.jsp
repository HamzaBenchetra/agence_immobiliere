<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
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
<body class="bg-dark">


    <div class="sufee-login d-flex align-content-center flex-wrap">
        <div class="container">
            <div class="login-content">
                <div class="login-logo">
                    <a href="index.html">
                        <img class="align-content" src="images/logo.png" alt="">
                    </a>
                </div>
                <%int e=(int)request.getAttribute("C"); %>
                	<%if(e==-1){ %>
                	<h4 style="color: red;">E mail innexistant</h4>
                
                <div class="login-form">
                    <form action="http://192.168.43.108:8080/AgenceImmobiliere/RecupererM" method="post" >
                        <div class="form-group">
                            <label>Email de récuperation</label>
                            <input name="mail" type="email" class="form-control" placeholder="Email">
                        </div>
                        <button type="submit" class="btn btn-primary btn-flat m-b-15">Envoyer Code</button>

                    </form>
                </div>
                <%} %>
               
                <%e=(int)request.getAttribute("C"); %>
                	<%if((e!=0)&&(e!=(-1))){ %>
                	<h4 style="color: red;">Un code vous a été envoyé </h4>
                <div class="login-form">
                    <form action="http://192.168.43.108:8080/AgenceImmobiliere/RecupererM" method="post" >
                        <div class="form-group">
                            
                            <label>Code de récuperation</label>
                            <!--  <input name="code" type="text" class="form-control" placeholder="code de recuperation">-->
                            <input type="text" class="form-control" id="code" data-match="<%=request.getAttribute("C") %>" data-match-error="Code erroné" placeholder="Code de confirmation" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-flat m-b-15">Soumettre</button>

                    </form>
                </div>
                <%} %>
               
                <%e=(int)request.getAttribute("C"); %>
                	<%if(e==0){ %>
                	
                <div class="login-form">
                    <form action="http://192.168.43.108:8080/AgenceImmobiliere/RecupererM" method="post" >
                        <div class="form-group">
                            <label>Email de récuperation</label>
                            <input name="mail" type="email" class="form-control" placeholder="Email">
                        </div>
                        <button type="submit" class="btn btn-primary btn-flat m-b-15">Envoyer Code</button>

                    </form>
                </div>
                <%} %>
            
            
            </div>
        </div>
    </div>


    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>


</body>
</html>
