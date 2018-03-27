package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionFactory;
import model.Administrador;
import model.Publico;

public class ManterAdministradorDao {
	
		public void IncluirAdm(Administrador adm) {
			String sqlInsert = "INSERT INTO cadAdm (documento, nome, endereco, telefone, contatoDocumento, contatoNome, contatoEmail, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			// Iniciar Conexao com o banco
			// Try para verificar se nao ocorre exeptions
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);
				stm.setInt(1, adm.getDocumento());
				stm.setString(2, adm.getNome());
				stm.setString(3, adm.getEndereco());
				stm.setInt(4, adm.getTelefone());
				stm.setInt(5, adm.getContatoDocumento());
				stm.setString(6, adm.getContatoNome());
				stm.setString(7, adm.getContatoEmail());
				stm.setString(8, adm.getSenha());
				stm.execute();
				// Essa parte e necessaria para poder inserir um valor no ID para mostrar no
				// HTML gerado pelo Controller
			} catch (SQLException e) {

				System.out.println(e);
			}
		}

		public void RemoverAdm(Administrador adm) {
			String sqlDelete = "DELETE FROM cadAdm WHERE documento = ?";

			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);
				stm.setInt(1, adm.getDocumento());
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

		public void atualizarAdm(Administrador adm) {
		String sqlUpdate = "UPDATE adm SET nome=?, endereco=?, telefone=?, contatoDocumento=?, contatoNome=?, contatoEmail=? WHERE documento=?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, adm.getDocumento());
			stm.setString(2, adm.getNome());
			stm.setString(3, adm.getEndereco());
			stm.setInt(4, adm.getTelefone());
			stm.setInt(5, adm.getContatoDocumento());
			stm.setString(6, adm.getContatoNome());
			stm.setString(7, adm.getContatoEmail());
			stm.setString(8, adm.getSenha());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
   	

}
