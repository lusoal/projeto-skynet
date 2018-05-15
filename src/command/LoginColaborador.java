package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import model.Cadastros;
import service.LoginService;

public class LoginColaborador implements Command {
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pDocumento = request.getParameter("documento");
		String pSenha = request.getParameter("senha");
		 pDocumento = pDocumento.replace(".", "");
		 pDocumento = pDocumento.replace("-", "");
		 pDocumento = pDocumento.replace("/", "");
		 
		 Login login = new Login(Long.parseLong(pDocumento), pSenha);
		 LoginService service = new LoginService();
		 if(service.LoginAdicional(login)) {
			 //Pegar Documento vinculado a conta
			 System.out.println("Login Permitido");
			 if(service.verificarSenha(login)) {
				 System.out.println("status false");
				request.setAttribute("documento", login.getDocumento());
				RequestDispatcher view = request.getRequestDispatcher("perfil/adicional/alterarSenha.jsp");
				view.forward(request, response); 
			 }else {
				 Cadastros cadastro = new Cadastros();
				 service.carregarAssociado(login, cadastro);
				 
				 HttpSession session= request.getSession();
				 System.out.println(cadastro.getTipo());
			     session.setAttribute("cadastro", cadastro);
			     session.setAttribute("documento", login.getDocumento());
			     response.sendRedirect("perfil/adicional/index.jsp");
			 }
			 
		 }else {
			 response.sendRedirect("index.html");
		 }
		
		
		
	}
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrou em colaborador");
		LoginColaborador login = new LoginColaborador();
		login.executar(request, response);
	}

}
