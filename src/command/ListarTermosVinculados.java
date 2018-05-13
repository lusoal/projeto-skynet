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

public class ListarTermosVinculados implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String documento = request.getParameter("documento");
		Arquivos arquivo = new Arquivos();
		
		arquivo.setDocumento(Long.parseLong(documento));
		ArquivoService service = new ArquivoService();
		
		try {
			ArrayList<Arquivos> arquivos = service.listarArquivosUpload(arquivo);
			request.setAttribute("arquivo", arquivos);
			//implementar o tipo empresa
			if(tipo.equals("cartorio")) {
				RequestDispatcher view = request.getRequestDispatcher("perfil/cartorio/uploadTermos.jsp");
				view.forward(request, response);
			}else if(tipo.equals("empresa")) {
				RequestDispatcher view = request.getRequestDispatcher("perfil/empresa/uploadTermos.jsp");
				view.forward(request, response);
			}else if(tipo.equals("adicional")) {
				RequestDispatcher view = request.getRequestDispatcher("perfil/adicional/uploadTermos.jsp");
				view.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
