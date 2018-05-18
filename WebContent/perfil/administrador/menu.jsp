<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="perfil/administrador/index.jsp">Administrador</a>
    </li>
    <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
      <button class="btn btn-light" name="command" value="RetornarPublico" type=submit>Cadastros Pendentes</button>
      </form>
   <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
     	<button name="command" value="ListarTermosAdminEmpresa" class="btn btn-light">Termos Empresa</button></a>
   </form>

   <form style="margin-right: 5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
      <button name="command" value="ListarTermosAdminCartorio" class="btn btn-light" type=submit>Termos Cartorio</button>
      </form>
     <li class="nav-item">
     <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
      <input type="hidden" name="documento" value="${documento}">
      <input type="hidden" name="tipo" value="administrador">
      <button name="command" value="ListarUsuario" style="margin-right: 5%" class="btn btn-light" type=submit>Alterar Cadastro</button>
   	</form>
   	 </li>
   	<li class="nav-item">
   	<form style="margin-left: 20%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
      <button name="command" value="AdminVisualizarTodos" class="btn btn-light" type=submit>Listar Todos Cadastros</button>
      </form>
    </li>
   <form style="margin-left: 20%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
         <button type="submit" name="command" value="Logout" class="btn btn-info">Sair</button></form>
  </ul>
</nav>
