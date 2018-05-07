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
}
