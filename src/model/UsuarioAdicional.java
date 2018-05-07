package model;

public class UsuarioAdicional {

	private String nome;
	private long documento;
	private long documentoPrinc;
	private String email;
	private String senha;
	private String perfil;
	private boolean status;
	
	
	
	
	public UsuarioAdicional(String nome, long documento, long documentoPrinc, String email, String senha,
			String perfil, boolean status) {
		this.nome = nome;
		this.documento = documento;
		this.documentoPrinc = documentoPrinc;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
		this.status = status; 
	}
	
	public UsuarioAdicional() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public long getDocumentoPrinc() {
		return documentoPrinc;
	}
	public void setDocumentoPrinc(long documentoPrinc) {
		this.documentoPrinc = documentoPrinc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
