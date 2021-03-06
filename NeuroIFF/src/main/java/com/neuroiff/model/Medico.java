package com.neuroiff.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "medico")
public class Medico implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long crm;
	private String nome;
	private String especialidade;
		
	public Medico() {
		
	}
	public Medico(Long crm, String nome, String especialidade) {
		super();
		this.crm = crm;
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	
	
	
	
	@Id 
	@GeneratedValue 
	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}





	@Column(name = "crm_med",nullable = false) 
	public Long getCrm() {
		return crm;
	}






	public void setCrm(Long crm) {
		this.crm = crm;
	}





	@Column(name = "nome_med", nullable = false) 
	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}





	@Column(length = 100, nullable = false) 
	public String getEspecialidade() {
		return especialidade;
	}






	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
