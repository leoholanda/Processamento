package br.com.hemocentro.model;

public enum TipoSanguineo {
	
	A_POSITIVO("A+"),
	A_NEGATIVO("A-"),
	B_POSITIVO("B+"),
	B_NEGATIVO("B-"),
	AB_POSITIVO("AB+"),
	AB_NEGATIVO("AB-"),
	O_POSITIVO("O+"),
	O_NEGATIVO("O-");
	
	private String descricao;

	TipoSanguineo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
