package command;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Arquivos;
import service.ArquivoService;

public class DownloadTermos implements Command {
	private static final int BUFFER_SIZE = 4096;
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String tipo = request.getParameter("tipo");
		String id = request.getParameter("id");
		
		//Descobrir maneira de pegar o path com o frontend
		String path = request.getParameter("path");
				
		System.out.println(path);
		
		ArquivoService service = new ArquivoService();
		try {
			//Aqui ja sabe qual o arquivo que eu quero
			
			Arquivos arquivo = new Arquivos();
			arquivo.setId(Long.parseLong(id));
			
			service.downloadArquivos(tipo, arquivo);
			
			InputStream inputStream = arquivo.getContent().getBinaryStream();
			int fileLength = inputStream.available();
		
			System.out.println("Tamanho do arquivo "+fileLength);
			String mimeType = "application/octet-stream";
			response.setContentType(mimeType);
            response.setContentLength(fileLength);
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", arquivo.getNome()+".pdf");
            response.setHeader(headerKey, headerValue);
			
            
            // writes the file to the client
            OutputStream outStream = response.getOutputStream();
             
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
             
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
             
            inputStream.close();
            outStream.close();  
			System.out.println("fiz o download");
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}

	}

}
