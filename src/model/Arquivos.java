package model;

import java.sql.Blob;

public class Arquivos {

	private long id;
	private long documento;
	private String nome;
	private String data;
	private Blob content;
	
	
	public Arquivos(long id, long documento, String nome, String data) {
		this.id = id;
		this.documento = documento;
		this.nome = nome;
		this.data=data;
	}
	
	public Arquivos(String nome, Blob content) {
		this.nome = nome;
		this.content = content;
		
	}
	
	public Arquivos() {
		
	}
	
	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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
