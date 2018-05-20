<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Todos Cadastros</title>
</head>
<body style="background:#DDDEDE">
<c:import url="menu.jsp"/>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>
<br>
<center><h2>Todos os Cadastros</h2></center>
<br>
<table class="table table-hover">
  						<thead style="background:white;">
								<tr>
									<th>Tipo</th>
									<th>CNPJ</th>
									<th>Razao social</th>
									<th>Email</th>
									<th>Cadastros</th>
								</tr>
							</thead>
  							<tbody style="background:white;">
							<c:forEach var="cadastros" items="${cadastros}">
								<form action="${pageContext.request.contextPath}/controller.do" method="post">
									<tr>
									<td><input type="text" name="tipo" value="${cadastros.tipo}"readonly></td>
									<td><input type="text" name="documento" value="${cadastros.documento}"readonly></td>
									<td><input type="text" name="nome" value="${cadastros.nome}" readonly></td>
									<td><input type="text" name="nome" value="${cadastros.email}" readonly></td>
									<td><button type="submit" name="command" value="AlterarCadastrosComAdm" class="btn btn-success btn-sm">Alterar</button></td>
									</tr></form>
								</c:forEach>

							</tbody>
						</table>

</body>
</html>
