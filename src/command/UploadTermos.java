package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Arquivos;
import service.ArquivoService;

public class UploadTermos implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//pegando parametros do frontend
		String pNome = request.getParameter("nome");
		String pDocumento = request.getParameter("documento");
		Part filePart = request.getPart("arquivo");
		
		String pTipo = request.getParameter("tipo");
		
		//transformar file em array de bytes
		//InputStream filecontent = filePart.getInputStream();
		//byte[] file = IOUtils.toByteArray(filecontent);
		
		Arquivos arquivo = new Arquivos();
		arquivo.setNome(pNome);
		arquivo.setDocumento(Long.parseLong(pDocumento));
		
		try {
			ArquivoService service = new ArquivoService();
			boolean retorno =service.inserirArquivoUpload(arquivo, filePart);
			System.out.println(retorno);
			if(pTipo.equals("cartorio")) {
				ListarTermosVinculados termos = new ListarTermosVinculados();
				termos.executar(request, response);
				//response.sendRedirect("perfil/empresa/index.jsp");
				
			}else if(pTipo.equals("empresa")) {
				ListarTermosVinculados termos = new ListarTermosVinculados();
				termos.executar(request, response);
				//response.sendRedirect("perfil/empresa/index.jsp");
			}
		}catch(Exception e) {
			System.out.println(e);
		}	

	}

}
