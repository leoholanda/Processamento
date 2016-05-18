package br.com.hemocentro.model;

public enum StatusUsuario {
	
	SOLICITADO("Solicitado"),
	ATIVO("Ativo"),
	DESATIVADO("Desativado");
	
	private String descricao;

	StatusUsuario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
