package service;

import model.Arquivos;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import java.util.ArrayList;
import javax.servlet.http.Part;

import dao.ArquivosDao;


public class ArquivoService {
	ArquivosDao dao;
	
	public ArquivoService() {
		dao = new ArquivosDao();
	}
	
	public boolean inserirArquivoDownload(Arquivos arquivo, Part filePart) throws IOException {
		//transformar file em array de bytes
		InputStream filecontent = filePart.getInputStream();
		byte[] file = IOUtils.toByteArray(filecontent);
		boolean retorno = dao.inserirArquivoDownload(arquivo, file);
		return retorno;	
	}
	
	public ArrayList<Arquivos> listarArquivosDownload(String tipo, String perfil) throws SQLException{
		ArrayList<Arquivos> arquivos = dao.listarArquivosDownloads(tipo, perfil);
		return arquivos;
		
	}

}
