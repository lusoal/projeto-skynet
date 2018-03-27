package controller;
import service.PublicoService;
import model.Publico;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/CadastrarPublico", "/RemoverPublico"})
public class ManterPublicoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();	
		
		if(action.equals("/CadastrarPublico")) {
			String pDocumento = request.getParameter("documento");
			String pTipo = request.getParameter("tipo");
			
			Publico publico = new Publico(Integer.parseInt(pDocumento),pTipo);
			PublicoService pService = new PublicoService();
			
			long testeCnpj = pService.ValidarCnpj(publico);
			if (testeCnpj != -1) {
				pService.InserirPublico(publico);
				String[] array = {pDocumento, pTipo};
				request.setAttribute("publico", array);
				RequestDispatcher view = request.getRequestDispatcher("termos/adesao.jsp");
				view.forward(request, response);
			}else {
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
		
		if(action.equals("/RemoverPublico")) {
			String pdocumento = request.getParameter("documento");
			System.out.println(pdocumento);
			pdocumento = pdocumento.replace("/", "");
			Publico publico = new Publico();
			publico.setDocumento(Integer.parseInt(pdocumento));
			
			PublicoService service = new PublicoService();
	
			service.deletarPublico(publico);
			response.sendRedirect("index.html");
		}
	
	
	}

}
