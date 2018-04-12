package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CadastroService;
import model.Cadastros;
import model.Publico;
import service.PublicoService;

/**
 * Servlet implementation class CadastroController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/CadastrarUsuario", "/VerificarPreCadastro"})
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		
		
		PublicoService servicePub = new PublicoService();
		
		if(action.equals("/VerificarPreCadastro")) {
			String pDocumento = request.getParameter("documento");
			Publico pub = new Publico();
			pub.setDocumento(Long.parseLong(pDocumento));
			servicePub.validarPublico(pub);
			
			//retornar para o front os parametros de tipo e documento, jutamente com a sessao
			if (pub.getStatus() == true) {
				System.out.println(pub.getNome());
				
				HttpSession session=request.getSession();
				session.setAttribute("documento", pDocumento);  
		        session.setAttribute("publico", pub);
				response.sendRedirect("cadastro/cadastro.jsp");
			}else {
				response.sendRedirect("index.html");
			}
		
		//implementar frontend retornar documento e tipo ja definido
		}else if(action.equals("/CadastrarUsuario")) {
			CadastroService service = new CadastroService();
			
			String pDocumento = request.getParameter("documento");
			String pNome = request.getParameter("nome");
			String pTipo = request.getParameter("tipo");
			String pEndereco = request.getParameter("endereco");
			String pTelefone = request.getParameter("telefone");
			String pDocPrinc = request.getParameter("doc_cont");
			String pDocPrincNome = request.getParameter("doc_nome");
			String pDocPrincEmail = request.getParameter("doc_email");
			String pSenha = request.getParameter("senha");
			
			//Cadastros cad = new Cadastros(Integer.parseInt(pDocumento),pNome,pEndereco,Integer.parseInt(pTelefone),Integer.parseInt(pDocPrinc),pDocPrincNome,pDocPrincEmail, pSenha, pTipo);
			//adicionar cadastro
			//service.Incluir(cad);
			HttpSession session = request.getSession();
			session.removeAttribute("documento");
			session.invalidate();
			response.sendRedirect("index.html");
			
		}
	
	
	
	
	
	
	}

}
