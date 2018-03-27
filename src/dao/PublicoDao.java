package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import connection.ConnectionFactory;
import jdk.nashorn.internal.runtime.events.RuntimeEvent;
import model.Publico;

public class PublicoDao {
	
	public void IncluirPublico(Publico publico){
		String sqlInsert = "INSERT INTO cadPublico (documento, tipo, status) VALUES(?, ?, ?)";
		//Iniciar Conexao com o banco
		//Try para verificar se nao ocorre exeptions
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1,publico.getDocumento());
			stm.setString(2, publico.getTipo());
			stm.setBoolean(3, publico.getStatus());
			stm.execute();
			//Essa parte e necessaria para poder inserir um valor no ID para mostrar no HTML gerado pelo Controller
		}catch(SQLException e) {
			
			System.out.println(e);
		}
	}
	
	public void RemoverPublico(Publico publico){
		String sqlDelete = "DELETE FROM cadPublico WHERE documento = ?";
		
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);
			stm.setInt(1,publico.getDocumento());
			stm.execute();
			//Essa parte e necessaria para poder inserir um valor no ID para mostrar no HTML gerado pelo Controller
		}catch(SQLException e) {
			System.out.println(e);
		}
	}


	public long VerificarCadastro(Publico publico){
		
		String sqlSelect = "SELECT documento FROM cadPublico  WHERE documento = ?";
		
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			int documento = publico.getDocumento();
			stm.setInt(1, documento);
			
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

}