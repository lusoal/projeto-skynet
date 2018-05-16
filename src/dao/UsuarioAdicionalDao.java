package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionFactory;
import model.UsuarioAdicional;

public class UsuarioAdicionalDao {

	public void incluirAdicional(UsuarioAdicional adicional){
		String sqlInsert = "INSERT INTO usuarioAdicional (documento, documentoPrincipal, nome, email, perfil, senha, status) VALUES(?, ?, ?, ?, ?, ?, ?)";
		//Iniciar Conexao com o banco
		//Try para verificar se nao ocorre exeptions
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			stm.setLong(1,adicional.getDocumento());
			stm.setLong(2, adicional.getDocumentoPrinc());
			stm.setString(3, adicional.getNome());
			stm.setString(4, adicional.getEmail());
			stm.setString(5, adicional.getPerfil());
			stm.setString(6, adicional.getSenha());
			stm.setBoolean(7, adicional.getStatus());
			stm.execute();
			//Essa parte e necessaria para poder inserir um valor no ID para mostrar no HTML gerado pelo Controller
		}catch(SQLException e) {
			
			System.out.println(e);
		}
	}
	//realizar validacao se usuario ja existe na base de dados
	
	//passar documento principal vinculado ao usuario Adicional
	public ArrayList<UsuarioAdicional> listarAdicional(UsuarioAdicional adicional, String sqlSelect){
	
	// O select do SQL retorna do service
	ArrayList<UsuarioAdicional> add = new ArrayList<UsuarioAdicional>();
	
	try {
		Connection conn = ConnectionFactory.realizarConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		stm.setLong(1, adicional.getDocumentoPrinc());
		
		ResultSet rs = stm.executeQuery();	
		
		while(rs.next()) {
			UsuarioAdicional ua = new UsuarioAdicional();
			ua.setDocumento(rs.getLong("documento"));
			ua.setNome(rs.getString("nome"));
			ua.setPerfil(rs.getString("perfil"));
			ua.setEmail(rs.getString("email"));
			add.add(ua);
		}
	} catch (SQLException e) {
		System.out.println(e);
	}

	return add;

	}
	
	public void listarMeuCadastro(UsuarioAdicional adicional){
		try {
		String sqlSelect = "SELECT * FROM usuarioAdicional WHERE documento = ?";
		
		Connection conn = ConnectionFactory.realizarConexao();
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		stm.setLong(1, adicional.getDocumento());
		ResultSet rs = stm.executeQuery();
		
		if(rs.next()) {
			adicional.setDocumentoPrinc(rs.getLong("documentoPrincipal"));
			adicional.setNome(rs.getString("nome"));
			adicional.setPerfil(rs.getString("perfil"));
			adicional.setEmail(rs.getString("email"));
		}
		}catch(SQLException e) {
			System.out.println(e);
		}
		}
	
		public void alterarCadastroAdicional(UsuarioAdicional adicional) {
			try {
				
				String sqlSelect = "UPDATE usuarioAdicional SET nome = ?, email = ? WHERE documento = ?";
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				stm.setString(1, adicional.getNome());
				stm.setString(2, adicional.getEmail());
				stm.setLong(3, adicional.getDocumento());
				stm.execute();
				
			}catch(Exception e) {
				System.out.println(e);
				}
			}
	
	}

