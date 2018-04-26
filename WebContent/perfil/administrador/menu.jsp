<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="perfil/administrador/index.jsp">Administrador</a>
    </li>
    <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/PublicoController.do" method="post">
      <button class="btn nav-link" name="acao" value="retornarPublico" type=submit>Cadastros Pendentes</button>
      </form>
   <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/ArquivoController.do" method="post">
     	<button name="acao" value="listarTermosAdminEmpresa" class="btn nav-link">Termos Empresa</button></a>
   </form>
      
   <form style="margin-right: 5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/ArquivoController.do" method="post">
      <button name="acao" value="listarTermosAdminCartorio" class="btn nav-link" type=submit>Termos Cartorio</button>
      </form>
     <li class="nav-item">
     <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/CadastroController.do" method="post">
      <input type="hidden" name="documento" value="${documento}">	
      <button name="acao" value="listarUsuario" style="margin-right: 5%" class="btn nav-link" type=submit>Alterar Cadastro</button>
   	</form>
    </li>
   <form style="margin-left: 60%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/Logout" method="post">
         <button type="submit" class="btn btn-info">Sair</button></form>
  </ul>
</nav>
