package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cadastros;
import service.CadastroService;
import service.PublicoService;

public class CadastrarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CadastroService service = new CadastroService();
		PublicoService serviceP = new PublicoService();
		
		String pDocumento = request.getParameter("documento");
		String pNome = request.getParameter("nome");
		String pTipo = request.getParameter("tipo");
		String pEmail = request.getParameter("email");
		String pEndereco = request.getParameter("endereco");
		String pTelefoneFixo = request.getParameter("telefone_fixo");
		pTelefoneFixo = pTelefoneFixo.replace("(", "");
		pTelefoneFixo = pTelefoneFixo.replace(")", "");
		pTelefoneFixo = pTelefoneFixo.replace("-", "");
		
		String pTelefoneCelular = request.getParameter("telefone_celular");
		pTelefoneCelular = pTelefoneCelular.replace("(", "");
		pTelefoneCelular = pTelefoneCelular.replace(")", "");
		pTelefoneCelular = pTelefoneCelular.replace("-", "");
		pTelefoneCelular = pTelefoneCelular.replace(" ", "");
	
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

	}

}
