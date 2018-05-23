package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publico;
import service.PublicoService;
import utils.SendMail;

public class AlterarPublico implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pdocumento = request.getParameter("documento");
		String pEmail = request.getParameter("email");
		String pNome = request.getParameter("nome");
		
		System.out.println(pdocumento);
		
		Publico publico = new Publico();
		publico.setDocumento(Long.parseLong(pdocumento));
		publico.setEmail(pEmail);
		publico.setStatus(true);
		publico.setNome(pNome);
		PublicoService service = new PublicoService();
		service.alterarStatus(publico);
		try {
			String texto = "Parabéns "+publico.getNome()+" seu cadastro foi aprovado no Sistema,"
					+ "acesse o SkynetProject para concluir seu cadastro !!";
			String assunto = "PreCadastro Aporovado - "+publico.getDocumento();
			SendMail mail = new SendMail(texto, assunto);
			mail.sendEmailPublico(publico);
		}catch(Exception e) {
			System.out.println(e);
		}
		command.RetornarPublico.listarPublico(request, response);
		//response.sendRedirect(request.getContextPath() + "/perfil/administrador/index.jsp");

	}

}
