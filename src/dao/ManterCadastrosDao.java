package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionFactory;
import model.Cadastros;
import model.Publico;

public class ManterCadastrosDao {
		
		//Verificar opcao de enviar objeto publico ao inves de um array
		public String[] checkCad(Cadastros cad) {
			String sqlDelete = "SELECT status, nome, tipo FROM precadastro WHERE documento = ?";
			String[] listaVal = new String [3];
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);
				stm.setLong(1, cad.getDocumento());
				ResultSet rs = stm.executeQuery();	
				
				if(rs.next()) {
					int status = rs.getInt("status");
					String nome = rs.getString("nome");
					String tipo = rs.getString("tipo");
					
					
					if(status == 1) {
						System.out.println("status do banco 1");
						listaVal[0] = nome;
						listaVal[1] = tipo;
						listaVal[2] = "true";
						return listaVal;
					}else {
						return listaVal;
					}
				}else {
					//usuario nao possui pre cadastro feito, pensar em exibir mensagem
					return listaVal;
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			return listaVal;
		}
		
		
		public void Incluir(Cadastros cad) {
			String sqlInsert = "INSERT INTO cadastro (documento, nome, tipo, email, endereco, telefoneFixo, telefoneCelular, nomeContato, documentoContato, emailContato, senha, site, dataAbertura) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// Iniciar Conexao com o banco
			// Try para verificar se nao ocorre exeptions
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);
				stm.setLong(1, cad.getDocumento());
				stm.setString(2, cad.getNome());
				stm.setString(3, cad.getTipo());
				stm.setString(4, cad.getEmail());
				stm.setString(5, cad.getEndereco());
				stm.setInt(6, cad.getTelefoneFixo());
				stm.setInt(7, cad.getTelefoneCelular());
				stm.setString(8, cad.getNomeContato());
				stm.setInt(9, cad.getContatoDocumento());
				stm.setString(10, cad.getContatoEmail());
				stm.setString(11, cad.getSenha());
				stm.setString(12, cad.getSite());
				stm.setString(13, cad.getDataAbertura());
				stm.execute();
			} catch (SQLException e) {

				System.out.println(e);
			}
		}

		public void RemoverCadastro(Cadastros cad) {
			String sqlDelete = "DELETE FROM cadastros WHERE documento = ?";

			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);
				stm.setLong(1, cad.getDocumento());
				stm.execute();
				// Essa parte e necessaria para poder inserir um valor no ID para mostrar no
				// HTML gerado pelo Controller
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

		public ArrayList<Publico> RetornarPublico(Publico publico) {

			String sqlSelect = "SELECT * FROM cadPublico";
			ArrayList<Publico> p = new ArrayList<Publico>();
			
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				ResultSet rs = stm.executeQuery();	
				
				if(rs.next()) {
					publico.setDocumento(rs.getInt("documento"));
					publico.setTipo(rs.getString("tipo"));
					publico.setStatus(rs.getBoolean("status"));
					p.add(publico);
	
				}
			} catch (SQLException e) {
				System.out.println(e);
			}

			return p;

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
			stm.setInt(4, cad.getTelefoneCelular());
			stm.setInt(5, cad.getContatoDocumento());
			stm.setString(6, cad.getNomeContato());
			stm.setString(7, cad.getContatoEmail());
			stm.setString(8, cad.getSenha());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   	

}
