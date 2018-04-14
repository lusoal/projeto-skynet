<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="model.Publico" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<link rel="shortcut icon"
	href="../../img/skynet_t_shirt_textual_tees.png" type="image/x-png" />
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
	href="../../vendor/simple-line-icons/css/simple-line-icons.css">
<link href="../../css/one-page-wonder.css" rel="stylesheet">


<title>SkyNetProject</title>


</head>
<body style="background: white;">
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		style="background: white;">
		<div class="container">
			<a class="navbar-brand" href="../../index.html"><img
				src="../../img/navbar1.jpg" width=80% height=40%
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
					<form action="${pageContext.request.contextPath}/Logout" method="post">
                    <button type="submit" class="btn btn-info">Sair</button>
					</form>
				</ul>
			</div>
		</div>

	</nav>
	<br>
	<br>
	<br>
	<br>

	<div class="row">
		<div class="col-md-2" style="background-color: aliceblue">

			<div class="nav flex-column nav-pills" id="v-pills-tab"
				role="tablist" aria-orientation="vertical">
				<a class="nav-link active" id="v-pills-home-tab" data-toggle="pill"
				href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">Solicitacoes</a> <a class="nav-link"
					id="v-pills-settings-tab" data-toggle="pill"
					href="#v-pills-settings" role="tab"
					aria-controls="v-pills-settings" aria-selected="false">Termos
					Empresa</a> <a class="nav-link" id="v-pills-TERMS-tab"
					data-toggle="pill" href="#v-TERMS-settings" role="tab"
					aria-controls="v-TERMS-settings" aria-selected="false">Termos
					Cartorio</a>
			</div>
		</div>
		<div class="col-md-10">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active" id="v-pills-home"
					role="tabpanel" aria-labelledby="v-pills-home-tab">
					<div class="container">

						<table class="table table-hover">
							<thead>
								<tr>
									<th>Tipo</th>
									<th>CNPJ</th>
									<th>Razao social</th>
									<th>Status</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="publico" items="${arrayPublico}">
								<form action="${pageContext.request.contextPath}/AlterarPublico" method="post">
									<tr>
									<td><input type="text" name="tipo" value="${publico.tipo}"readonly></td>
									<td><input type="text" name="documento" value="${publico.documento}"readonly></td>
									<td><input type="text" name="nome" value="${publico.nome}" readonly></td>
									<td><select class="form-control" name="status">
									<option value="${publico.status}">${publico.status}</option>
									<option value="true">true</option>
									</select></td>
									<td><button type="submit" class="btn btn-success btn-sm">Alterar</button></td>
									</tr></form>

								</c:forEach>

							</tbody>
						</table>
					</div>
				</div>
				<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
					aria-labelledby="v-pills-profile-tab"></div>
				<div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
					aria-labelledby="v-pills-messages-tab"></div>
				<div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
					aria-labelledby="v-pills-settings-tab">
					<div class="container">

						<div class="card">
							<div class="card-body">
								<h4 class="card-title">TERMOS EMPRESA</h4>
								<p class="card-text">Aqui encontram-se todos os Termos para
									a adesÃ£o do projeto.</p>

								<form action="URL" type="get">
									<input name="upload" type="file">
									<button type="submit">Enviar</button>
								</form>
								<br> <br>
								<form>


									<table class="table table-hover">
										<thead>
											<tr>
												<th>Tipo</th>
												<th>Data</th>
												<th>Nome</th>
												<th>Download</th>



											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Empresa</td>
												<td>01.154.178/0001-65</td>
												<td>JoÃ£o e maria unidos pelo crescimento social.me</td>
												<td><button type="button"
														class="btn btn-success btn-sm">Download</button></td>
											</tr>
											<tr>
												<td>Mary</td>
												<td>Moe</td>
												<td>mary@example.com</td>
												<td><button type="button"
														class="btn btn-success btn-sm">Download</button></td>
											</tr>
											<tr>
												<td>July</td>
												<td>Dooley</td>
												<td>july@example.com</td>
												<td><button type="button"
														class="btn btn-success btn-sm">Download</button></td>
											</tr>
										</tbody>
									</table>



								</form>

							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="v-TERMS-settings" role="tabpanel"
					aria-labelledby="v-pills-TERMS-tab">
					<div class="container">

						<div class="card">
							<div class="card-body">
								<h4 class="card-title">TERMOS CARTORIO</h4>
								<p class="card-text">Aqui encontram-se todos os Termos para
									a adesÃ£o do projeto.</p>
								<form action="URL" type="get">
									<input name="upload" type="file">
									<button type="submit">Enviar</button>
								</form>
								<br> <br>
								<form>


									<table class="table table-hover">
										<thead>
											<tr>
												<th>Tipo</th>
												<th>Data</th>
												<th>Nome</th>
												<th>Download</th>



											</tr>
										</thead>
										<tbody>
											<tr>
												<td>Empresa</td>
												<td>01.154.178/0001-65</td>
												<td>JoÃ£o e maria unidos pelo crescimento social.me</td>
												<td><button type="button"
														class="btn btn-success btn-sm">Download</button></td>
											</tr>
											<tr>
												<td>Mary</td>
												<td>Moe</td>
												<td>mary@example.com</td>
												<td><button type="button"
														class="btn btn-success btn-sm">Download</button></td>
											</tr>
											<tr>
												<td>July</td>
												<td>Dooley</td>
												<td>july@example.com</td>
												<td><button type="button"
														class="btn btn-success btn-sm">Download</button></td>
											</tr>
										</tbody>
									</table>



								</form>

							</div>
						</div>
					</div>
				</div>
			</div>



		</div>
	</div>
</body>
</html>
