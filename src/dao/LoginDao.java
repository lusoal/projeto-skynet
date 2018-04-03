package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Login;


public class LoginDao {
	//Implementado o tipo para validar as outras tabelas
	public boolean SelectLogin(Login login){
		String sqlSelect = "SELECT documento FROM cadastros where documento= ?";
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			stm.setInt(1,login.getDocumento());
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
			String sqlSelect = "SELECT senha FROM cadastros where documento= ?";
		
			try {
				Connection conn = ConnectionFactory.realizarConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				
				stm.setInt(1,login.getDocumento());
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
		String sqlSelect = "SELECT tipo FROM cadastros where documento= ?";
		String tipo = "";
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			stm.setInt(1,login.getDocumento());
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
