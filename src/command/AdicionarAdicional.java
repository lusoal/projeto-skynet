package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioAdicional;
import service.UsuarioAdicionalService;

public class AdicionarAdicional implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pDocumento = request.getParameter("documento");
		String pNome = request.getParameter("nome");
		String pEmail = request.getParameter("email");
		String pSenha = request.getParameter("senha");
		String pDocumentoPrincipal = request.getParameter("documentoPrincipal");
		String pPerfil = request.getParameter("perfil");
		
		String pTipo = request.getParameter("tipo");
		
		UsuarioAdicional adicional = new UsuarioAdicional(pNome, Long.parseLong(pDocumento), 
				Long.parseLong(pDocumentoPrincipal), pEmail, pSenha, pPerfil, false);
		UsuarioAdicionalService service = new UsuarioAdicionalService();
		
		try {
			service.adicionarUsuario(adicional);
			if(pTipo.equals("cartorio")) {
				command.ListarAdicional.listarUsuario(request, response);
				//response.sendRedirect(request.getContextPath() + "/perfil/cartorio/index.jsp");
			}else if (pTipo.equals("empresa")) {
				command.ListarAdicional.listarUsuario(request, response);
			}
			
		}catch(Exception e) {
			System.out.println("Erro Cadastro "+ e);
			response.sendRedirect("index.html");
			}

	}

}
