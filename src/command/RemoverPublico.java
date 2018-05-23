package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publico;
import service.PublicoService;
import utils.SendMail;

public class RemoverPublico implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pdocumento = request.getParameter("documento");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		
		System.out.println(pdocumento+" vai ser deletado");
		Publico publico = new Publico();
		publico.setDocumento(Long.parseLong(pdocumento));
		publico.setNome(pNome);
		publico.setEmail(pEmail);
		PublicoService service = new PublicoService();
		service.deletarPublico(publico.getDocumento());
		try {
			String assunto = "PreCadastro Recusado - Skynet Project " + publico.getDocumento();
			String texto = "Desculpe, "+ publico.getNome()+" seu PréCadastro foi recusado, desculpe !";
			SendMail mail = new SendMail(texto, assunto);
			mail.sendEmailPublico(publico);
		}catch(Exception e) {
			System.out.println(e);
		}
		command.RetornarPublico.listarPublico(request, response);
		//response.sendRedirect(request.getContextPath() + "/perfil/administrador/index.jsp");

	}

}
