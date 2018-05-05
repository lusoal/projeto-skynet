package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import service.LoginService;

public class RealizarLogin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pColaborador = request.getParameter("colaborador");
		
		if(pColaborador!=null) {
			System.out.println("Fazer Login Colaborador");
			command.LoginColaborador.login(request, response);
			
		}else {
		
		String pDocumento = request.getParameter("documento");
		String psenha = request.getParameter("senha");
		
		 pDocumento = pDocumento.replace(".", "");
		 pDocumento = pDocumento.replace("-", "");
		 pDocumento = pDocumento.replace("/", "");
		
		 System.out.println(pDocumento);
		 
		Login logar = new Login(Long.parseLong(pDocumento),psenha);
		LoginService service = new LoginService();
		
		//Verifica se esta cadastrado
		boolean validar = service.SelectLogin(logar);
		
		if (validar==true) {
			boolean pass = service.ValidarSenha(logar);
			
			//carrega o tipo do usuario cadastrado
			String carregarTipo = service.selectTipo(logar);
			
			if(pass == true && carregarTipo.equals("administrador")) {
				HttpSession session=request.getSession();  
		        session.setAttribute("documento", logar.getDocumento());
				response.sendRedirect("perfil/administrador/index.jsp");
				
			}else if(pass == true && carregarTipo.equals("cartorio")) {
				HttpSession session=request.getSession();  
		        session.setAttribute("documento", logar.getDocumento());  
				response.sendRedirect("perfil/cartorio/index.jsp");
				
			}else if(pass == true && carregarTipo.equals("empresa")) {
				HttpSession session=request.getSession();  
		        session.setAttribute("documento", logar.getDocumento());  
				response.sendRedirect("perfil/empresa/index.jsp");
				
			}else {
				System.out.println("Senha Invalida");
				response.sendRedirect("index.html");
			}
			
		}else {
			System.out.println("Nao cadastrado");
			response.sendRedirect("index.html");
		}

		}
	}

}
