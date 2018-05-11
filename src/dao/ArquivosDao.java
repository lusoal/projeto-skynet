package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.sql.Blob;

import connection.ConnectionFactory;
import model.Arquivos;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ArquivosDao {
	
	public boolean inserirArquivoDownload(Arquivos arquivo, byte[] file) {
		
		String sqlInsert = "INSERT INTO downloadArquivos (documentoAdm, nome, data, conteudo) VALUES(?, ?, ?, ?)";
		//Iniciar Conexao com o banco
		//Try para verificar se nao ocorre exeptions
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			
		    Date dataAtual = new Date(System.currentTimeMillis());
		    java.sql.Date sqlDate = new java.sql.Date(dataAtual.getTime());
			
			stm.setLong(1,arquivo.getDocumento());
			stm.setString(2, arquivo.getNome());
			stm.setDate(3, sqlDate);
			stm.setBytes(4, file);
			
			stm.execute();
			return true;
		
		}catch(SQLException e) {
			
			System.out.println(e);
		}
		return false;
	}
	
	
	public boolean inserirArquivoUpload(Arquivos arquivo, byte[] file) {
			
			String sqlInsert = "INSERT INTO uploadArquivos (documentoPrincipal, nome, data, conteudo) VALUES(?, ?, ?, ?)";
			//Iniciar Conexao com o banco
			//Try para verificar se nao ocorre exeptions
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);
				
			    Date dataAtual = new Date(System.currentTimeMillis());
			    java.sql.Date sqlDate = new java.sql.Date(dataAtual.getTime());
				
				stm.setLong(1,arquivo.getDocumento());
				stm.setString(2, arquivo.getNome());
				stm.setDate(3, sqlDate);
				stm.setBytes(4, file);
				
				stm.execute();
				return true;
			
			}catch(SQLException e) {
				
				System.out.println(e);
			}
			return false;
		}
	
	public ArrayList<Arquivos> listarArquivosDownloads(String tipo, String perfil) throws SQLException {
		String sqlSelect="";
		Connection conn = ConnectionFactory.realizarConexao();
		ArrayList<Arquivos> arquivos = new ArrayList<Arquivos>();
		if(tipo.equals("Admin")) {
			if(perfil.equals("Empresa")) {
				sqlSelect="Select id, data from downloadArquivos where nome = 'termo_empresa' order by id DESC LIMIT 5";
			}else {
				sqlSelect="Select id, data from downloadArquivos where nome = 'termo_cartorio' order by id DESC LIMIT 5";
			}
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				Arquivos file = new Arquivos();
				file.setId(rs.getLong("id"));
				file.setData(rs.getString("data"));
				arquivos.add(file);
			}	
		}
		return arquivos;
		
	}
	
	
	public ArrayList<Arquivos> listarArquivosUpload(Arquivos arquivo) throws SQLException {
		String sqlSelect="SELECT * FROM uploadArquivos where documentoPrincipal = ? order by id DESC LIMIT 5";
		Connection conn = ConnectionFactory.realizarConexao();
		
		ArrayList<Arquivos> arquivos = new ArrayList<Arquivos>();
		
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		stm.setLong(1,arquivo.getDocumento());
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			Arquivos file = new Arquivos();
			file.setId(rs.getLong("id"));
			file.setData(rs.getString("data"));
			arquivos.add(file);
		}	
		return arquivos;
	}
		
	public void downloadArquivo(String tipo, Arquivos arquivo) throws SQLException, IOException {
		String sqlSelect = null;
		System.out.println("Entrei aqui");
		if(tipo.equals("Administrador")) {
			sqlSelect ="SELECT * FROM downloadArquivos where id = ?";
		}else {
			sqlSelect ="SELECT * FROM uploadArquivos where id = ?";
		}
		Connection conn = ConnectionFactory.realizarConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		//Id do documento e nao do documento de quem fez o upload
		stm.setLong(1, arquivo.getId());
		ResultSet rs = stm.executeQuery();
		
		 if ( rs.next() ){
			 Blob blob = rs.getBlob("conteudo");
			 String nome = rs.getString("nome");
			 String data = rs.getString("data");
			 
			 arquivo.setContent(blob);
			 arquivo.setNome(nome+"_"+data);	 
		 }
		 
		
		
		
	}
	
	public void termoPreCadastro(String tipo, Arquivos arquivo) throws SQLException {
		String sqlSelect = "";
		
		if(tipo.equals("Empresa")) {
			sqlSelect = "select * from downloadArquivos where nome='termo_empresa' order by id desc limit 1";
		}else {
			sqlSelect = "select * from downloadArquivos where nome='termo_cartorio' order by id desc limit 1";
		}
		Connection conn = ConnectionFactory.realizarConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		
		ResultSet rs = stm.executeQuery();
		
		if(rs.next()) {
			arquivo.setData(rs.getString("data"));
			arquivo.setId(rs.getLong("id"));
		}	
	}
	
	}
	

