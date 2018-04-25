package service;

import model.Arquivos;
import dao.ArquivosDao;

public class ArquivoService {
	ArquivosDao dao;
	
	public ArquivoService() {
		dao = new ArquivosDao();
	}
	
	public boolean inserirArquivoDownload(Arquivos arquivo, byte[] file) {
		boolean retorno = dao.inserirArquivoDownload(arquivo, file);
		return retorno;	
	}

}
