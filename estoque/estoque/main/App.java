package br.edu.ifg.projetoPOO.estoque.main;

import java.util.Date;
import java.util.List;

import br.edu.ifg.projetoPOO.estoque.DAO.ProdutoDAO;
import br.edu.ifg.projetoPOO.estoque.control.ConexaoJDBC;
import br.edu.ifg.projetoPOO.estoque.model.Produto;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {
	public static void main(String[] args) {
		ConexaoJDBC conexaoJDBC = new ConexaoJDBC("postgres", "010203", "jdbc:postgresql://localhost:5432/estoque");
		ProdutoDAO produtoDAO = new ProdutoDAO(conexaoJDBC);

		try {
			Date dataFabricacao = new SimpleDateFormat("dd-MM-yyyy").parse("10-05-2017");
			Date dataVencimento = new SimpleDateFormat("dd-MM-yyyy").parse("10-12-2018");
			Produto produto = new Produto(2, "macarrao", dataFabricacao, dataVencimento, "alimento seco", 1);
			produtoDAO.inserir(produto);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	/*
	 * List<Produto> produtos = produtoDAO.getLista(); for (Produto produto :
	 * produtos) { System.out.println("ID: " + produto.getProdutoID());
	 * System.out.println("Nome: " + produto.getProdutoNome());
	 * System.out.println("Data Fabricação: " +
	 * produto.getProdutoDtFabricacao().getTime() + "\n");
	 * System.out.println("Data Vencimento: " +
	 * produto.getProdutoDtVencimento().getTime() + "\n");
	 * System.out.println("Categoria: " + produto.getProdutoCategoria());
	 * System.out.println("Qtd.: " + produto.getProdutoQTD());
	 * 
	 * } }
	 */
}
