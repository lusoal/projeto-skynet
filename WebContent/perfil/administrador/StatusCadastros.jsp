<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<title>Status dos Cadastros</title>
</head>
<body>
<c:import url="menu.jsp"/>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>

<div style="margin-top:3%" class="container">
<center><h2>Cadastros Pendentes</h2></center>
</br>
</br>
<form action="${pageContext.request.contextPath}/PublicoController.do" method="post">
  <div class="row">
  <div class="col-sm-2">
  </div>
    <div class="col-sm-6">
    <input class="form-control" type="text" placeholder="Digite o nome do usuario" name="nome" aria-label="Search">
    </div>
    <div class="col-sm-2">
    <button name="acao" value="retornarPublico" class="btn btn-outline-success btn-rounded" type="submit">Search</button>
  	</div>
  </div>
 </form>

</br>
</br>
						<table class="table table-striped">
  						<thead>
								<tr>
									<th>Tipo</th>
									<th>CNPJ</th>
									<th>Razao social</th>
									<th>Aprovacao</th>
								</tr>
							</thead>
  							<tbody>
							<c:forEach var="publico" items="${arrayPublico}">
								<form action="${pageContext.request.contextPath}/PublicoController.do" method="post">
									<tr>
									<td><input type="text" name="tipo" value="${publico.tipo}"readonly></td>
									<td><input type="text" name="documento" value="${publico.documento}"readonly></td>
									<td><input type="text" name="nome" value="${publico.nome}" readonly></td>
									<td><button type="submit" name="acao" value="alterarPublico" class="btn btn-success btn-sm">Aprovar</button>
									<button type="submit" name="acao" value="removerPublico" class="btn btn-danger btn-sm">Remover</button></td>
									</tr></form>

								</c:forEach>

							</tbody>
						</table>
					</div>
</body>
</html>