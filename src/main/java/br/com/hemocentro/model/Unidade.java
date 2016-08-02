package br.com.hemocentro.model;

public enum Unidade {
	
	PROCESSAMENTO("Processamento"),
	HGR("HGR"),
	HCSA("HCSA"),
	MATERNIDADE("Maternidade"),
	RORAINOPOLIS("Rorainopolis");
	
	private String descricao;

	Unidade(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
