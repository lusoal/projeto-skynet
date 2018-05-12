<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <nav class="navbar navbar-expand-md bg-light navbar-light">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="perfil/empresa/index.jsp">Adicional</a>
      </li>
      <li class="nav-item">
      </li>


      <form style="margin-right: 5%; margin-left:5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/ArquivoController.do" method="post">
        <button class="btn btn-light" name="acao" value="listarTermosEmpresa" type=submit>Download Termos</button>
      </form>
      <form style="margin-right: 5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/ArquivoController.do" method="post">
        <button class="btn btn-light" name="acao" value="listarTermos" type=submit>Upload Termos</button>
      </form>
      <li class="nav-item">
        <form style="margin-right: 10%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
          <input type="hidden" name="documento" value="${cadastro.documento}">
            <button name="command" value="ListarCadastroAdcional" style="margin-right: 5%" class="btn btn-light" type=submit>Alterar Cadastro</button>
          </form>
        </li>
        <form style="margin-left: 110%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
          <button type="submit" name="command" value="Logout" class="btn btn-info">Sair</button></form>
        </ul>
      </nav>
