package command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ArquivoService;
import model.Arquivos;

public class PreCadastroTermos implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArquivoService service = new ArquivoService();
		
		Arquivos empresa = new Arquivos();
		Arquivos cartorio = new Arquivos();
		
		try {
		service.termoPreCadastro("Empresa", empresa);
		service.termoPreCadastro("Cartorio", cartorio);
		
		request.setAttribute("Empresa", empresa);
		request.setAttribute("Cartorio", cartorio);
		RequestDispatcher view = request.getRequestDispatcher("cadastro/precadastro.jsp");
		view.forward(request, response);
		
		}catch(SQLException e) {
			System.out.println(e);
		}
	}

}
