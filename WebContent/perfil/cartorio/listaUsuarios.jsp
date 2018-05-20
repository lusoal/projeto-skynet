<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="vendor/js/validacoes.js"></script>
	<script type="text/javascript" src="vendor/jqueryplugin/dist/jquery.mask.min.js"></script>

	<title>Usuarios Adicionais</title>
</head>
<body style="background:#DDDEDE;">
	<c:import url="menu.jsp"/>
	<% if(session.getAttribute("documento") == null) {
		response.sendRedirect("../../index.html");
	}%>
	</br>
	</br>
	</br>
	<form action="${pageContext.request.contextPath}/controller.do" method="post">
  	<div class="row">
  	<div class="col-sm-2">
  	</div>
    <div class="col-sm-6">
    <input class="form-control" type="text" placeholder="Digite o nome do usuario" name="nome" aria-label="Search">
    <input type="hidden" name="documentoPrincipal" value="${documento}">
    <input type="hidden" name="tipo" value="cartorio">
    </div>
    <div class="col-sm-2">
    <button name="command" value="ListarAdicional" class="btn btn-outline-success btn-rounded" type="submit">Search</button>
  	</div>
  </div>
 	</form>

	<div style="margin-top:3%" class="container">

		<div class="row mb-4">
			<div class="col text-right">
				<a href="#" class="btn btn-sm btn-primary" data-toggle="modal" data-target="#largeModal"> Adicinar Usuário  </a>
			</div>
		</div>

		<div class="modal fade" id="largeModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title" id="myModalLabel">Adicionar usuário</h4>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" action="${pageContext.request.contextPath}/controller.do" method="post">
							<input type="hidden" name="tipo" value="cartorio">
							<div class="form-group">
								<label class="control-label col-sm-2">Documento</label>
								<div class="col-sm-10">
									<input type="text" name="documento" id="cpfcnpj" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />
								</div>
							</div>
							<input type="hidden" name="documentoPrincipal" value="${documento}">
							<div class="form-group">
								<label class="control-label col-sm-2">Nome</label>
								<div class="col-sm-10">
									<input class="form-control" id="email" placeholder="Insira o Nome" name="nome">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="pwd">Email:</label>
								<div class="col-sm-10">
									<input type="email" class="form-control" placeholder="Insira seu email" name="email">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-2" for="pwd">Senha:</label>
								<div class="col-sm-5">
									<input type="password" class="form-control" placeholder="Coloque sua Senha" name="senha">
								</div>
							</div>
							<div class="form-group col-md-4">
								<label for="sel1">Perfil:</label>
								<select class="form-control" name="perfil">
									<option>Dono</option>
									<option>Colaborador</option>
								</select>
							</div>
							<div class="form-group">
								<div class="modal-footer">
									<div class="col-sm-offset-2 col-sm-4">
										<button type="submit" name="command" value="AdicionarAdicional" class="btn btn-success btn-sm-5">Cadastrar</button>
										<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>


		<table class="table table-hover">
			<thead style="background:white">
				<tr>
					<th>Documento</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Perfil</th>
					<th>Alterar</th>
				</tr>
			</thead>
			<tbody style="background:white">
				<c:forEach var="adicional" items="${arrayAdicional}">
				<form action="${pageContext.request.contextPath}/AlterarAdicional" method="post">
					<tr>
						<td><input type="text" name="tipo" value="${adicional.documento}"readonly></td>
						<td><input type="text" name="documento" value="${adicional.nome}"readonly></td>
						<td><input type="text" name="nome" value="${adicional.email}" readonly></td>
						<td><input type="text" name="nome" value="${adicional.perfil}" readonly></td>
						<td><button type="submit" class="btn btn-success btn-sm">Alterar</button></td>
					</tr></form>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>
