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


<title>Home</title>
</head>


<body>
<c:import url="menu.jsp"/>
<% if(session.getAttribute("documento") == null) {
	response.sendRedirect("../../index.html");
}%>
<form action="${pageContext.request.contextPath}/controller.do" method="post">
<div class="container">
    <div class=row">
        <div class="col-md-offset-5 col-md-3" >
            <div class="form-login">
            <h4>Alterar senha.</h4>
            <input type="text" name="senha" class="form-control input-sm chat-input" placeholder="Digite sua Senha" />
            </br>
            <input type="text" name="senha1" class="form-control input-sm chat-input" placeholder="Confirme sua Senha" />
            </br>
              <input type="hidden" name="documento" value="${documento}" />
            <div class="wrapper">
            <span class="group-btn">
                <button type ="submit" name="command" value="AlterarSenhaAdicional" class="btn btn-primary btn-md">Salvar <i class="fa fa-sign-in"></i></a>
            </span>
            </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
