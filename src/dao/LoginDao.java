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
		String sqlSelect = "";
		if(login.getTipo().equals("Administrador")) {
			sqlSelect = "SELECT documento FROM cadAdm where documento= ?";
		
		}else if(login.getTipo().equals("Cartorio")) {
			sqlSelect = "SELECT documento FROM cadCart where documento= ?";
			
		}else if(login.getTipo().equals("Empresa")) {
			sqlSelect = "SELECT documento FROM cadEmp where documento= ?";
		}

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
			String sqlSelect = "";
			if(login.getTipo().equals("Administrador")) {
				sqlSelect = "SELECT senha FROM cadAdm where documento= ?";
			}else if(login.getTipo().equals("Cartorio")) {
				sqlSelect = "SELECT senha FROM cadCart where documento= ?";
			}else if(login.getTipo().equals("Empresa")) {
				sqlSelect = "SELECT senha FROM cadEmp where documento= ?";
			}
			
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
	}

