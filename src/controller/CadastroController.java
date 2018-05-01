package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
import controller.Logout;


@WebServlet("/CadastroController.do")
public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void listarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroService service = new CadastroService();
		String pDocumento = request.getParameter("documento");
		Cadastros cad = new Cadastros();
		cad.setDocumento(Long.parseLong(pDocumento));
		service.selectUser(cad);
		System.out.println("Selecionei o usuario "+pDocumento);
		request.setAttribute("usuario", cad);
		RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/alterarCadastro.jsp");
		view.forward(request, response);
	}
	
	public void listarCartorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroService service = new CadastroService();
		String pDocumento = request.getParameter("documento");
		Cadastros cad = new Cadastros();
		cad.setDocumento(Long.parseLong(pDocumento));
		service.selectUser(cad);
		System.out.println("Selecionei o usuario "+pDocumento);
		request.setAttribute("usuario", cad);
		RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/alterarCadastro.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		
		//Verificar a duplicidade de criacao de servicePub
		PublicoService servicePub = new PublicoService();
		
		if(pAcao.equals("verificarPre")) {
			String pDocumento = request.getParameter("documento");
			pDocumento = pDocumento.replace(".", "");
			pDocumento = pDocumento.replace("-", "");
			pDocumento = pDocumento.replace("/", "");
			
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
				//implementar mensagem de erro no pre cadastro
				response.sendRedirect("index.html");
			}
		
		}else if(pAcao.equals("cadastrarUsuario")) {
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
				//Implementar erro ao cadastrar o usuario
				System.out.println("Erro "+ e);
			}
			
			//Faz o Invalidate da sessao e retorna para o front
			HttpSession session = request.getSession();
			session.removeAttribute("documento");
			session.invalidate();
			response.sendRedirect("index.html");
			//Informar usuario ja cadastrado na Index
			
		}else if(pAcao.equals("cancelarCadastro")) {
			Logout logout = new Logout();
			logout.doPost(request, response);
		
			
		}else if(pAcao.equals("listarUsuario")) {
			listarUsuarios(request, response);
		
		}else if(pAcao.equals("alterarCadastro")) {
			//tipo e necessario para saber para onde sera feito o redirect
			String pTipo = request.getParameter("tipo");
			
			String pDocumento = request.getParameter("documento");
			String pNome = request.getParameter("nome");
			System.out.println(pNome);
			String pEmail = request.getParameter("email");
			String pEndereco = request.getParameter("endereco");
			String pTelefoneFixo = request.getParameter("telefone_fixo");
			String pTelefoneCelular = request.getParameter("telefone_celular");
			String pContPrincNome = request.getParameter("cont_nome");
			String pContPrincDoc = request.getParameter("cont_doc");
			String pContPrincEmail = request.getParameter("cont_email");
			String pSite = request.getParameter("site");
			
			String pSenha = request.getParameter("senha");
			
			CadastroService service = new CadastroService();
			Cadastros cad = new Cadastros(Long.parseLong(pDocumento), pNome, null, pEmail, pEndereco, Long.parseLong(pTelefoneFixo), 
					Long.parseLong(pTelefoneCelular), pContPrincNome, Long.parseLong(pContPrincDoc), pContPrincEmail, pSenha, pSite, null );
			try {
				//verificar possibilidade de enviar uma mensagem com cadastro alterado
				service.alterarCadastro(cad);
				if(pTipo.equals("Administrador")) {
					listarUsuarios(request, response);
				}else if(pTipo.equals("Cartorio")) {
					listarCartorio(request, response);
				}
			}catch(Exception e) {
				System.out.println("Erro atualizar cadastro");
			}
			
			
		}
	
	}
	

}
