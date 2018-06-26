package br.edu.ifg.projetoPOO.estoque.model;

import java.sql.Date;

import br.edu.ifg.projetoPOO.estoque.control.controle;


public class Produto {
	private Integer produtoID;
	private String produtoNome;
	private java.util.Date produtoDtFabricacao;
	private java.util.Date produtoDtVencimento;
	private String produtoCategoria;
	private Integer produtoQTD;
	
	public void cadastrar(){
		
		controle.cadastrar(this);
		
	}
	
	public Integer getProdutoID() {
		return produtoID;
	}
	public void setProdutoID(Integer produtoID) {
		this.produtoID = produtoID;
	}
	public String getProdutoNome() {
		return produtoNome;
	}
	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}
	public java.util.Date getProdutoDtFabricacao() {
		return produtoDtFabricacao;
	}
	public void setProdutoDtFabricacao(java.util.Date produtoDtFabricacao) {
		this.produtoDtFabricacao = produtoDtFabricacao;
	}
	public java.util.Date getProdutoDtVencimento() {
		return produtoDtVencimento;
	}
	public void setProdutoDtVencimento(java.util.Date date) {
		this.produtoDtVencimento = date;
	}
	public String getProdutoCategoria() {
		return produtoCategoria;
	}
	public void setProdutoCategoria(String produtoCategoria) {
		this.produtoCategoria = produtoCategoria;
	}
	public Integer getProdutoQTD() {
		return produtoQTD;
	}
	public void setProdutoQTD(Integer produtoQTD) {
		this.produtoQTD = produtoQTD;
	}
	
	public Produto() {}
	
	public Produto(Integer produtoID, String produtoNome, java.util.Date dataFabricacao, java.util.Date dataVencimento,
			String produtoCategoria, Integer produtoQTD) {
		super();
		this.produtoID = produtoID;
		this.produtoNome = produtoNome;
		this.produtoDtFabricacao = dataFabricacao;
		this.produtoDtVencimento = dataVencimento;
		this.produtoCategoria = produtoCategoria;
		this.produtoQTD = produtoQTD;
	}
	@Override
	public String toString() {
		return "produto [produtoID=" + produtoID + ", produtoNome=" + produtoNome + ", produtoDtFabricacao="
				+ produtoDtFabricacao + ", produtoDtVencimento=" + produtoDtVencimento + ", produtoCategoria="
				+ produtoCategoria + ", produtoQTD=" + produtoQTD + "]";
	}
	
	
	
	
}
