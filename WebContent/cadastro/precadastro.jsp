<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>
    <head>
      <meta charset="utf-8">

        <link rel="shortcut icon" href="../img/skynet_t_shirt_textual_tees.png"
          type="image/x-png" />
          <link rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
            integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
            crossorigin="anonymous">
            <script
              src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
              <script
                src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                crossorigin="anonymous"></script>
                <script
                  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                  integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                  crossorigin="anonymous"></script>

                  <link rel="stylesheet"
                    href="../vendor/simple-line-icons/css/simple-line-icons.css">
                    <link href="../css/one-page-wonder.css" rel="stylesheet">


                      <title>SkyNetProject</title>
                      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                      </head>
                      <body style="background:#DDDEDE;">

                        <!--    <div id="div3" style="width:80px;height:80px;display:none;background-color:blue;"></div>-->
                        <!-- Navigation -->
                        <nav class="navbar navbar-expand-lg navbar-light fixed-top"
                          style="background-color: white;">
                          <div class="container">
                            <a class="navbar-brand" href="../index.html" ><img
                              src="../img/navbar1.jpg" width=80% height=40%
                              style="float: left; margin-left: 0%"></a>
                              <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarResponsive" aria-controls="navbarResponsive"
                                aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                              </button>
                              <div class="collapse navbar-collapse" id="navbarResponsive">
                                <ul class="navbar-nav ml-auto">
                                  <li class="nav-item active"><a class="nav-link"
                                    href="../index.html"> <span class="sr-only">(current)</span>
                                  </a></li>
                                  <li class="dropdown"><a class="dropdown-toggle"
                                    data-toggle="dropdown" href="#"><b>Ja Realizei o
                                    Pre-Cadastro</b> <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                      <form class="form-signin" action="RealizarLogin" method="post">

                                        <h6 class="form-signin-heading" align="center">Insira seu
                                          Documento</h6>

                                          <label for="inputEmail" class="sr-only"> Digite seu CPF
                                          </label> <input name="documento" class="form-control"
                                          placeholder="Digite seu CPF" required autofocus>

                                          <button class="btn btn-sm btn btn-success btn-block"
                                            type="submit">Entrar</button>

                                          </form>

                                        </ul></li>
                                        <li class="nav-item"><a class="nav-link" href=""></a></li>
                                        <li class="dropdown"><a class="dropdown-toggle"
                                          data-toggle="dropdown" href="#"><b>Login</b><span
                                          class="caret"></span></a>
                                          <ul class="dropdown-menu">
                                            <form class="form-signin" action="RealizarLogin" method="post">

                                              <h6 class="form-signin-heading" align="center">Realize seu
                                                Login</h6>

                                                <label for="inputEmail" class="sr-only"> Digite seu CPF
                                                </label> <input name="documento" class="form-control"
                                                placeholder="Digite seu CPF" required autofocus> <label
                                                for="inputPassword" class="sr-only">Digite sua Senha</label> <input
                                                type="password" name="senha" class="form-control"
                                                placeholder="Digite sua senha" required>

                                                <button class="btn btn-sm btn btn-success btn-block"
                                                  type="submit">Entrar</button>

                                                </form>

                                              </ul>
                                            </li>
                                          </ul>
                                        </div>
                                      </div>
                                    </nav>



                                    <br>
                                      <br>
                                        <br>
                                          <br>
                                            <br>

                                              <form class="form-signin" action="${pageContext.request.contextPath}/PublicoController.do" method="post">
                                                <h1>Pre-cadastro</h1>
                                                <div class="container">
                                                  <div id="color_23">
                                                    <div class="row">
                                                      <div class="form-group col-md-1"></div>
                                                      <div class="form-group col-md-5">
                                                        <label for="name">Nome / Razao Social</label> <input type="text"
                                                        class="form-control" name="nome">
                                                      </div>
                                                      <div class="form-group col-md-5">
                                                        <label for="campo2">CNPJ / CPF</label> <input type="text"
                                                        class="form-control" name="documento">
                                                      </div>
                                                    </div>
                                                    <div class="row">
                                                      <div class="form-group col-md-1">
                                                    </div>

                                                      <div class="form-group col-md-7">
                                                        <label for="name">Email</label> <input type="text"
                                                          class="form-control" name="email">
                                                      </div>

                                                      <div class="form-group col-md-2">
                                                        <label for="campo3">tipo</label> <select class="form-control" name="tipo">
                                                        <option value="empresa">Empresa</option>
                                                        <option value="cartorio">Cartorio</option>




                                                      </select> <br>
                                                      <button class="btn btn-md btn  btn-outline-success btn-block" name="acao" value="cadastrarPublico" type="submit">Realizar!</button>
                                                    </div>
                                                  </div>

                                                </div>
                                              </div>
                                            </form>
                                          </body>
                                        </html>
