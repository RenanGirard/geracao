package br.com.ibfc.geracao.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="alunos")
public class Aluno extends Pessoa {
	
	private static final long serialVersionUID = 1L;
	@OneToOne
	private Turma turma;
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
