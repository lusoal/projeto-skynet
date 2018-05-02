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
<title>Termos Empresa</title>

</head>
<body>
<c:import url="menu.jsp"/>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>
<div style="margin-top:3%" class="container">
	<form action="${pageContext.request.contextPath}/ArquivoController.do" enctype='multipart/form-data' method="post">
	<input type="file" name="arquivo">
	<input type="hidden" name="idAdm" value="${documento}">
	<input type="hidden" name="nome" value="termo_cartorio"> 
	<button type="submit" name="acao" value="uploadTermosAdmin" class="btn btn-success btn-sm">Adicionar</button>
	</form>
	
	<br>
	<br>
	<br>
	
	<table class="table table-striped">
  						<thead>
								<tr>
									<th>ID</th>
									<th>DATA</th>
									<th>TERMO</th>
									<th>  </th>
								</tr>
							</thead>
  							<tbody>
							<c:forEach var="arquivo" items="${arquivo}">
								<form action="${pageContext.request.contextPath}/ArquivoController.do" method="post">
									<tr>
									<input type="hidden" name="tabela" value="downloadArquivos" readonly>
									<td><input type="text" name="id" value="${arquivo.id}" readonly></td>
									<td><input type="text" name="nome" value="${arquivo.data}" readonly></td>
									<input type="hidden" name="tipo" value="Administrador">
									<td><img src="http://portal.ifba.edu.br/dgcom/imagens/pdficon.png/@@images/image.png" width="10%"></td>
									<td>
									<input type="text" name="path" placeholder="Digite o caminho">
									<button type="submit" name="acao" value="downloadTermos" class="btn btn-success btn-sm">Download</button>
									</tr></form>
								</c:forEach>

							</tbody>
						</table>
</div>

</body>
</html>