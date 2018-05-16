package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cadastros;
import service.CadastroService;

public class ListarUsuario implements Command {
	
	public static void listarAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroService service = new CadastroService();
		String pDocumento = request.getParameter("documento");
		Cadastros cad = new Cadastros();
		cad.setDocumento(Long.parseLong(pDocumento));
		service.selectUser(cad);
		System.out.println("Selecionei o usuario "+pDocumento);
		request.setAttribute("usuario", cad);
		RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/alterarCadastro.jsp");
		view.forward(request, response);
	}
	
	public static void listarCartorio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroService service = new CadastroService();
		String pDocumento = request.getParameter("documento");
		Cadastros cad = new Cadastros();
		cad.setDocumento(Long.parseLong(pDocumento));
		service.selectUser(cad);
		System.out.println("Selecionei o usuario "+pDocumento);
		request.setAttribute("usuario", cad);
		RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/alterarCadastro.jsp");
		view.forward(request, response);
	}
	
	public static void listarEmpresa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastroService service = new CadastroService();
		String pDocumento = request.getParameter("documento");
		Cadastros cad = new Cadastros();
		cad.setDocumento(Long.parseLong(pDocumento));
		service.selectUser(cad);
		System.out.println("Selecionei o usuario "+pDocumento);
		request.setAttribute("usuario", cad);
		RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/alterarCadastro.jsp");
		view.forward(request, response);
	}
	
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Command Listar Usuarios");
		String pTipo = request.getParameter("tipo");
		if(pTipo.equals("administrador")) listarAdministrador(request, response);
		if(pTipo.equals("cartorio")) listarCartorio(request, response);
		if(pTipo.equals("empresa")) listarEmpresa(request, response);

	}

}
