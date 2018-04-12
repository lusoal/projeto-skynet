package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import connection.ConnectionFactory;
import jdk.nashorn.internal.runtime.events.RuntimeEvent;
import model.Cadastros;
import model.Publico;

public class PublicoDao {
	
	public void IncluirPublico(Publico publico){
		String sqlInsert = "INSERT INTO precadastro (documento, tipo, status, nome) VALUES(?, ?, ?, ?)";
		//Iniciar Conexao com o banco
		//Try para verificar se nao ocorre exeptions
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			stm.setLong(1,publico.getDocumento());
			stm.setString(2, publico.getTipo());
			stm.setBoolean(3, publico.getStatus());
			stm.setString(4, publico.getNome());
			stm.execute();
			//Essa parte e necessaria para poder inserir um valor no ID para mostrar no HTML gerado pelo Controller
		}catch(SQLException e) {
			
			System.out.println(e);
		}
	}
	
	public void RemoverPublico(Publico publico){
		String sqlDelete = "DELETE FROM precadastro WHERE documento = ?";
		
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);
			stm.setLong(1,publico.getDocumento());
			stm.execute();
			//Essa parte e necessaria para poder inserir um valor no ID para mostrar no HTML gerado pelo Controller
		}catch(SQLException e) {
			System.out.println(e);
		}
	}


	public long VerificarCadastro(Publico publico){
		
		String sqlSelect = "SELECT documento FROM precadastro  WHERE documento = ?";
		
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			long documento = publico.getDocumento();
			stm.setLong(1, documento);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()) {
				publico.setDocumento(-1);
			}else {
				publico.setDocumento(documento);
			}
			
		}catch(SQLException e ) {
			System.out.println(e);
		}
		
		return publico.getDocumento() ;
		
	}
	
	
	//Verificar opcao de enviar objeto publico ao inves de um array
	public void verificarPublico(Publico pub) {
		String sqlDelete = "SELECT status, nome, tipo FROM precadastro WHERE documento = ?";
		pub.setStatus(false);
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);
			stm.setLong(1, pub.getDocumento());
			ResultSet rs = stm.executeQuery();	
			if(rs.next()) {
				int status = rs.getInt("status");
				pub.setNome(rs.getString("nome"));
				pub.setTipo(rs.getString("tipo"));
				
				if(status == 1) {
					System.out.println("status do banco 1");
					pub.setStatus(true);
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}