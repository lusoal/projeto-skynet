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
			PublicoService serviceP = new PublicoService();
			
			String pDocumento = request.getParameter("documento");
			String pNome = request.getParameter("nome");
			String pTipo = request.getParameter("tipo");
			String pEmail = request.getParameter("email");
			String pEndereco = request.getParameter("endereco");
			String pTelefoneFixo = request.getParameter("telefone_fixo");
			String pTelefoneCelular = request.getParameter("telefone_celular");
			String pContPrincNome = request.getParameter("cont_nome");
			String pContPrincDoc = request.getParameter("cont_doc");
			String pContPrincEmail = request.getParameter("cont_email");
			String pSite = request.getParameter("site");
			String pData = request.getParameter("data");
			String pSenha = request.getParameter("senha");
			
			Cadastros cad = new Cadastros(Long.parseLong(pDocumento), pNome, pTipo, pEmail, pEndereco, Long.parseLong(pTelefoneFixo), 
					Long.parseLong(pTelefoneCelular), pContPrincNome, Long.parseLong(pContPrincDoc), pContPrincEmail, pSenha, pSite, pData );
			
			//adicionar cadastro
			try {
				service.Incluir(cad);
				serviceP.deletarPublico(cad.getDocumento());
			}catch(Exception e) {
				System.out.println("Erro "+ e);
			}
			
			HttpSession session = request.getSession();
			session.removeAttribute("documento");
			session.invalidate();
			response.sendRedirect("index.html");
			
		}
	
	
	
	
	
	
	}

}
