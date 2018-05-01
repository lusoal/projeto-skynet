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
<title>Adicionar Usuario</title>
</head>
<body>
<c:import url="menu.jsp"/>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>

<div class="container" style="margin-top:5%">
  <h2>Usuario Adicional</h2>
  <br>
 
  <div class="row">
  	<div class = "col-sm-8" >
  	<h5>Listar Usuarios Cadastrados ao meu Perfil</h5>	
  	</div>
  	<div class = "col-sm-4">
  		<form action="${pageContext.request.contextPath}/ListarAdicionais" method="post">
  		 <input type="hidden" name="documentoPrincipal" value="${documento}">
  		<button type="submit" class="btn btn-success btn-sm-5">Listar Usuarios</button>
  		</form>
  	</div>
  	<br>
  	<br>
  	<br>
  	<br>
  </div>
  <form class="form-horizontal" action="${pageContext.request.contextPath}/AdicionarAdicional" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2">Documento</label>
      <div class="col-sm-10">
        <input class="form-control" id="email" placeholder="Entra seu Nome" name="documento">
      </div>
    </div>
    <input type="hidden" name="documentoPrincipal" value="${documento}">
    <div class="form-group">
      <label class="control-label col-sm-2">Nome</label>
      <div class="col-sm-10">
        <input class="form-control" id="email" placeholder="Entra seu Nome" name="nome">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Email:</label>
      <div class="col-sm-10">          
        <input type="email" class="form-control" placeholder="Entre seu email" name="email">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Senha:</label>
      <div class="col-sm-5">          
        <input type="password" class="form-control" placeholder="Entre sua Senha" name="senha">
      </div>
    </div>
    <div class="form-group col-sm-2">
  	<label for="sel1">Perfil:</label>
  	<select class="form-control" name="perfil">
	    <option>Dono</option>
	    <option>Colaborador</option>
  </select>
</div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-success btn-sm-5">Cadastrar</button>
      </div>
    </div>
  </form>
</div>
</body>
</html>