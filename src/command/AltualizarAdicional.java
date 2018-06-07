package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioAdicional;
import service.UsuarioAdicionalService;

public class AltualizarAdicional implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String documento = request.getParameter("documento");
		String perfil = request.getParameter("perfil");
		String email = request.getParameter("email");
		
		//necessario o tipo para fazer o envio para o frontend correto
		String tipo = request.getParameter("tipo");
		String pDocumentoPrincipal = request.getParameter("documentoPrincipal");
		
		System.out.println("Documento da conta: "+pDocumentoPrincipal);
		System.out.println("Documento do usuario: "+documento);
		
		UsuarioAdicional adicional = new UsuarioAdicional();
		try {
		adicional.setNome(nome);
		adicional.setDocumento(Long.parseLong(documento));
		adicional.setPerfil(perfil);
		adicional.setEmail(email);
		
		UsuarioAdicionalService service = new UsuarioAdicionalService();
		service.alterarUsuarioAdicional(adicional);
		
		//Cartorio e empresa ja e trtado nessa classe
		ListarAdicional.listarUsuario(request, response);
	
		
		}catch(Exception e) {
			//Realizar Log
			System.out.println(e);
		}

	}

}
