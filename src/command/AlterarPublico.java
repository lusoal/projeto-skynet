package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publico;
import service.PublicoService;

public class AlterarPublico implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pdocumento = request.getParameter("documento");
		
		System.out.println(pdocumento);
		
		Publico publico = new Publico();
		publico.setDocumento(Long.parseLong(pdocumento));
		publico.setStatus(true);
		PublicoService service = new PublicoService();
		service.alterarStatus(publico);
		command.RetornarPublico.listarPublico(request, response);
		//response.sendRedirect(request.getContextPath() + "/perfil/administrador/index.jsp");

	}

}
