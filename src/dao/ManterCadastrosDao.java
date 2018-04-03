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
	
	   //Verificar se o usuario esta habilitado para se cadastrar
		public boolean checkCad(Cadastros cad) {
			String sqlDelete = "SELECT status FROM cadPublico WHERE documento = ?";
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);
				stm.setInt(1, cad.getDocumento());
				ResultSet rs = stm.executeQuery();	
	
				if(rs.next()) {
					int status = rs.getInt("status");
					if(status == 1) {
						System.out.println("status do banco 1");
						return true;
					}else {
						return false;
					}
				}else {
					//usuario nao possui pre cadastro feito, pensar em exibir mensagem
					return false;
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			return false;
		}
		
		
		public void Incluir(Cadastros cad) {
			String sqlInsert = "INSERT INTO cadastros (documento, nome, tipo, endereco, telefone, contato_documento, contato_nome, contato_email, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			// Iniciar Conexao com o banco
			// Try para verificar se nao ocorre exeptions
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);
				stm.setInt(1, cad.getDocumento());
				stm.setString(2, cad.getNome());
				stm.setString(3, cad.getTipo());
				stm.setString(4, cad.getEndereco());
				stm.setInt(5, cad.getTelefone());
				stm.setInt(6, cad.getContatoDocumento());
				stm.setString(7, cad.getContatoNome());
				stm.setString(8, cad.getContatoEmail());
				stm.setString(9, cad.getSenha());
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
				stm.setInt(1, cad.getDocumento());
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
			stm.setInt(1, cad.getDocumento());
			stm.setString(2, cad.getNome());
			stm.setString(3, cad.getEndereco());
			stm.setInt(4, cad.getTelefone());
			stm.setInt(5, cad.getContatoDocumento());
			stm.setString(6, cad.getContatoNome());
			stm.setString(7, cad.getContatoEmail());
			stm.setString(8, cad.getSenha());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   	

}
