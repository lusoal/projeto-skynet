package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cadastros;
import service.CadastroService;

public class AdminVisualizarTodos implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			CadastroService service = new CadastroService();
			ArrayList<Cadastros> lista = service.selectAllCadastros();
			request.setAttribute("cadastros", lista);
			RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/mostrarTodos.jsp");
			view.forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
			}
		}
		

	}