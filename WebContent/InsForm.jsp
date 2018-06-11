<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Inscription</title>
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
                        <img class="align-content" src="" alt="">
                    </a>
                </div>
                <div class="login-form">
                    <form action="/AgenceImmobiliere/SignupServlet" method="post">
                        <div class="form-group">
                            <label>Nom</label>
                            <input name="nom" type="text" class="form-control" placeholder="Nom" required>
                        </div>
                        <div class="form-group">
                            <label>Prénom</label>
                            <input name="Prenom" type="text" class="form-control" placeholder="Prenom" required>
                        </div>
                        <div class="form-group">
                                    <label class=" form-control-label">Mobile</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"><i class="fa fa-phone"></i></div>
                                        <input id="NumTel" name="NumTel" class="form-control" required>
                                    </div>
                                    <small class="form-text text-muted">ex. 0555 55 55 55</small>
                             <div id="messsage" style="color : red;display : none"></div>
                        </div>
                        <div class="form-group">
                            <label>Email address</label>
                            <input name="mail" type="email" class="form-control" placeholder="Email" required>
                        </div>
                        <div class="form-group">
                            <label>Adresse</label>
                            <input name="Adresse" type="text" class="form-control" placeholder="Adresse" required>
                        </div>
                        <div class="form-group">
                                    <label class=" form-control-label">Date de naissance</label>
                                    <div class="input-group">
                                        <div class="input-group-addon"><i class="fa fa-calendar"></i></div>
                                        <input name="datenais" type="date" class="form-control" required>
                                    </div>
                                    
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input name="Mdpss" type="password" class="form-control" placeholder="Password" required>
                        </div>
                        <div class="row form-group">
                            <div class="col col-md-3"><label for="select" class=" form-control-label">Sexe</label></div>
                            <div class="col-12 col-md-9">
                              <select name="sexe" id="select" class="form-control">
                                <option value="homme">Homme</option>
                                <option value="femme">Femme</option>
                                <option value="autre">Autre</option>
                                <option value="ne pas preciser">Ne pas préciser</option>
                              </select>
                            </div>
                          </div>
                          
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" required> Agree the terms and policy
                            </label>
                        </div>

                        <button type="submit" id="inscrire" class="btn btn-primary btn-flat m-b-30 m-t-30">ENVOYER</button>
                        
                        <div class="register-link m-t-15 text-center">
                            <p>Déja membre ? <a href="/AgenceImmobiliere/LoginServlet"> connectez vous!</a></p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>
        <!--  Chart js -->
    <!--   <script src="assets/js/lib/chart-js/chartjs-init.js"></script>-->
    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
	<script>$( "#NumTel" ).change(function() {

    	   $.ajax({url: "http://localhost:8080/AgenceImmobiliere/api?action=numclient&val="+$( "#NumTel" ).val(),
    			   success: function(result){
    				   console.log(result);
    				   if(result ==="ghalt"){//hna tgerer lgholta
    					   $( "#NumTel" ).css({'background-color': '#59CC6F'});
    					   $( "#messsage" ).html(" ")
							   document.getElementById("inscrire").disabled = false;
	    					   document.getElementById("inscrire").setAttribute('class','btn btn-primary');
							   $( "#messsage" ).css({'display': 'none'});
    					   }else{
    					   	if(result ==="bloque"){
    					   		$( "#NumTel" ).css({'background-color': '#ef5350'});
    					   		
 							   document.getElementById("inscrire").disabled = true;
 	    					   document.getElementById("inscrire").setAttribute('class','btn btn-danger');
 							   $( "#messsage" ).css({'display': 'block'});
 							  $("#messsage").append("<p>Ce client est bloqué vou ne pouvez pas luis résérver de rendez-vous.</p>");
    					   	}
    					   }	
    	    },
    	    error :  function(error){}
    	   
    	   
    	   });
    
    
    });
    </script>

</body>
</html>
