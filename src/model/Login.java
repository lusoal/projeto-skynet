package model;

public class Login {
	private int documento;
	private String senha;
	private String tipo;

	public Login(int documento, String senha, String tipo) {
		this.documento = documento;
		this.senha = senha;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
