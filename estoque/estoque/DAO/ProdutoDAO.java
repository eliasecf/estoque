package br.edu.ifg.projetoPOO.estoque.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.edu.ifg.projetoPOO.estoque.control.ConexaoJDBC;
import br.edu.ifg.projetoPOO.estoque.model.Produto;

public class ProdutoDAO {
	private ConexaoJDBC conexaoJDBC;

	public ProdutoDAO(ConexaoJDBC conexaoJDBC) {
		this.conexaoJDBC = conexaoJDBC;
	}

	public void inserir(Produto produto) {
		String sql = "insert into produto (pid, pnome, dtfabricacao, dtvencimento, pcategoria, pqtd) "
				+ "values(?,?,?,?,?,?);";

		try {
			PreparedStatement preparedStatement = conexaoJDBC.getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, produto.getProdutoID());
			preparedStatement.setString(2, produto.getProdutoNome());
			preparedStatement.setDate(3, new java.sql.Date(produto.getProdutoDtFabricacao().getTime()));
			preparedStatement.setDate(4, new java.sql.Date(produto.getProdutoDtVencimento().getTime()));
			preparedStatement.setString(5, produto.getProdutoCategoria());
			preparedStatement.setInt(6, produto.getProdutoQTD());
			preparedStatement.execute();
			preparedStatement.close();
			System.out.println("Sucesso ao inserir produto:" + produto.getProdutoNome());

		} catch (SQLException e) {
			System.out.println("Ocorreram erros ao inserir produto:" + e.getMessage());
		}
	}

	public List<Produto> getLista() {
		String sql = "update produto (pid, pnome, dtfabricacao, dtvencimento, pcategoria, pqtd) "
				+ "values(?,?,?,?,?,?);";

		try {
			List<Produto> listaProdutos = new ArrayList<Produto>();
			PreparedStatement preparedStatement = this.conexaoJDBC.getConnection().prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setProdutoID(rs.getInt("pid"));
				;
				produto.setProdutoNome(rs.getString("pnome"));
				;

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dtfabricacao"));
				produto.setProdutoDtFabricacao(data.getTime());
				data.setTime(rs.getDate("dtvencimento"));
				produto.setProdutoDtVencimento(data.getTime());

				produto.setProdutoCategoria(rs.getString("pcategoria"));
				;
				produto.setProdutoQTD(rs.getInt("pqtd"));
			}
			rs.close();
			preparedStatement.close();
			return listaProdutos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
