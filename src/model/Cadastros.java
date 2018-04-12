package model;

public class Cadastros {
	private long documento;
	private String nome;
	private String tipo;
	private String email;
	private String endereco;
	private int telefoneFixo;
	private int telefoneCelular;
	private String nomeContato;
	private int contatoDocumento;
	private String contatoEmail;
	private String senha;
	private String site;
	private String dataAbertura;
	
	public Cadastros(long documento, String nome, String tipo, String email, String endereco, int telefoneFixo,
			int telefoneCelular, String nomeContato, int contatoDocumento, String contatoEmail, String senha,
			String site, String dataAbertura) {
		this.documento = documento;
		this.nome = nome;
		this.tipo = tipo;
		this.email = email;
		this.endereco = endereco;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.nomeContato = nomeContato;
		this.contatoDocumento = contatoDocumento;
		this.contatoEmail = contatoEmail;
		this.senha = senha;
		this.site = site;
		this.dataAbertura = dataAbertura;
	}

	public Cadastros() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(int telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(String dataAbertura) {
		this.dataAbertura = dataAbertura;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(int telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public int getContatoDocumento() {
		return contatoDocumento;
	}

	public void setContatoDocumento(int contatoDocumento) {
		this.contatoDocumento = contatoDocumento;
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
