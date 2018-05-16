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

<title>Alterar Meu Cadastro</title>

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
<% if(session.getAttribute("documentoColab") == null) {
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
	<input type="hidden" name="documento" value="${documentoColab}">
	
<div id="actions" class="row">
	<div class="col-sm-6">
		<button name="command" type="submit" value="AlterarCadastroAdicional" class="btn btn-primary" id="alterar">Alterar</button>
	</div>
</div>
        </div>
        </form>
	</div>


</body>
</html>
