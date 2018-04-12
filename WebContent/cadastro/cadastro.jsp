<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Publico" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="../img/skynet_t_shirt_textual_tees.png"
	type="image/x-png" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="../vendor/simple-line-icons/css/simple-line-icons.css">
<link href="../css/one-page-wonder.css" rel="stylesheet">


<title>SkyNetProject</title>


</head>

<body style="background:#DDDEDE;">
<%String documento =(String)session.getAttribute("documento"); %>

<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../index.html");
}%>
<%Publico publico =(Publico)session.getAttribute("publico"); %>
	<!--    <div id="div3" style="width:80px;height:80px;display:none;background-color:blue;"></div>-->
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		style="background-color: white;">
		<div class="container">
			<a class="navbar-brand" href="../index.html" ><img
				src="../img/navbar1.jpg" width=80% height=40%
				style="float: left; margin-left: 0%"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link"
						href="../index.html"> <span class="sr-only">(current)</span>
					</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><strong>Ja¡ Realizei o
								Pre-Cadastro</strong> <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<form class="form-signin" action="RealizarLogin" method="post">

								<h6 class="form-signin-heading" align="center">Insira seu
									Documento</h6>

								<label for="inputEmail" class="sr-only"> Digite seu CPF
								</label> <input name="documento" class="form-control"
									placeholder="Digite seu CPF" required autofocus>

								<button class="btn btn-sm btn btn-success btn-block"
									type="submit">Entrar</button>

							</form>

						</ul></li>
					<li class="nav-item"><a class="nav-link" href=""></a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"><b>Login</b><span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<form class="form-signin" action="RealizarLogin" method="post">

								<h6 class="form-signin-heading" align="center">Realize seu
									Login</h6>

								<label for="inputEmail" class="sr-only"> Digite seu CPF
								</label> <input name="documento" class="form-control"
									placeholder="Digite seu CPF" required autofocus> <label
									for="inputPassword" class="sr-only">Digite sua Senha</label> <input
									type="password" name="senha" class="form-control"
									placeholder="Digite sua senha" required>

								<button class="btn btn-sm btn btn-success btn-block"
									type="submit">Entrar</button>

							</form>

						</ul>
                    </li>
				</ul>
			</div>
		</div>
	</nav>
    
    
    
    <br>
    <br>
    <br>
    
    <h1>Cadastro</h1>
    
    <div class ="containder-fluid">
    <div id="color_23">
        
    <div class="row">
        <br>
	<div class="form-group col-md-7">
        
		<label for="name">Nome / Razao Social</label> <input type="text"
			class="form-control" name="nome" value="<%= publico.getNome() %>" disabled>
	</div>
	<div class="form-group col-md-3">
		<label for="campo2">CNPJ / CPF</label> <input type="text"
			class="form-control" value="<%= publico.getDocumento() %>" name="documento" disabled>
	</div>
	<div class="form-group col-md-2">
		<label for="campo3">Tipo</label> <input type="text"
			class="form-control" value="<%= publico.getTipo() %>" name="tipo" disabled>
	</div>
</div>
        
<div class="row">
	<div class="form-group col-md-8">
		<label for="campo1">Endereco</label> <input type="text"
			class="form-control" name="customer['address']">
	</div>
	<div class="form-group col-md-2">
		<label for="campo2">Telefone</label> <input type="text"
			class="form-control" name="customer['hood']">
	</div>
	<div class="form-group col-md-2">
		<label for="campo3">Celular</label> <input type="text"
			class="form-control" name="customer['celular']">
    </div>
        
        </div>
        
<div class="row">
	<div class="form-group col-md-7">
		<label for="campo1">Nome Contato Principal</label> <input type="text"
			class="form-control" name="customer['city']">
	</div>
	<div class="form-group col-md-5">
		<label for="campo2">E-mail contato Principal </label> <input type="text"
			class="form-control" name="customer['phone']">
	</div>
    </div>
        
    <div class= "row">
        <div class="form-group col-md-6">
            
		<label for="campo3">Site</label> <input type="text"
			class="form-control" name="customer['mobile']">
	</div>
         
        
	<div class="form-group col-md-3">
		<label for="campo3">Data Abertura</label> <input type="text" class="form-control"
			name="customer['state']">
	</div>
	<div class="form-group col-md-3">
		<label for="campo3">Senha</label> <input type="text"
			class="form-control" name="customer['ie']">
	</div>
	</div>

        
        
        
<div id="actions" class="row">
    
	<div class="col-md-12">
		<button type="submit" class="btn btn-primary">Salvar</button>
		
		<form action="${pageContext.request.contextPath}/Logout" method="post">
			<button type="submit" class="btn btn-default">Cancelar</button>
		</form>
	</div>
</div>
        </div>
       </div>
 
    </body>
     
</html>
            
                
                
                
                
                
                
                
                