package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CadastroService;
import model.Cadastros;

public class AlterarCadastrosComAdm implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pDocumento = request.getParameter("documento");
		Cadastros cadastro = new Cadastros();
		cadastro.setDocumento(Long.parseLong(pDocumento));
		CadastroService service = new CadastroService();
		service.selectUser(cadastro);
		
		request.setAttribute("usuario", cadastro);
		request.setAttribute("documento2", pDocumento);
		RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/alterarCadastroColab.jsp");
		view.forward(request, response);
		

	}

}
