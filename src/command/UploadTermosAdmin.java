package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Arquivos;
import service.ArquivoService;


public class UploadTermosAdmin implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entrou em Termos Admin");
		//pegando parametros do frontend
		String pNome = request.getParameter("nome");
		String pDocumento = request.getParameter("idAdm");
		Part filePart = request.getPart("arquivo");
		
		//transformar file em array de bytes
		//InputStream filecontent = filePart.getInputStream();
		//byte[] file = IOUtils.toByteArray(filecontent);
		
		Arquivos arquivo = new Arquivos();
		arquivo.setNome(pNome);
		arquivo.setDocumento(Long.parseLong(pDocumento));
		
		try {
			ArquivoService service = new ArquivoService();
			boolean retorno =service.inserirArquivoDownload(arquivo, filePart);
			System.out.println(retorno);
			ListarTermosAdminEmpresa admin = new ListarTermosAdminEmpresa();
			
			if(pNome.equals("termo_empresa")) admin.listarTermos(request, response);
			else {
				ListarTermosAdminCartorio command = new ListarTermosAdminCartorio();
				//Nao atualizar a pagina
				command.executar(request, response);
				//response.sendRedirect("perfil/administrador/index.jsp");
			}
				
			
		}catch(Exception e) {
			System.out.println(e);

	}


	}
}
