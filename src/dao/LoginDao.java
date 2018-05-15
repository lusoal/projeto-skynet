package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Login;
import model.Cadastros;


public class LoginDao {
	//Implementado o tipo para validar as outras tabelas
	
	public boolean LoginAdicional(Login login) {
		try {
		String sqlSelect = "SELECT documento, senha FROM usuarioAdicional WHERE documento=? AND senha=?";
		Connection conn = ConnectionFactory.realizarConexao();
		
		PreparedStatement stm = conn.prepareStatement(sqlSelect);
		
		
		stm.setLong(1, login.getDocumento());
		stm.setString(2, login.getSenha());
		
		ResultSet rs = stm.executeQuery();
		
		try {
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	
	public boolean SelectLogin(Login login){
		String sqlSelect = "SELECT documento FROM cadastro where documento= ?";
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			stm.setLong(1,login.getDocumento());
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			
			System.out.println(e);
		}
		return false;
	}
	
	public boolean ValidarSenha(Login login) {
			String sqlSelect = "SELECT senha FROM cadastro where documento= ?";
		
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				
				stm.setLong(1,login.getDocumento());
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					String pass = rs.getString("senha");
					
					//validando a senha que veio do objeto e a senha que esta no banco
					if (pass.equals(login.getSenha())) {
						return true;
					}
				}else {
					return false;
				}
			}catch(SQLException e) {
				
				System.out.println(e);
			}
			return false;
		}
//carrega o tipo que o usuario esta cadastrado
	public String carregarTipo(Login login) {
		String sqlSelect = "SELECT tipo FROM cadastro where documento= ?";
		String tipo = "";
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			stm.setLong(1,login.getDocumento());
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				tipo = rs.getString("tipo");
				System.out.println(tipo);
			}
		}catch(SQLException e) {
			
			System.out.println(e);
		}
		return tipo;
	}
	
	public void carregarAssociado(Login login, Cadastros cadastro) {
		String sqlSelect = "SELECT documentoPrincipal from usuarioAdicional where documento = ?";
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			stm.setLong(1, login.getDocumento());
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				System.out.println("Entrei no select do documento princpal");
				long docPrinc = rs.getLong("documentoPrincipal");
				sqlSelect = "SELECT * FROM cadastro where documento = ?";
				stm = conn.prepareStatement(sqlSelect);
				stm.setLong(1, docPrinc);
				rs = stm.executeQuery();
				if(rs.next()) {
					System.out.println("Selecionei a empresa que estou associado");
					cadastro.setDocumento(rs.getLong("documento"));
					cadastro.setNome(rs.getString("nome"));
					cadastro.setTipo(rs.getString("tipo"));
				}
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
	}
	
	public boolean verificarSenhaAssociado(Login login) {
		String sqlSelect = "SELECT nome from usuarioAdicional WHERE documento=? and status=false";
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			stm.setLong(1, login.getDocumento());
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
			
	}
	
	public void alterarSenhaAssociado(Login login, String senha) {
		String sqlInsert = "UPDATE usuarioAdicional set senha = ?, status = ? WHERE documento=?";
		
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			
			stm.setString(1,senha);
			stm.setBoolean(2, true);
			stm.setLong(3, login.getDocumento());
			stm.execute();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	

}
