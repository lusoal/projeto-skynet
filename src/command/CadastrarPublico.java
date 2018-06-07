package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.SendMail;

import model.Publico;
import service.PublicoService;

public class CadastrarPublico implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Cadastrar Publico Command");
		String pDocumento = request.getParameter("documento");
		pDocumento = pDocumento.replace(".", "");
		pDocumento = pDocumento.replace("-", "");
		pDocumento = pDocumento.replace("/", "");
		
		String pTipo = request.getParameter("tipo");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		
		Publico publico = new Publico(Long.parseLong(pDocumento),pTipo, pNome, pEmail);
		PublicoService pService = new PublicoService();
		
		long testeCnpj = pService.ValidarCnpj(publico);
		if (testeCnpj != -1) {
			pService.InserirPublico(publico);
			try {
				String assunto = "PreCadastro Efetuado - Skynet Project " + publico.getDocumento();
				String texto = "ParabÈns, "+ publico.getNome()+" seu PrÈCadastro foi efetuado com sucesso no sistema.";
				SendMail mail = new SendMail(texto, assunto);
				mail.sendEmailPublico(publico);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			response.sendRedirect("index.html");
		}else {
			//Tratamento de erro no frontend
			String erro;
			if (testeCnpj == -1) {
				erro = "Usu√°rio ja cadastrado, o documento "+pDocumento + " j√° se encontra em nossa base de dados.";
			}else {
				erro = "Nao foi possivel cadastrar, entre em contato com o administrador.";
			}
			request.setAttribute("erro", erro);
			RequestDispatcher view = request.getRequestDispatcher("errors/erro.jsp");
			view.forward(request, response);
		}

	}

}
