package model;

public class Administrador {
	private int documento;
	private String nome;
	private String endereco;
	private int telefone;
	private int contatoDocumento;
	private String contatoNome;
	private String contatoEmail;
	private String senha;

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getContatoDocumento() {
		return contatoDocumento;
	}

	public void setContatoDocumento(int contatoDocumento) {
		this.contatoDocumento = contatoDocumento;
	}

	public String getContatoNome() {
		return contatoNome;
	}

	public void setContatoNome(String contatoNome) {
		this.contatoNome = contatoNome;
	}

	public String getContatoEmail() {
		return contatoEmail;
	}

	public void setContatoEmail(String contatoEmail) {
		this.contatoEmail = contatoEmail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
