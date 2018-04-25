package model;

public class Arquivos {

	private long id;
	private long documento;
	private String nome;
	
	public Arquivos(long id, long documento, String nome) {
		this.id = id;
		this.documento = documento;
		this.nome = nome;
	}
	
	public Arquivos() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getDocumento() {
		return documento;
	}
	public void setDocumento(long documento) {
		this.documento = documento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
}
