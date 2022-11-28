package br.com.magnasistemas.api.vo;

import jakarta.validation.constraints.NotNull;

public class ApiVO {

	@NotNull
	private Double numero1;
	@NotNull
	private Double numero2;

	public Double getNumero1() {
		return numero1;
	}

	public void setNumero1(Double numero1) {
		this.numero1 = numero1;
	}

	public Double getNumero2() {
		return numero2;
	}

	public void setNumero2(Double numero2) {
		this.numero2 = numero2;
	}

}
