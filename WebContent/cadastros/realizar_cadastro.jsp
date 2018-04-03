<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Cadastrar</title>
</head>
<body>
<%String documento =(String)session.getAttribute("documento"); %>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../index.html");
}%>

<div class="container">
  <form action="${pageContext.request.contextPath}/CadastrarUsuario" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Documento</label>
    <input class="form-control" placeholder="Coloque seu documento" name="documento">
     <label for="exampleInputEmail1">Nome</label>
    <input class="form-control" placeholder="Coloque seu nome" name="nome">
    <label for="exampleInputEmail1">Tipo</label>
    <input class="form-control" placeholder="Coloque seu tipo" name="tipo">
     <label for="exampleInputEmail1">Endereco</label>
    <input class="form-control" placeholder="Coloque seu endereco" name="endereco">
    <label for="exampleInputEmail1">Telefone</label>
    <input class="form-control" placeholder="Coloque seu telefone" name="telefone">
     <label for="exampleInputEmail1">Documento Contato Principal</label>
    <input class="form-control" placeholder="Coloque documento do contato principal" name="doc_cont">
    <label for="exampleInputEmail1">Nome Contato Principal</label>
    <input class="form-control" placeholder="Coloque o nome do contato principal" name="doc_nome">
    <label for="exampleInputEmail1">Email Contato Principal</label>
    <input class="form-control" placeholder="Coloque o Email do contato principal" name="doc_email">
     <label for="exampleInputEmail1">Insira uma senha</label>
    <input class="form-control" placeholder="Coloque sua senha" name="senha">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>