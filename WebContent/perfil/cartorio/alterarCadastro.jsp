<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="shortcut icon" href="../../img/skynet_t_shirt_textual_tees.png"
	type="image/x-png" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="../../vendor/js/validacoes.js"></script>
  <script type="text/javascript" src="../../vendor/jqueryplugin/dist/jquery.mask.min.js"></script>

<title>Alterar Cadastro</title>

<script>
function myFunction() {
    var x = document.getElementById("senha");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
</script>

</head>
<body style="background:#DDDEDE;">
<c:import url="menu.jsp"/>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>
<div class ="containder-fluid" style="padding:5%">
    <form  method="post" action="${pageContext.request.contextPath}/controller.do" id="formAlterar">
    <div id="color_23">

    <div class="row">
        <br>
	<div class="form-group col-md-4">
		<label for="name">Nome / Razao Social</label> <input type="text"
			class="form-control" name="nome" value="${usuario.nome}">
	</div>
	<div class="form-group col-md-4">
		<label for="name">Email</label> <input type="text" class="form-control" name="email" value="${usuario.email}">
	</div>
	<input type="hidden" name="documento" value="${documento}">
	<input type="hidden" name="tipo" value="cartorio">

	<div class="form-group col-md-2">
		<label for="campo2">Telefone</label> <input type="text"
			class="form-control" name="telefone_fixo" value="${usuario.telefoneFixo}">
	</div>
	<div class="form-group col-md-2">
		<label for="campo3">Celular</label> <input type="text"
			class="form-control" name="telefone_celular" value="${usuario.telefoneCelular}">
    </div>
</div>

<div class="row">
	<div class="form-group col-md-12">
		<label for="campo1">Endereco</label> <input type="text"
			class="form-control" name="endereco" value="${usuario.endereco}">
	</div>


        </div>

<div class="row">
	<div class="form-group col-md-3">
		<label for="campo1">Documento Contato Principal</label> <input type="text"
			class="form-control" name="cont_doc" value="${usuario.contatoDocumento}">
	</div>
	<div class="form-group col-md-5">
		<label for="campo1">Nome Contato Principal</label> <input type="text"
			class="form-control" name="cont_nome" value="${usuario.nomeContato}">
	</div>
	<div class="form-group col-md-4">
		<label for="campo2">E-mail contato Principal </label> <input type="text"
			class="form-control" name="cont_email" value="${usuario.contatoEmail}">
	</div>
    </div>

    <div class= "row">
        <div class="form-group col-md-6">

		<label for="campo3">Site</label> <input type="text"
			class="form-control" name="site" value="${usuario.site}">
	</div>
	<div class="form-group col-md-3">
		<label for="campo3">Senha</label> <input type="password" class="form-control" name="senha" id="senha" value="${usuario.senha}">
		<input type="checkbox" onclick="myFunction()"> Mostrar Senha
	</div>
	</div>
<div id="actions" class="row">
	<div class="col-sm-6">
		<button name="command" type="submit" value="AlterarCadastro" class="btn btn-primary" id="alterar">Alterar</button>
	</div>
</div>
        </div>
        </form>
	</div>


</body>
</html>
