<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-light navbar-light">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="perfil/cartorio/index.jsp">Cartorio</a>
    </li>
    <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="usuarioAdicional.jsp" method="post">
      <button class="btn nav-link" type=submit>Usuario Adicional</button>
      </form>
   <form style="margin-right: 5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/DownloadTermos" method="post">
      <button class="btn nav-link" type=submit>Download Termos</button>
      </form>
   <form style="margin-right: 5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/UploadTermos" method="post">
      <button class="btn nav-link" type=submit>Upload Termos</button>
      </form>
     <li class="nav-item">
      <a href="alterarCadastro.jsp"><button style="margin-right: 5%" class="btn nav-link" type=submit>Alterar Cadastro</button></a>
    </li>
   <form style="margin-left: 60%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/Logout" method="post">
         <button type="submit" class="btn btn-info">Sair</button></form>
  </ul>
</nav>
