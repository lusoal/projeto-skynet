package service;
import model.Publico;
import dao.PublicoDao;

public class PublicoService {
	PublicoDao dao;

	public PublicoService() {
		dao = new PublicoDao();
	}
	
	public void InserirPublico(Publico publico) {
		dao.IncluirPublico(publico);
	}
	
	public long ValidarCnpj(Publico publico) {
		return dao.VerificarCadastro(publico);
	}
	
	public void deletarPublico(Publico publico) {
		dao.RemoverPublico(publico);
	}
	
}
