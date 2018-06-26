package br.edu.ifg.projetoPOO.estoque.view;

import java.sql.Date;

import br.edu.ifg.projetoPOO.estoque.model.Produto;

public class ProdutoView {
	Produto produto = new Produto();
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void showCadastro(Integer ID,
			String Nome, Date dtFabricacao,
			Date dtVencimento,String categoria,
			Integer qdt) {
		this.produto.setProdutoID(ID);
		this.produto.setProdutoNome(Nome);
		this.produto.setProdutoDtFabricacao(dtFabricacao);
		this.produto.setProdutoDtVencimento(dtVencimento);
		this.produto.setProdutoCategoria(categoria);
		this.produto.setProdutoQTD(qdt);
		
		this.produto.cadastrar();
		
	}
}
