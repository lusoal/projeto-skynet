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

<div style="margin-top:7%" class="container">

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
</body>
</html>