package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioAdicional;
import service.UsuarioAdicionalService;

public class ListarCadastroAdd implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		//Traz documento do usuario adicional do front
		String pDocumento = request.getParameter("documento");
		
		UsuarioAdicional usuario = new UsuarioAdicional();
		usuario.setDocumento(Long.parseLong(pDocumento));
		UsuarioAdicionalService service = new UsuarioAdicionalService();
		service.listarMeuCadastro(usuario);
		
		request.setAttribute("usuario", usuario);
		RequestDispatcher view = request.getRequestDispatcher("perfil/adicional/alterarCadastroProprio.jsp");
		view.forward(request, response);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		

	}

}
