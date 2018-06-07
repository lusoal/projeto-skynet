<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alterar Usuario Adicional</title>
</head>
<body style="background:#DDDEDE;">
<c:import url="menu.jsp"/>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>
<div style="margin-top:3%" class="container">
	<br>
	<br>
	<h2>Altere as informaçoes de ${adicional.nome}</h2>
	<div class ="containder-fluid" style="padding:5%">
    <form  method="post" action="${pageContext.request.contextPath}/controller.do" id="formAlterar">
    <div id="color_23">

    <div class="row">
        <br>
	<div class="form-group col-md-4">
		<label for="name">Nome</label> <input type="text"
			class="form-control" name="nome" value="${adicional.nome}">
	</div>
	<div class="form-group col-md-4">
		<label for="name">Email</label> <input type="text" class="form-control" name="email" value="${adicional.email}">
	</div>
	<input type="hidden" name="documentoPrincipal" value="${documento}">
	<input type="hidden" name="documento" value="${adicional.documento}">
	<input type="hidden" name="tipo" value="empresa">

	<div class="form-group col-md-4">
								<label for="sel1">Perfil:</label>
								<select class="form-control" name="perfil" value="${adicional.perfil}">
									<option>Dono</option>
									<option>Colaborador</option>
								</select>
	</div>
	<div class="form-group col-md-4">
	</div>
	<div class="form-group col-md-4">
	</div>
	<div class="form-group col-md-4">
	<button type="submit" name="command" value="AltualizarAdicional" class="btn btn-success btn-sm">Alterar Adicional</button>
	</div>
</div>
        </form>
	</div>
</div>

</body>
</html>
