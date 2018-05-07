package service;

import dao.LoginDao;
import model.Cadastros;
import model.Login;

public class LoginService {
	LoginDao dao;

	public LoginService() {
		dao = new LoginDao();
	}

	public boolean SelectLogin(Login login) {
		return dao.SelectLogin(login);
	}
	
	public boolean ValidarSenha(Login login) {
		return dao.ValidarSenha(login);
	}
	
	public String selectTipo(Login login) {
		return dao.carregarTipo(login);
	}
	
	public boolean LoginAdicional(Login login) {
		return dao.LoginAdicional(login);
	}
	
	public void carregarAssociado(Login login, Cadastros cadastro) {
		dao.carregarAssociado(login, cadastro);
	}
	
	public boolean verificarSenha(Login login) {
		return dao.verificarSenhaAssociado(login);
	}
	
	public void alterarSenhaAssociado(Login login, String senha) {
		dao.alterarSenhaAssociado(login, senha);
	}
}
