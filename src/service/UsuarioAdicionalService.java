package service;
import model.UsuarioAdicional;

import java.util.ArrayList;

import dao.UsuarioAdicionalDao;

public class UsuarioAdicionalService {
	UsuarioAdicionalDao dao;
	
	public UsuarioAdicionalService() {
		
		dao = new UsuarioAdicionalDao();
		
	}

	
	public void adicionarUsuario(UsuarioAdicional adicional) {
		dao.incluirAdicional(adicional);
	}
	
	public ArrayList<UsuarioAdicional> listarUsuarios(UsuarioAdicional adicional) {
		return dao.listarAdicional(adicional);
	}
}

