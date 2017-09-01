package br.com.ibfc.geracao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="aluno_responsavel")
public class AlunoResponsavel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipoDeResponsabilidade;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="aluno_id")
    private Aluno aluno;
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="responsavel_id")
    private Responsavel responsavel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoDeResponsabilidade() {
		return tipoDeResponsabilidade;
	}

	public void setTipoDeResponsabilidade(String tipoDeResponsabilidade) {
		this.tipoDeResponsabilidade = tipoDeResponsabilidade;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
}
