package model;

public class Publico {
	
	private long documento;
	private String tipo;
	private boolean status;
	private String nome;

	public Publico(long documento, String tipo, String nome) {
		this.documento = documento;
		this.tipo = tipo;
		status = false;
		this.nome = nome;
	}
	
	public Publico() {
		
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
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
