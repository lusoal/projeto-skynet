package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publico;
import service.PublicoService;

public class RetornarPublico implements Command {
	
	public static void listarPublico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PublicoService serv = new PublicoService();
		ArrayList<Publico> p = serv.retornaTodoPublico("");
		request.setAttribute("arrayPublico", p);
		RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/StatusCadastros.jsp");
		view.forward(request, response);
	}
	
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Nome nesse caso e para realizar a busca
		String nome = request.getParameter("nome");
		System.out.println(nome);
		if(nome == null) {
			nome="";
		}
		PublicoService serv = new PublicoService();
		ArrayList<Publico> p = serv.retornaTodoPublico(nome);
		request.setAttribute("arrayPublico", p);
		RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/StatusCadastros.jsp");
		view.forward(request, response);

	}

}
