package dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import connection.ConnectionFactory;
import model.Cadastros;
import model.Publico;

public class ManterCadastrosDao {
		public void Incluir(Cadastros cad) {
			String sqlInsert = "INSERT INTO cadastro (documento, nome, tipo, email, endereco, telefoneFixo, telefoneCelular, nomeContato, documentoContato, emailContato, senha, site, dataAbertura) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Date d = null;
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);
				SimpleDateFormat s = new SimpleDateFormat(("dd/MM/yyy"));
				
				try {
					d = s.parse(cad.getDataAbertura());
				}catch(Exception e) {
					System.out.println(e);
				}
				java.sql.Date sqlDate = new java.sql.Date(d.getTime());
				
				stm.setLong(1, cad.getDocumento());
				stm.setString(2, cad.getNome());
				stm.setString(3, cad.getTipo());
				stm.setString(4, cad.getEmail());
				stm.setString(5, cad.getEndereco());
				stm.setLong(6, cad.getTelefoneFixo());
				stm.setLong(7, cad.getTelefoneCelular());
				stm.setString(8, cad.getNomeContato());
				stm.setLong(9, cad.getContatoDocumento());
				stm.setString(10, cad.getContatoEmail());
				stm.setString(11, cad.getSenha());
				stm.setString(12, cad.getSite());
				stm.setDate(13, sqlDate);
				stm.execute();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		public void RemoverCadastro(Cadastros cad) {
			String sqlDelete = "DELETE FROM cadastro WHERE documento = ?";

			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);
				stm.setLong(1, cad.getDocumento());
				stm.execute();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		//Em desenvolvimento
		public void atualizarCad(Cadastros cad) {
		String sqlUpdate = "UPDATE adm SET nome=?, endereco=?, telefone=?, contatoDocumento=?, contatoNome=?, contatoEmail=? WHERE documento=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setLong(1, cad.getDocumento());
			stm.setString(2, cad.getNome());
			stm.setString(3, cad.getEndereco());
			stm.setLong(4, cad.getTelefoneCelular());
			stm.setLong(5, cad.getContatoDocumento());
			stm.setString(6, cad.getNomeContato());
			stm.setString(7, cad.getContatoEmail());
			stm.setString(8, cad.getSenha());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void selectCadastro(Cadastros cad) {
			
			String sqlSelect = "SELECT * from cadastro WHERE documento=?";
			
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				stm.setLong(1, cad.getDocumento());
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					cad.setNome(rs.getString("nome"));
					cad.setEmail(rs.getString("email"));
					cad.setEndereco(rs.getString("endereco"));
					cad.setTelefoneFixo(rs.getLong("telefoneFixo"));
					cad.setTelefoneCelular(rs.getLong("telefoneCelular"));
					cad.setNomeContato(rs.getString("nomeContato"));
					cad.setContatoDocumento(rs.getLong("documentoContato"));
					cad.setContatoEmail(rs.getString("emailContato"));
					cad.setSenha(rs.getString("senha"));
					cad.setSite(rs.getString("site"));
				}else {
					cad.setDocumento(-1);
				}
				
			}catch(SQLException e ) {
				System.out.println(e);
			}
			
			
		}
	
		
   	

}
