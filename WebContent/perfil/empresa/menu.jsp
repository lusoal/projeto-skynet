<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>



    <nav class="navbar navbar-expand-md bg-light navbar-light">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <a class="nav-link" href="perfil/empresa/index.jsp">Empresa</a>
        </li>

        <form style="margin-right: 5%; margin-left:2%" action="${pageContext.request.contextPath}/controller.do" method="post">
          <input type="hidden" name="documentoPrincipal" value="${documento}">
            <input type="hidden" name="tipo" value="empresa">
              <button   class="btn btn-light" type=submit name="command" value="ListarAdicional" >Usuario Adicional</button>
            </form>
            <form style="margin-right: 5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
              <input type="hidden" name="tipo" value="Empresa">
                <button  class="btn btn-light" name="command" value="ListarTermosGerais" type=submit>Download Termos</button>
              </form>
              <form style="margin-right: 5%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
                <input type="hidden" name="documento" value="${documento}">
                  <input type="hidden" name="tipo" value="empresa">
                    <button class="btn btn-light"  name="command" value="ListarTermosVinculados" type=submit>Upload Termos</button>
                  </form>
                  <li class="nav-item">
                    <form style="margin-right: 5%; margin-left: 2%"class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
                      <input type="hidden" name="documento" value="${documento}">
                        <input type="hidden" name="tipo" value="empresa">
                          <button name="command" value="ListarUsuario" style="margin-right: 5%"   class="btn btn-light" type=submit>Alterar Cadastro</button>
                        </form>
                      </li>
                      <form style="margin-left: 60%" class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller.do" method="post">
                        <button type="submit" name="command" value="Logout" class="btn btn-info">Sair</button></form>
                      </ul>
                    </nav>
