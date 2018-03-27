package model;

public class Publico {
	
	private int documento;
	private String tipo;
	private boolean status;

	public Publico(int documento, String tipo) {
		this.documento = documento;
		this.tipo = tipo;
		status = false;
	}
	
	public Publico() {
		
	}
	
	public int getDocumento() {
		return documento;
	}
	public void setDocumento(int documento) {
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
