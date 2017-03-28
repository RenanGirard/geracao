package br.com.ibfc.geracao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "turmas")
public class Turma {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeDaTurma;
	private Float idadeDe;
	private Float idadeAte;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeDaTurma() {
		return nomeDaTurma;
	}
	public void setNomeDaTurma(String nomeDaTurma) {
		this.nomeDaTurma = nomeDaTurma;
	}
	public Float getIdadeDe() {
		return idadeDe;
	}
	public void setIdadeDe(Float idadeDe) {
		this.idadeDe = idadeDe;
	}
	public Float getIdadeAte() {
		return idadeAte;
	}
	public void setIdadeAte(Float idadeAte) {
		this.idadeAte = idadeAte;
	}
	
}
