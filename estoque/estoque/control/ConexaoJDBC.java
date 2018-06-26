package br.edu.ifg.projetoPOO.estoque.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoJDBC {
	private String usuario;
	private String senha;
	private String urlBanco;
	private Connection connection;

	public ConexaoJDBC(String usuario, String senha, String urlBanco) {
		this.usuario = usuario;
		this.senha = senha;
		this.urlBanco = urlBanco;

		conectar();
	}

	public void conectar() {
		try {
			connection = DriverManager.getConnection(urlBanco, usuario, senha);
			System.out.println("Conectado ao banco de dados.");
		} catch (SQLException e) {
			System.out.println("Não foi possível conctar ao banco de dados.");
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public boolean executarSql(String sql) {
		try {
			Statement statement = connection.createStatement();
			statement.execute(sql);
			System.out.println("SQL executado com sucesso.");
			return true;
		} catch (SQLException e) {
			System.out.println("Não foi possivel executar a SQL" + e.getMessage());
			return false;
		}
	}

}
