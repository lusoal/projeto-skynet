<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
								<script type="text/javascript" src="../vendor/js/validacoes.js"></script>
								<script type="text/javascript" src="../vendor/jqueryplugin/dist/jquery.mask.min.js"></script>
								<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.13.0/moment.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/locale/pt-br.js"></script>
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
										<% if(session.getAttribute("documento") != null){ %>
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
																data-toggle="dropdown" href="#"><strong>Ja Realizei o
																Pre-Cadastro</strong> <span class="caret"></span></a>
																<ul class="dropdown-menu">
																	<form class="form-signin" action="RealizarLogin" method="post">

																		<h6 class="form-signin-heading" align="center">Insira seu
																			Documento</h6>

																			<label for="inputEmail" class="sr-only"> Digite seu CPF
																			</label>

																			<input type="text" name="documento" id="cpfcnpj" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />

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
																						</label>
																						<input type="text" name="documento" id="cpfcnpj2" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />
																						<label
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
																					<form action="${pageContext.request.contextPath}/CadastroController.do" method="post">
																						<div id="color_23">

																							<div class="row">
																								<br>
																									<div class="form-group col-md-4">
																										<label for="name">Nome / Razao Social</label> <input  readonly type="text"
																										class="form-control" name="nome" value="<%= publico.getNome() %>">
																									</div>
																									<div class="form-group col-md-3">
																										<label for="name">Email</label> <input readonly type="text"
																										class="form-control" name="email" value="<%= publico.getEmail() %>" >
																									</div>
																									<div class="form-group col-md-3">
																										<label for="campo2">CNPJ / CPF</label> <input  readonly type="text"
																										class="form-control" value="<%= publico.getDocumento() %>" name="documento">
																									</div>
																									<div class="form-group col-md-2">
																										<label for="campo3">Tipo</label> <input readonly type="text"
																										class="form-control" value="<%= publico.getTipo() %>" name="tipo">
																									</div>
																								</div>

																								<div class="row">
																									<div class="form-group col-md-8">
																										<label for="campo1">Endereco</label> <input type="text"
																										class="form-control" name="endereco" required>
																									</div>
																									<div class="form-group col-md-2">
																										<label for="campo2">Telefone</label> <input type="text" id="phone"
																										class="form-control" name="telefone_fixo" required>
																									</div>
																									<div class="form-group col-md-2">
																										<label for="campo3">Celular</label> <input type="text" id="cellphone"
																										class="form-control" name="telefone_celular" required>
																									</div>

																								</div>

																								<div class="row">
																									<div class="form-group col-md-3">
																										<label for="campo1">Documento Contato Principal</label> <input type="text" placeholder="Digite o CPF do contato Principal" id"cpfcnpj3"
																										class="form-control" name="cont_doc" required>
																									</div>
																									<div class="form-group col-md-5">
																										<label for="campo1">Nome Contato Principal</label> <input type="text"
																										class="form-control" name="cont_nome" required>
																									</div>
																									<div class="form-group col-md-4">
																										<label for="campo2">E-mail contato Principal </label> <input type="text"
																										class="form-control" name="cont_email" required>
																									</div>
																								</div>

																								<div class= "row">
																									<div class="form-group col-md-6">

																										<label for="campo3">Site</label> <input type="text"
																										class="form-control" name="site" required>
																									</div>


																									<div class="form-group col-md-3">
																										<label for="campo3">Data Abertura</label> <input type="text" class="form-control"
																										name="data" id="date" required>
																									</div>
																									<div class="form-group col-md-3">
																										<label for="campo3">Senha</label> <input type="password" class="form-control" name="senha" id="senha" required>
																									</div>
																								</div>
																								<div id="actions" class="row">
																									<div class="col-sm-6">
																										<button type="submit" name="acao" value="cadastrarUsuario" class="btn btn-primary">Salvar</button>
																										<button type="submit" name="acao" value="cancelarCadastro" class="btn btn-default">Cancelar</button>
																									</div>
																								</div>
																							</div>
																						</form>
																					</div>
																					<%} %>
																				</body>

																			</html>
