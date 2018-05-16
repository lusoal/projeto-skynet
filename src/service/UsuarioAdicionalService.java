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
	
	public ArrayList<UsuarioAdicional> listarUsuarios(UsuarioAdicional adicional, String nome) {
		String sqlSelect=null;
		System.out.println(nome);
		if(nome.isEmpty()) {
			sqlSelect = "select documento, nome, email, perfil from usuarioAdicional where documentoPrincipal=?";
		}else {
			sqlSelect = "select documento, nome, email, perfil from usuarioAdicional where documentoPrincipal=? AND nome like "+"'"+nome+"%'";
		}
		return dao.listarAdicional(adicional, sqlSelect);
	}
	
	public void listarMeuCadastro(UsuarioAdicional adicional) {
		dao.listarMeuCadastro(adicional);
	}
	
	public void alterarUsuarioAdicional(UsuarioAdicional adicional) {
		dao.alterarCadastroAdicional(adicional);
	}
}

