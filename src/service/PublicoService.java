package service;
import model.Publico;

import java.util.ArrayList;

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
	
	public void deletarPublico(long documento) {
		dao.RemoverPublico(documento);
	}
	
	public void validarPublico(Publico publico) {
		dao.verificarPublico(publico);
	}
	
	public ArrayList<Publico> retornaTodoPublico(String nome) {
		String sqlSelect=null;
		System.out.println(nome);
		if(nome.isEmpty()) {
			sqlSelect="SELECT * FROM precadastro where status != 1";
		}else {
			sqlSelect="SELECT * FROM precadastro where status != 1 AND nome like "+"'"+nome+"%'";
		}
		System.out.println(sqlSelect);
		return dao.RetornarPublico(sqlSelect);
	}
	
	public void alterarStatus(Publico pub) {
		dao.alterarStatus(pub);
	}
}
