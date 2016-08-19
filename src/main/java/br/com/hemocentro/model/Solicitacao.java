package br.com.hemocentro.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Solicitacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int hemacias;

	private int plaquetas;

	private int sangue;

	private int plasma;

	private LocalDateTime data;

	public Solicitacao() {
		this.data = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHemacias() {
		return hemacias;
	}

	public void setHemacias(int hemacias) {
		this.hemacias = hemacias;
	}

	public int getPlaquetas() {
		return plaquetas;
	}

	public void setPlaquetas(int plaquetas) {
		this.plaquetas = plaquetas;
	}

	public int getSangue() {
		return sangue;
	}

	public void setSangue(int sangue) {
		this.sangue = sangue;
	}

	public int getPlasma() {
		return plasma;
	}

	public void setPlasma(int plasma) {
		this.plasma = plasma;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}
