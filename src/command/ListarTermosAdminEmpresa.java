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

public class ListarTermosAdminEmpresa implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = "Admin";
		String perfil="Empresa";
		ArquivoService service = new ArquivoService();
		try {
			ArrayList<Arquivos> arquivos = service.listarArquivosDownload(tipo, perfil);
			request.setAttribute("arquivo", arquivos);
			RequestDispatcher view = request.getRequestDispatcher("perfil/administrador/termosEmpresa.jsp");
			view.forward(request, response);
		} catch (SQLException e) {
			System.out.println("erro "+e);
		}
		
	}
	
	public void listarTermos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		executar(request,response);
	}

}
