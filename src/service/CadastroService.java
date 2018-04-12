package service;
import model.Cadastros;
import model.Publico;

import java.util.ArrayList;

import dao.ManterCadastrosDao;

public class CadastroService {
	
	
	  ManterCadastrosDao dao;

		public CadastroService() {
			dao = new ManterCadastrosDao();
		}
		
		public void Incluir(Cadastros cad) {
			dao.Incluir(cad);
		}
		
		public void Remover(Cadastros cad) {
			dao.RemoverCadastro(cad);
		}
		
		public String[] validarPreCad(Cadastros cad) {
			return dao.checkCad(cad);
		}
		
		//Action implementada somente para o ADM
		public ArrayList<Publico> ValidarPublico(Publico publico) {
			return dao.RetornarPublico(publico);
		}

}
