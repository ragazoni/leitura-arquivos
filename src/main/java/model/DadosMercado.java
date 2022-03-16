package model;

import java.util.Objects;

public class DadosMercado {

	private Long idPreco;
	private Long diasCorridos;
	private Double preco;

	public DadosMercado(Long idPreco, Long diasCorridos, Double preco) {
		this.idPreco = idPreco;
		this.diasCorridos = diasCorridos;
		this.preco = preco;
	}

	public Long getIdPreco() {
		return idPreco;
	}

	public void setIdPreco(Long idPreco) {
		this.idPreco = idPreco;
	}

	public Long getDiasCorridos() {
		return diasCorridos;
	}

	public void setDiasCorridos(Long diasCorridos) {
		this.diasCorridos = diasCorridos;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof DadosMercado)) return false;
		DadosMercado that = (DadosMercado) o;
		return Objects.equals(idPreco, that.idPreco);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPreco);
	}

	@Override
	public String toString() {
		return "DadosMercado{" +
				"idPreco=" + idPreco +
				", diasCorridos=" + diasCorridos +
				", preco=" + preco +
				'}';
	}
}
