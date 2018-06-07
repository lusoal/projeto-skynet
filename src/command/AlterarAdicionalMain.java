package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UsuarioAdicional;

public class AlterarAdicionalMain implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String documento = request.getParameter("documento");
		String perfil = request.getParameter("perfil");
		String email = request.getParameter("email");
		
		System.out.println(email);
		
		//necessario o tipo para fazer o envio para o frontend correto
		String tipo = request.getParameter("tipo");
		
		UsuarioAdicional adicional = new UsuarioAdicional();
		
		adicional.setNome(nome);
		adicional.setDocumento(Long.parseLong(documento));
		adicional.setPerfil(perfil);
		adicional.setEmail(email);
		
		//define objeto de adicional para ser enviado para o front end
		request.setAttribute("adicional", adicional);
		
		if(tipo.equals("cartorio")) {
			RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/alterarAdicional.jsp");
			view.forward(request, response);
		}if(tipo.equals("empresa")) {
			RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/alterarAdicional.jsp");
			view.forward(request, response);
		}
	}

}
