package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioAdicional;
import service.UsuarioAdicionalService;

public class ListarAdicional implements Command {
	
	//Verificar possibilidade de utilizar esse metodo em baixo
	public static void listarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pTipo = request.getParameter("tipo");
		String pDocumentoPrincipal = request.getParameter("documentoPrincipal");
		
		UsuarioAdicional adicional = new UsuarioAdicional();
		
		adicional.setDocumentoPrinc(Long.parseLong(pDocumentoPrincipal));
		
		UsuarioAdicionalService service = new UsuarioAdicionalService();
		
		ArrayList<UsuarioAdicional> ua = service.listarUsuarios(adicional, "");
		request.setAttribute("arrayAdicional", ua);
		
		//alterar para onde vai enviar, cartorio ou empresa
		if(pTipo.equals("cartorio")) {
			RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/listaUsuarios.jsp");
			view.forward(request, response);
		}if(pTipo.equals("empresa")) {
			RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/listaUsuarios.jsp");
			view.forward(request, response);
		}
		
		
	}

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pTipo = request.getParameter("tipo");
		String pNome = request.getParameter("nome");
		String pDocumentoPrincipal = request.getParameter("documentoPrincipal");
		
		System.out.println(pNome);
		
		if(pNome == null) {
			pNome="";
		}

		
		UsuarioAdicional adicional = new UsuarioAdicional();
		
		adicional.setDocumentoPrinc(Long.parseLong(pDocumentoPrincipal));
		
		UsuarioAdicionalService service = new UsuarioAdicionalService();
		
		ArrayList<UsuarioAdicional> ua = service.listarUsuarios(adicional, pNome);
		request.setAttribute("arrayAdicional", ua);
		
		//alterar para onde vai enviar, cartorio ou empresa
		if(pTipo.equals("cartorio")) {
			RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/listaUsuarios.jsp");
			view.forward(request, response);
		}if(pTipo.equals("empresa")) {
			RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/listaUsuarios.jsp");
			view.forward(request, response);
		}

	}

}
