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
<title>Insert title here</title>
</head>
<body>
<%String documento =(String)session.getAttribute("documento"); %>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>
</body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Admin</a></li>
      <li class="active"><a href="cadastros_pendentes.jsp">Cadastros Pendentes</a></li>
    </ul>
    <form action="${pageContext.request.contextPath}/Logout" method="post" class="navbar-form navbar-left">
      <button type="submit" class="btn btn-default" value="Logout">Logout</button>
    </form>
  </div>
</nav>


<h1>Voce criou uma sessao de adm</h1>


</html>