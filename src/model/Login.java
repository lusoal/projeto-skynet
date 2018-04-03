package model;

public class Login {
	private int documento;
	private String senha;

	public Login(int documento, String senha) {
		this.documento = documento;
		this.senha = senha;
	}

	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
		this.documento = documento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
