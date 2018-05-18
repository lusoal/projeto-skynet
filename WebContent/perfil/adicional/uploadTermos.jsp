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
					<title>Upload Termos Assinados</title>
				</head>
				<body style="background:#DDDEDE;">
					<c:import url="menu.jsp"/>
					<% if(session.getAttribute("documentoColab") == null) {
						response.sendRedirect("../../index.html");
					}%>
					<div style="margin-top:3%" class="container">
						<h5>Upload de Termo Assinado</h5>
					</br>
				</br>


				<form action="${pageContext.request.contextPath}/controller.do" enctype='multipart/form-data' method="post">
					<input  type="file" name="arquivo">
						<input type="hidden" name="tipo" value="adicional">
							<input type="hidden" name="documento" value="${cadastro.documento}">
								<input type="hidden" name="nome" value="termo_empresa">
									<button type="submit" name="command" value="UploadTermos" class="btn btn-success btn-sm">Adicionar</button>
								</form>

								<br>
									<br>
										<br>
											<h5>Meus Ultimos Termos Assinados</h5>
											<br>
												<table class="table table-hover">
													<thead style="background:white;">
														<tr>
															<th>DATA</th>
															<th>TERMO</th>
															<th>    </th>

														</tr>
													</thead>
													<tbody style="background:white;">
														<c:forEach var="arquivo" items="${arquivo}">
															<form action="${pageContext.request.contextPath}/controller.do" method="post">
																<tr>
																	<input type="hidden" name="tabela" value="downloadArquivos" readonly>
																		<input type="hidden" name="id" value="${arquivo.id}"readonly>
																			<td><input type="text" name="nome" value="${arquivo.data}"readonly></td>
																			<input type="hidden" name="tipo" value="Empresa">
																				<td><img src="http://portal.ifba.edu.br/dgcom/imagens/pdficon.png/@@images/image.png" width="10%"></td>
																				<td><button type="submit" name="command" value="DownloadTermos" class="btn btn-success btn-sm">Download</button>
																			</tr></form>
																		</c:forEach>

																	</tbody>
																</table>

															</body>
														</html>
