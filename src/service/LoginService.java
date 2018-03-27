package service;

import dao.LoginDao;
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
}
