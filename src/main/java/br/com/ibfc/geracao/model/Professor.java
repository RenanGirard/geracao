package br.com.ibfc.geracao.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="professores")
public class Professor extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String telefone;
	private String email;
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
