package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produto {

	private String nome;
	private List<Operacoes> operacoesList = new ArrayList<>();
	private double resultado = 0;

	public Produto(String nome) {
		this.nome = nome;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Produto)) return false;
		Produto produto = (Produto) o;
		return Objects.equals(nome, produto.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Operacoes> getOperacoesList() {
		return operacoesList;
	}

	public void setOperacoesList(List<Operacoes> operacoesList) {
		this.operacoesList = operacoesList;
	}

	public Double getResultado() {
		return resultado;
	}

	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}

	public void cadastroOperacoes(Operacoes operacoes){
		operacoesList.add(operacoes);
	}

	public void resultado(double quantidade, double preco){
		resultado += quantidade * preco;
	}
}
