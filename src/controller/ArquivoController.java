package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import model.Arquivos;
import service.ArquivoService;


@WebServlet("/ArquivoController.do")
@MultipartConfig
public class ArquivoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pAcao = request.getParameter("acao");
		
		if(pAcao.equals("uploadTermosAdmin")) {
			//pegando parametros do frontend
			String pNome = request.getParameter("nome");
			String pDocumento = request.getParameter("idAdm");
			Part filePart = request.getPart("arquivo");
		
			//transformar file em array de bytes
			InputStream filecontent = filePart.getInputStream();
			byte[] file = IOUtils.toByteArray(filecontent);
			
			Arquivos arquivo = new Arquivos();
			arquivo.setNome(pNome);
			arquivo.setDocumento(Long.parseLong(pDocumento));
			
			try {
			ArquivoService service = new ArquivoService();
			boolean retorno =service.inserirArquivoDownload(arquivo, file);
			System.out.println(retorno);
			
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		
		
		
		
	}

}
