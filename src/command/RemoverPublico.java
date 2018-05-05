package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publico;
import service.PublicoService;

public class RemoverPublico implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pdocumento = request.getParameter("documento");
		System.out.println(pdocumento+" vai ser deletado");
		Publico publico = new Publico();
		publico.setDocumento(Long.parseLong(pdocumento));
		PublicoService service = new PublicoService();
		service.deletarPublico(publico.getDocumento());
		command.RetornarPublico.listarPublico(request, response);
		//response.sendRedirect(request.getContextPath() + "/perfil/administrador/index.jsp");

	}

}
