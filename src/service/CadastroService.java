package service;
import model.Cadastros;

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
		
		public void selectUser(Cadastros cad) {
			dao.selectCadastro(cad);
		}
		
		public void alterarCadastro(Cadastros cad) {
			dao.atualizarCad(cad);
		}
				
}
