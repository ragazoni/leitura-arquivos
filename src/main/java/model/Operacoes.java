package model;

import java.util.Comparator;
import java.util.Objects;

public class Operacoes implements Comparator<Operacoes> {

	private int idPreco;
	private Long diasCorridos;
	private Double quantidade;

	public Operacoes(int idPreco, Long diasCorridos, Double quantidade) {
		this.idPreco = idPreco;
		this.diasCorridos = diasCorridos;
		this.quantidade = quantidade;
	}

	public int getIdPreco() {
		return idPreco;
	}

	public void setIdPreco(int idPreco) {
		this.idPreco = idPreco;
	}

	public Long getDiasCorridos() {
		return diasCorridos;
	}

	public void setDiasCorridos(Long diasCorridos) {
		this.diasCorridos = diasCorridos;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int compare(Operacoes o1, Operacoes o2) {
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Operacoes)) return false;
		Operacoes operacoes = (Operacoes) o;
		return idPreco == operacoes.idPreco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPreco);
	}

	@Override
	public String toString() {
		return "Operacoes{" +
				"idPreco=" + idPreco +
				", diasCorridos=" + diasCorridos +
				", quantidade=" + quantidade +
				'}';
	}
}
