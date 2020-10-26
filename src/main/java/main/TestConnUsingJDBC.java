package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestConnUsingJDBC {
	private static final Logger logger = LogManager
			.getLogger(TestConnUsingJDBC.class);

	public static void main(String[] args)  {

		String log4JFile = "conf/log4j.properties";

		System.out.println("* Iniciando o Log4J." + " log4JFile = '" + log4JFile + "'");

		if (log4JFile != null) { PropertyConfigurator.configureAndWatch(log4JFile); }

		logger.info("Log4J inicializado.");

		String driverName = System.getProperty("db.driver");
		String url = System.getProperty("db.url");
		String login = System.getProperty("db.user");
		String password = System.getProperty("db.pass");
		Connection conn = getConnection(driverName, url, login, password);
		logger.info("***** Conexão ao database está OK. *****\n*****");
	}

	private static Connection getConnection(String driverName, 
				String url, String login, String password) {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro ao tentar carregar a classe ''" + driverName + "'", e);
		}

		Connection con = null;
		try {
			con = DriverManager.getConnection(url, login, password);
		} catch (SQLException e) {
			throw new RuntimeException("Erro ao tentar conectar ao database '" + url + 
					"' usando o usuário '" + login + "'", e);
		}
		return con;
	}

}
