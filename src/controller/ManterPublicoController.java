package controller;
import service.PublicoService;
import model.Publico;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(asyncSupported = true, urlPatterns = { "/CadastrarPublico", "/RemoverPublico", "/AlterarPublico", "/RetornarPublico"})
@WebServlet("/PublicoController.do")
public class ManterPublicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("acao");

		if(action.equals("retornarPublico")) {
			String nome = request.getParameter("nome");
			System.out.println();
			if(nome == null) {
				nome="";
			}
			PublicoService serv = new PublicoService();
			ArrayList<Publico> p = serv.retornaTodoPublico(nome);
			request.setAttribute("arrayPublico", p);
			RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/StatusCadastros.jsp");
			view.forward(request, response);
		}
		
		if(action.equals("cadastrarPublico")) {
			String pDocumento = request.getParameter("documento");
			String pTipo = request.getParameter("tipo");
			String pNome = request.getParameter("nome");
			String pEmail = request.getParameter("email");
			
			Publico publico = new Publico(Long.parseLong(pDocumento),pTipo, pNome, pEmail);
			PublicoService pService = new PublicoService();
			
			long testeCnpj = pService.ValidarCnpj(publico);
			if (testeCnpj != -1) {
				pService.InserirPublico(publico);
				response.sendRedirect("index.html");
			}else {
				//Tratamento de erro no frontend
				String erro;
				if (testeCnpj == -1) {
					erro = "Usuário ja cadastrado, o documento "+pDocumento + " já se encontra em nossa base de dados.";
				}else {
					erro = "Nao foi possivel cadastrar, entre em contato com o administrador.";
				}
				request.setAttribute("erro", erro);
				RequestDispatcher view = request.getRequestDispatcher("errors/erro.jsp");
				view.forward(request, response);
			}
		
		}
		
		if(action.equals("removerPublico")) {
			String pdocumento = request.getParameter("documento");
			System.out.println(pdocumento+" vai ser deletado");
			Publico publico = new Publico();
			publico.setDocumento(Long.parseLong(pdocumento));
			PublicoService service = new PublicoService();
			service.deletarPublico(publico.getDocumento());
			response.sendRedirect(request.getContextPath() + "/perfil/administrador/index.jsp");
		}
		
		if(action.equals("alterarPublico")) {
			String pdocumento = request.getParameter("documento");
			
			System.out.println(pdocumento);
			
			Publico publico = new Publico();
			publico.setDocumento(Long.parseLong(pdocumento));
			publico.setStatus(true);
			PublicoService service = new PublicoService();
			service.alterarStatus(publico);
			response.sendRedirect(request.getContextPath() + "/perfil/administrador/index.jsp");
		}
	
	
	}

}
