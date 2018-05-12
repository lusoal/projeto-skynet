package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cadastros;
import service.CadastroService;

public class ListarCadastroAdcional implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String pDocumentoCadastro = request.getParameter("documento");
		
		CadastroService service = new CadastroService();
		
		Cadastros cadastro = new Cadastros();
		cadastro.setDocumento(Long.parseLong(pDocumentoCadastro));

		service.selectUser(cadastro);
		
		request.setAttribute("empresa", cadastro);
		RequestDispatcher view = request.getRequestDispatcher("perfil/adicional/alterarCadastro.jsp");
		
		view.forward(request, response);
		
		
		
		
	}
	

}