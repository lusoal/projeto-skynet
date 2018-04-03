<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Termo de Adesao</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../index.html">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Publico</a></li>
          <li><a href="#">Administrador</a></li>
          <li><a href="#">Cartorio</a></li>
          <li><a href="#">Empresa</a></li>
        </ul>
      </li>	
    </ul>
    <form class="navbar-form navbar-left">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
  </div>
</nav>

<%String[] publico = (String[])request.getAttribute("publico"); %>
<center>Voce do tipo <%=publico[1]%> inscrito no documento: <%=publico[0]%>, aceita o seguinte termo de adesão:</center>
<center><div>
</div></center>

<center><a href="index.html"><button class="btn btn-primary">Aceitar</button></a></center>

<center><form action="RemoverPublico" method="post">
<input type="hidden" name="documento" value=<%=publico[0]%>/>
<button type="submit" class="btn btn-primary">Recusar</button>
</form></center>
</body>
</html>