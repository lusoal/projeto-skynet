package service;
import model.Administrador;
import model.Publico;

import java.util.ArrayList;

import dao.ManterAdministradorDao;

public class AdministradorService {
	
	
	  ManterAdministradorDao dao;

		public AdministradorService() {
			dao = new ManterAdministradorDao();
		}
		
		public void IncluirAdm(Administrador adm) {
			dao.IncluirAdm(adm);
		}
		
		public ArrayList<Publico> ValidarPublico(Publico publico) {
			return dao.RetornarPublico(publico);
		}
		
		public void RemoverAdm(Administrador adm) {
			dao.RemoverAdm(adm);
		}
	

}
