package command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Arquivos;
import service.ArquivoService;

public class ListarTermosGerais implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = "Admin";
		//String perfil="Cartorio";
		
		String  pPerfil = request.getParameter("tipo");
		String adicional = request.getParameter("adicional");
		if(adicional == null) {
			adicional = "false";
		}
		
		ArquivoService service = new ArquivoService();
		System.out.println(pPerfil);
		System.out.println(adicional);
		
		try {
			ArrayList<Arquivos> arquivos = service.listarArquivosDownload(tipo, pPerfil);
			request.setAttribute("arquivo", arquivos);
			
			if(pPerfil.equals("Cartorio") || pPerfil.equals("cartorio")) {
				if(adicional.equals("true")) {
					System.out.println("Usuario Adicional de Cartorio");
					RequestDispatcher view = request.getRequestDispatcher("perfil/adicional/termosEmpresa.jsp");
					view.forward(request, response);
				}else {
					RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/termosCartorio.jsp");
					view.forward(request, response);
				}
			}else if(pPerfil.equals("Empresa") || pPerfil.equals("empresa")) {
				if(adicional.equals("true")) {
					System.out.println("Usuario Adicional de Empresa");
					RequestDispatcher view = request.getRequestDispatcher("perfil/adicional/termosEmpresa.jsp");
					view.forward(request, response);
				}else {
					RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/termosEmpresa.jsp");
					view.forward(request, response);
				}
			}
			
		} catch (SQLException e) {
			System.out.println("erro "+e);
		}
		
	}

}
