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
           
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
              <script
                src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
                crossorigin="anonymous"></script>
                <script
                  src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
                  integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
                  crossorigin="anonymous"></script>

                  <script type="text/javascript" src="../vendor/js/validacoes.js"></script>
                  <script type="text/javascript" src="../vendor/jqueryplugin/dist/jquery.mask.min.js"></script>

                  <link rel="stylesheet"
                    href="../vendor/simple-line-icons/css/simple-line-icons.css">
                    <link href="../css/one-page-wonder.css" rel="stylesheet">
							 <script>
					            $(document).ready(function(){
					                $("#meubotao").hide(); 
					            });
		           			 </script>
		           			 
		           			  <script>
					            $(document).ready(function(){
					                $("#meucheck").click(function(){
					                	$("#meubotao").toggle();
					                }); 
					            });
		           			 </script>

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
                                      <form class="form-signin" action="${pageContext.request.contextPath}/controller.do" method="post">

                                        <h6 class="form-signin-heading" align="center">Insira seu
                                          Documento</h6>

                                          <label for="inputEmail" class="sr-only"> Digite seu CPF
                                          </label> <input type="text" name="documento" id="cpfcnpj" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />

                                          <button class="btn btn-sm btn btn-success btn-block" name="command" value="VerificarPre" type="submit">Entrar</button>

                                          </form>

                                        </ul></li>
                                        <li class="nav-item"><a class="nav-link" href=""></a></li>
                                        <li class="dropdown"><a class="dropdown-toggle"
                                          data-toggle="dropdown" href="#"><b>Login</b><span
                                          class="caret"></span></a>
                                          <ul class="dropdown-menu">
                                            <form class="form-signin" action="${pageContext.request.contextPath}/controller.do" method="post">

                                              <h6 class="form-signin-heading" align="center">Realize seu
                                                Login</h6>

                                                <label for="inputEmail" class="sr-only"> Digite seu CPF
                                                </label>
                                                <input type="text" name="documento" id="cpfcnpj2" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />

                                                <label
                                                  for="inputPassword" class="sr-only">Digite sua Senha</label> <input
                                                  type="password" name="senha" class="form-control"
                                                  placeholder="Digite sua senha" required>

                                                  <button class="btn btn-sm btn btn-success btn-block" name="command" value="RealizarLogin" type="submit">Entrar</button>

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

                                                <form class="form-signin" action="${pageContext.request.contextPath}/controller.do" method="post">
                                                  <h1>Pre-cadastro</h1>
                                                  <div class="container">
                                                    <div id="color_23">
                                                      <div class="row">
                                                        
                                                        <div class="form-group col-md-5">
                                                          <label for="name">Nome / Razao Social</label> <input type="text"
                                                          class="form-control" name="nome" required>
                                                        </div>
                                                        <div class="form-group col-md-7">
                                                          <label for="campo2">CNPJ / CPF</label><input type="text" name="documento" id="cpfcnpj3" class="form-control" maxlength="14" minlength="11"  placeholder="Digite seu CPF" required autofocus />
                                                        </div>
                                                      </div>
                                                      <div class="row">
                                                        

                                                        <div class="form-group col-md-7">
                                                          <label for="name">Email</label> <input type="text"
                                                          class="form-control" name="email" required>
                                                        </div>

                                                        <div class="form-group col-md-4">
                                                          <label for="campo3">tipo</label> <select class="form-control" name="tipo" required>
                                                          <option value="empresa">Empresa</option>
                                                          <option value="cartorio">Cartorio</option>




                                                        </select> <br>
                                                
                                                        <input id="meucheck" type="checkbox"> 
                                              
                                                        Eu aceito os <a href="#" data-toggle="modal" data-target="#myModal">termos de uso.</a>
                                                        <br>
                                                        <br>
                                                       
                                                        <button id="meubotao" class="btn btn-md btn  btn-outline-success btn-block" name="command" value="CadastrarPublico" type="submit" disable>Realizar!</button>
                                                      </div>
                                                    </div>

                                                  </div>
                                                  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal"></button>
          <h4 class="modal-title">Termos de uso</h4>
        </div>
        <div class="modal-body">
          <p>Evidentemente, a expansão dos mercados mundiais cumpre um papel essencial na formulação do sistema de participação geral. Neste sentido, o novo modelo estrutural aqui preconizado agrega valor ao estabelecimento das novas proposições. No entanto, não podemos esquecer que o acompanhamento das preferências de consumo assume importantes posições no estabelecimento das condições financeiras e administrativas exigidas. Por conseguinte, o desafiador cenário globalizado facilita a criação do fluxo de informações. A certificação de metodologias que nos auxiliam a lidar com a valorização de fatores subjetivos não pode mais se dissociar das condições inegavelmente apropriadas. 
</p>
<p>Ainda assim, existem dúvidas a respeito de como a consulta aos diversos militantes oferece uma interessante oportunidade para verificação das formas de ação. O incentivo ao avanço tecnológico, assim como o aumento do diálogo entre os diferentes setores produtivos afeta positivamente a correta previsão dos índices pretendidos. Não obstante, a determinação clara de objetivos estimula a padronização dos procedimentos normalmente adotados. Todas estas questões, devidamente ponderadas, levantam dúvidas sobre se a estrutura atual da organização representa uma abertura para a melhoria dos relacionamentos verticais entre as hierarquias. Nunca é demais lembrar o peso e o significado destes problemas, uma vez que o fenômeno da Internet ainda não demonstrou convincentemente que vai participar na mudança do processo de comunicação como um todo. </p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
                                                </div>
                                              </form>
                                            </body>
                                          </html>
