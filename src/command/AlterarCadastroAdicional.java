package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UsuarioAdicionalService;
import model.UsuarioAdicional;

public class AlterarCadastroAdicional implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
		String pDocumento = request.getParameter("documento");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		
		UsuarioAdicionalService service = new UsuarioAdicionalService();
		UsuarioAdicional adicional = new UsuarioAdicional();
		adicional.setDocumento(Long.parseLong(pDocumento));
		adicional.setNome(pNome);
		adicional.setEmail(pEmail);
		service.alterarUsuarioAdicional(adicional);
		
		ListarCadastroAdd listar = new ListarCadastroAdd();
		listar.executar(request, response);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
		

	}

}
