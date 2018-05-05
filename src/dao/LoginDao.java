package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Login;


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

}
