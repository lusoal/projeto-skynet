<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>

    <meta charset="utf-8">

      <link rel="shortcut icon" href="img/skynet_t_shirt_textual_tees.png"
        type="image/x-png" />

        <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">

          <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
            </script>

            <script
              src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
              integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
              crossorigin="anonymous">
              </script>

              <script
                src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                crossorigin="anonymous">
                </script>

                <script type="text/javascript" src="vendor/js/validacoes.js"></script>
                <script type="text/javascript" src="vendor/jqueryplugin/dist/jquery.mask.min.js"></script>
                <link rel="stylesheet" href="vendor/simple-line-icons/css/simple-line-icons.css">
                  <link href="css/one-page-wonder.css" rel="stylesheet">


                    <title>SkyNetProject</title>
                  </head>
                  <body style="background:#DDDEDE;">
                    <nav class="navbar navbar-expand-lg navbar-light fixed-top"
                      style="background-color: white;">

                      <div class="container">
                        <a class="navbar-brand" href="../../../index.html" ><img
                          src="img/navbar1.jpg" width=80% height=40%
                          style="float: left; margin-left: 0%"></a>

                          <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarResponsive" aria-controls="navbarResponsive"
                            aria-expanded="false" aria-label="Toggle navigation">

                            <span class="navbar-toggler-icon"></span>
                          </button>


                          <div class="collapse navbar-collapse" id="navbarResponsive">
                            <ul class="navbar-nav ml-auto">
                              <li class="nav-item active"><a class="nav-link"
                                href="index.html"> <span class="sr-only">(current)</span>
                              </a></li>

                              <li class="dropdown">
                                <a class="dropdown-toggle"data-toggle="dropdown" href="#">
                                  <b>Já Realizei o Pré-Cadastro</b>
                                  <span class="caret"></span></a>

                                  <ul class="dropdown-menu">

                                    <form class="form-signin" action="controller.do" method="post">

                                      <h6 class="form-signin-heading" align="center">Insira seu Documento</h6>

                                      <label for="cpfOuCnpj" type="text" class="sr-only"> Digite seu CPF </label>

                                      <input type="text" name="documentoTeste" id="cpfcnpj" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />

                                      <button class="btn btn-sm btn btn-success btn-block" name="command" value="VerificarPre" type="submit">Cadastrar</button>

                                    </form>

                                  </ul>

                                </li>

                                <li class="nav-item"><a class="nav-link" href=""></a></li>

                                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"><b>Login</b>

                                <span class="caret"></span></a>

                                <ul class="dropdown-menu">
                                  <form class="form-signin" action="controller.do" method="post">

                                    <h6 class="form-signin-heading" align="center">Realize seu Login</h6>

                                    <!--  <label for="inputEmail" class="sr-only"> Digite seu CPF </label>-->

                                    <input type="text" name="documento" id="cpfcnpj2" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />

                                    <input type="password"  name="alterarParaSenha" class="form-control" maxlength="32" minlength="6"  placeholder="Digite sua senha" required>
                                      <div class="form-check">
                                        <input class="form-check-input" type="checkbox" name="colaborador" value="usuarioAdicional" id="defaultCheck1">
                                          <label class="form-check-label" for="defaultCheck1">
                                            Colaborador
                                          </label>
                                        </div>

                                        <button  class="btn btn-sm btn btn-success btn-block" name="command" value="RealizarLogin" type="submit">Entrar</button>

                                      </form>
                                    </ul>
                                  </li>
                                </ul>
                              </div>
                            </div>

                          </nav>

                          <br>


                            <body>
                              <form action="${pageContext.request.contextPath}/controller.do" method="post">
                                <center>
                                  <div class="container">
                                    <div class=row">
                                      <div class="card card-body" style ="margin-top: 8%">
                                        <div class="col-md-offset-4 col-md-3"  >
                                          <div class="form-login">
                                            <h4 class="card-title">Alterar senha.</h4>
                                            <input type="password" name="senha" class="form-control input-sm chat-input" placeholder="Digite sua Senha" />
                                          </br>
                                          <input type="password" name="senha1" class="form-control input-sm chat-input" placeholder="Confirme sua Senha" />
                                        </br>
                                        <input type="hidden" name="documento" value="${documentoColab}" />
                                        <div class="flex-row">
                                          <div class="wrapper">
                                            <span class="group-btn">
                                              <button type ="submit" name="command" value="AlterarSenhaAdicional" class="btn btn-primary btn-md">Salvar </button>

                                              <a href="${pageContext.request.contextPath}/index.html" class="btn btn-danger">Cancelar</a>

                                            </span>
                                          </div>
                                        </div>
                                      </div>
                                    </div>

                                  </div>
                                </div>
                              </div>
                            </center>
                          </body>
                        </html>
