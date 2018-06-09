# projeto-skynet
Repositorio focado no Projeto da Universidade São judas

#Database Import
Inside the repository you have an mysql.sql, you just have to execute the queries inside you mysql server and be happy !

#What you have to alter for the application Works

1. Change de DB Connection - /connection/ConnectionFactory:
    Change the follow String - return DriverManager.getConnection("jdbc:mysql://localhost/skynet?user=root&password=root");
    Place your DB connection String

2. Change The Email to send E-mail trought the project - /utils/SendMail:
    Change the follow things:
      Line 40 - return new PasswordAuthentication("email", "password");
      Line 50 -  message.setFrom(new InternetAddress("email"));

3. Change The Log path for your LogFile: - WebContent/WEB-INF/classes/log4j.properties
   Change the follow things:
    Line 14 - log4j.appender.file.File="Log Path" Ex:(/tmp/myapp/application.log) 

After all this, build the application and Be Happy !

# Directory Structure of Application
|   .classpath
|   .gitignore
|   .project
|   Aula2e3ModeloCasoUso.pdf
|   script_skynet.sql
|   tree.txt
|   
+---.settings
|       .jsdtscope
|       org.eclipse.jdt.core.prefs
|       org.eclipse.wst.common.component
|       org.eclipse.wst.common.project.facet.core.xml
|       org.eclipse.wst.jsdt.ui.superType.container
|       org.eclipse.wst.jsdt.ui.superType.name
|       
+---build
|   \---classes
|       +---command
|       |       AdicionarAdicional.class
|       |       AdminVisualizarTodos.class
|       |       AlterarAdicionalMain.class
|       |       AlterarCadastro.class
|       |       AlterarCadastroAdicional.class
|       |       AlterarCadastrosComAdm.class
|       |       AlterarPublico.class
|       |       AlterarSenhaAdicional.class
|       |       AltualizarAdicional.class
|       |       CadastrarPublico.class
|       |       CadastrarUsuario.class
|       |       Command.class
|       |       DownloadTermos.class
|       |       ListarAdicional.class
|       |       ListarCadastroAdcional.class
|       |       ListarCadastroAdd.class
|       |       ListarTermosAdminCartorio.class
|       |       ListarTermosAdminEmpresa.class
|       |       ListarTermosGerais.class
|       |       ListarTermosVinculados.class
|       |       ListarTodasEmpresas.class
|       |       ListarUsuario.class
|       |       LoginColaborador.class
|       |       Logout.class
|       |       PreCadastroTermos.class
|       |       RealizarLogin.class
|       |       RemoverPublico.class
|       |       RetornarPublico.class
|       |       UploadTermos.class
|       |       UploadTermosAdmin.class
|       |       VerificarPre.class
|       |       
|       +---connection
|       |       ConnectionFactory.class
|       |       
|       +---controller
|       |       Controller.class
|       |       
|       +---dao
|       |       ArquivosDao.class
|       |       LoginDao.class
|       |       ManterCadastrosDao.class
|       |       PublicoDao.class
|       |       UsuarioAdicionalDao.class
|       |       
|       +---filter
|       |       LoginFilter.class
|       |       
|       +---model
|       |       Arquivos.class
|       |       Cadastros.class
|       |       Login.class
|       |       Publico.class
|       |       UsuarioAdicional.class
|       |       
|       +---service
|       |       ArquivoService.class
|       |       CadastroService.class
|       |       LoginService.class
|       |       PublicoService.class
|       |       UsuarioAdicionalService.class
|       |       
|       \---utils
|               SendMail$1.class
|               SendMail.class
|               
+---src
|   +---command
|   |       AdicionarAdicional.java
|   |       AdminVisualizarTodos.java
|   |       AlterarAdicionalMain.java
|   |       AlterarCadastro.java
|   |       AlterarCadastroAdicional.java
|   |       AlterarCadastrosComAdm.java
|   |       AlterarPublico.java
|   |       AlterarSenhaAdicional.java
|   |       AltualizarAdicional.java
|   |       CadastrarPublico.java
|   |       CadastrarUsuario.java
|   |       Command.java
|   |       DownloadTermos.java
|   |       ListarAdicional.java
|   |       ListarCadastroAdcional.java
|   |       ListarCadastroAdd.java
|   |       ListarTermosAdminCartorio.java
|   |       ListarTermosAdminEmpresa.java
|   |       ListarTermosGerais.java
|   |       ListarTermosVinculados.java
|   |       ListarTodasEmpresas.java
|   |       ListarUsuario.java
|   |       LoginColaborador.java
|   |       Logout.java
|   |       PreCadastroTermos.java
|   |       RealizarLogin.java
|   |       RemoverPublico.java
|   |       RetornarPublico.java
|   |       UploadTermos.java
|   |       UploadTermosAdmin.java
|   |       VerificarPre.java
|   |       
|   +---connection
|   |       ConnectionFactory.java
|   |       
|   +---controller
|   |       Controller.java
|   |       
|   +---dao
|   |       ArquivosDao.java
|   |       LoginDao.java
|   |       ManterCadastrosDao.java
|   |       PublicoDao.java
|   |       UsuarioAdicionalDao.java
|   |       
|   +---filter
|   |       LoginFilter.java
|   |       
|   +---model
|   |       Arquivos.java
|   |       Cadastros.java
|   |       Login.java
|   |       Publico.java
|   |       UsuarioAdicional.java
|   |       
|   +---service
|   |       ArquivoService.java
|   |       CadastroService.java
|   |       LoginService.java
|   |       PublicoService.java
|   |       UsuarioAdicionalService.java
|   |       
|   \---utils
|           SendMail.java
|           
\---WebContent
    |   gulpfile.js
    |   index.html
    |   
    +---cadastro
    |       cadastro.jsp
    |       precadastro.jsp
    |       
    +---css
    |       one-page-wonder.css
    |       
    +---errors
    |       erro.jsp
    |       
    +---img
    |       adc1302f921b881d91f856f97a6c83cd93d411cc_00.gif
    |       Ex05.class
    |       Ex05.java
    |       ezgif.com-video-to-gif.gif
    |       instagram.png
    |       KeLbkp.gif
    |       navbar1.jpg
    |       skynet_t_shirt_textual_tees.png
    |       twitter.png
    |       
    +---META-INF
    |       MANIFEST.MF
    |       
    +---perfil
    |   +---adicional
    |   |       alterarCadastro.jsp
    |   |       alterarCadastroProprio.jsp
    |   |       alterarSenha.jsp
    |   |       index.jsp
    |   |       menu.jsp
    |   |       termosEmpresa.jsp
    |   |       uploadTermos.jsp
    |   |       
    |   +---administrador
    |   |       alterarCadastro.jsp
    |   |       alterarCadastroColab.jsp
    |   |       index.jsp
    |   |       menu.jsp
    |   |       mostrarTodos.jsp
    |   |       StatusCadastros.jsp
    |   |       termosCartorio.jsp
    |   |       termosEmpresa.jsp
    |   |       
    |   +---cartorio
    |   |       alterarAdicional.jsp
    |   |       alterarCadastro.jsp
    |   |       index.jsp
    |   |       listaUsuarios.jsp
    |   |       menu.jsp
    |   |       mostrarTodos.jsp
    |   |       termosCartorio.jsp
    |   |       uploadTermos.jsp
    |   |       
    |   \---empresa
    |           alterarAdicional.jsp
    |           alterarCadastro.jsp
    |           index.jsp
    |           listaUsuarios.jsp
    |           menu.jsp
    |           termosEmpresa.jsp
    |           uploadTermos.jsp
    |           
    +---termos
    |       adesao.jsp
    |       
    +---vendor
    |   +---bootstrap
    |   |   +---css
    |   |   |       bootstrap-grid.css
    |   |   |       bootstrap-grid.min.css
    |   |   |       bootstrap-reboot.css
    |   |   |       bootstrap-reboot.min.css
    |   |   |       bootstrap.css
    |   |   |       bootstrap.css.map
    |   |   |       bootstrap.min.css
    |   |   |       bootstrap.min.css.map
    |   |   |       
    |   |   \---js
    |   |           bootstrap.bundle.js
    |   |           bootstrap.bundle.js.map
    |   |           bootstrap.bundle.min.js
    |   |           bootstrap.bundle.min.js.map
    |   |           bootstrap.js
    |   |           bootstrap.js.map
    |   |           bootstrap.min.js
    |   |           bootstrap.min.js.map
    |   |           
    |   +---chart.js
    |   |       Chart.bundle.js
    |   |       Chart.bundle.min.js
    |   |       Chart.js
    |   |       Chart.min.js
    |   |       
    |   +---datatables
    |   |       dataTables.bootstrap4.css
    |   |       dataTables.bootstrap4.js
    |   |       jquery.dataTables.js
    |   |       
    |   +---font-awesome
    |   |   +---css
    |   |   |       font-awesome.css
    |   |   |       font-awesome.css.map
    |   |   |       font-awesome.min.css
    |   |   |       
    |   |   +---fonts
    |   |   |       fontawesome-webfont.eot
    |   |   |       fontawesome-webfont.svg
    |   |   |       fontawesome-webfont.ttf
    |   |   |       fontawesome-webfont.woff
    |   |   |       fontawesome-webfont.woff2
    |   |   |       FontAwesome.otf
    |   |   |       
    |   |   +---less
    |   |   |       animated.less
    |   |   |       bordered-pulled.less
    |   |   |       core.less
    |   |   |       fixed-width.less
    |   |   |       font-awesome.less
    |   |   |       icons.less
    |   |   |       larger.less
    |   |   |       list.less
    |   |   |       mixins.less
    |   |   |       path.less
    |   |   |       rotated-flipped.less
    |   |   |       screen-reader.less
    |   |   |       stacked.less
    |   |   |       variables.less
    |   |   |       
    |   |   \---scss
    |   |           font-awesome.scss
    |   |           _animated.scss
    |   |           _bordered-pulled.scss
    |   |           _core.scss
    |   |           _fixed-width.scss
    |   |           _icons.scss
    |   |           _larger.scss
    |   |           _list.scss
    |   |           _mixins.scss
    |   |           _path.scss
    |   |           _rotated-flipped.scss
    |   |           _screen-reader.scss
    |   |           _stacked.scss
    |   |           _variables.scss
    |   |           
    |   +---jquery
    |   |       jquery.js
    |   |       jquery.min.js
    |   |       jquery.min.map
    |   |       jquery.slim.js
    |   |       jquery.slim.min.js
    |   |       jquery.slim.min.map
    |   |       
    |   +---jquery-easing
    |   |       jquery.easing.compatibility.js
    |   |       jquery.easing.js
    |   |       jquery.easing.min.js
    |   |       
    |   +---jqueryplugin
    |   |   \---dist
    |   |           jquery.mask.js
    |   |           jquery.mask.min.js
    |   |           
    |   +---js
    |   |       validacoes.js
    |   |       
    |   \---simple-line-icons
    |       +---css
    |       |       simple-line-icons.css
    |       |       
    |       +---fonts
    |       |       Simple-Line-Icons.eot
    |       |       Simple-Line-Icons.svg
    |       |       Simple-Line-Icons.ttf
    |       |       Simple-Line-Icons.woff
    |       |       Simple-Line-Icons.woff2
    |       |       
    |       +---less
    |       |       simple-line-icons.less
    |       |       
    |       \---scss
    |               simple-line-icons.scss
    |               
    \---WEB-INF
        +---classes
        |       log4j.properties
        |       
        \---lib
                commons-io-2.4.jar
                javax.servlet.jsp.jstl-1.2.1.jar
                javax.servlet.jsp.jstl-api-1.2.1.jar
                log4j-1.2.17.jar
                mail.jar
                mysql-connector-java-5-1-30.jar
                


