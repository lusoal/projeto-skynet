package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionFactory {
	final static Logger logger = Logger.getLogger(ConnectionFactory.class);
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	//Verificar se dessa forma funciona se nao adicionar o Trows
	public static Connection realizarConexao(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/skynet?user=root&password=123456");
		}catch(SQLException e) {
				logger.error("Error on connection to DB "+e);
				}
		return null;
			}
}
