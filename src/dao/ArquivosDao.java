package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.ConnectionFactory;
import model.Arquivos;
import model.Publico;
import java.io.File;

public class ArquivosDao {
	
	public boolean inserirArquivoDownload(Arquivos arquivo, byte[] file) {
		
		String sqlInsert = "INSERT INTO downloadArquivos (documentoAdm, nome, conteudo) VALUES(?, ?, ?)";
		//Iniciar Conexao com o banco
		//Try para verificar se nao ocorre exeptions
		try {
			Connection conn = ConnectionFactory.realizarConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			stm.setLong(1,arquivo.getDocumento());
			stm.setString(2, arquivo.getNome());
			stm.setBytes(3, file);
			//Alterar para bytes
			stm.execute();
			return true;
			//Essa parte e necessaria para poder inserir um valor no ID para mostrar no HTML gerado pelo Controller
		}catch(SQLException e) {
			
			System.out.println(e);
		}
		return false;
	}
}
