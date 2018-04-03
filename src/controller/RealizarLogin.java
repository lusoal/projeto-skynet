package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import service.LoginService;

@WebServlet("/RealizarLogin")
public class RealizarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pDocumento = request.getParameter("documento");
		String psenha = request.getParameter("senha");
		
		Login logar = new Login(Integer.parseInt(pDocumento),psenha);
		LoginService service = new LoginService();
		
		//Verifica se esta cadastrado
		boolean validar = service.SelectLogin(logar);
		
		if (validar==true) {
			boolean pass = service.ValidarSenha(logar);
			System.out.println(pass);
			//carrega o tipo do usuario cadastrado
			String carregarTipo = service.selectTipo(logar);
			if(pass == true && carregarTipo.equals("Administrador")) {
				//http session necessario para criar a sessao do usuario
				HttpSession session=request.getSession();  
		        session.setAttribute("documento", pDocumento);  
				response.sendRedirect("perfis/administrador/adm_index.jsp");
				
			}else if(pass == true && carregarTipo.equals("Cartorio")) {
				
				//Implementar depois
				response.sendRedirect("perfis/cartorio/cartorio_index.jsp");
				
			}else if(pass == true && carregarTipo.equals("Empresa")) {
				
				//Implementar Depois
				response.sendRedirect("perfis/empresa/empresa_index.jsp");
				
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
