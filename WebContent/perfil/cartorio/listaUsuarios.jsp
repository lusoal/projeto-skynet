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
<title>Usuarios Adicionais</title>
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
									<th>Documento</th>
									<th>Nome</th>
									<th>Email</th>
									<th>Perfil</th>
								</tr>
							</thead>
							<tbody>
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