package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.Command;

@MultipartConfig
@WebServlet("/controller.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws
	ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
				Command comando =
				//instancia a classe que veio como parametro e chama o metodo executar
				(Command)Class.forName("command."+request.getParameter("command")).newInstance();
				System.out.println("Teste:  "+request.getParameter("command"));
				//command nome do pacote
				comando.executar(request, response);
				System.out.println(comando);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
				throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doExecute(request, response);
	}

}
