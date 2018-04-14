package model;

public class Login {
	private long documento;
	private String senha;

	public Login(long documento, String senha) {
		this.documento = documento;
		this.senha = senha;
	}

	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
