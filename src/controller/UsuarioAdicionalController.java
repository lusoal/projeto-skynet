package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publico;
import model.UsuarioAdicional;
import service.UsuarioAdicionalService;

//Implementar um url patter so e mudar no formulario pegando acao do botao
@WebServlet(asyncSupported = true, urlPatterns = { "/AdicionarAdicional", "/ListarAdicionais"})
public class UsuarioAdicionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		if(action.equals("/AdicionarAdicional")) {
			String pDocumento = request.getParameter("documento");
			String pNome = request.getParameter("nome");
			String pEmail = request.getParameter("email");
			String pSenha = request.getParameter("senha");
			String pDocumentoPrincipal = request.getParameter("documentoPrincipal");
			String pPerfil = request.getParameter("perfil");
			
			UsuarioAdicional adicional = new UsuarioAdicional(pNome, Long.parseLong(pDocumento), 
					Long.parseLong(pDocumentoPrincipal), pEmail, pSenha, pPerfil);
			UsuarioAdicionalService service = new UsuarioAdicionalService();
			
			try {
				service.adicionarUsuario(adicional);
				response.sendRedirect(request.getContextPath() + "/perfil/cartorio/usuarioAdicional.jsp");
			}catch(Exception e) {
				System.out.println("Erro Cadastro "+ e);
				response.sendRedirect("index.html");
				}
			}
		
			
		if(action.equals("/ListarAdicionais")) {
			String pDocumentoPrincipal = request.getParameter("documentoPrincipal");
			UsuarioAdicional adicional = new UsuarioAdicional();
			
			adicional.setDocumentoPrinc(Long.parseLong(pDocumentoPrincipal));
			UsuarioAdicionalService service = new UsuarioAdicionalService();
			
			ArrayList<UsuarioAdicional> ua = service.listarUsuarios(adicional);
			request.setAttribute("arrayAdicional", ua);
			RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/listaUsuarios.jsp");
			view.forward(request, response);
			
		}
	
	}
}
