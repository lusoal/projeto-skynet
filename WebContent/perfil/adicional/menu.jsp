<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="perfil/administrador/index.jsp">Adicional</a>
    </li>
   <form style="margin-left: 60%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
         <button type="submit" name="command" value="Logout" class="btn btn-info">Sair</button></form>
  </ul>
</nav>
