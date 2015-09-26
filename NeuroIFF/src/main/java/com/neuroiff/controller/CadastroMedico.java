package com.neuroiff.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import com.neuroiff.model.Medico;
import com.neuroiff.repository.MedicoRepository;
import com.neuroiff.service.NegocioException;
import com.neuroiff.util.jpa.JpaUtil;

@ManagedBean
@ViewScoped
public class CadastroMedico implements Serializable {

	private static final long serialVersionUID = 1L;

	private Medico medico = new Medico();
	private List<Medico> todasMedicos;

	public void prepararCadastro() {
		EntityManager manager = JpaUtil.getEntityManager();
		try {
			MedicoRepository medicos = new MedicoRepository(manager);
			this.todasMedicos = medicos.todos();
		} finally {
			manager.close();
		}
	}

	public void salvar() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			trx.begin();
			MedicoRepository repository = new MedicoRepository(manager);
			repository.adicionar(this.medico);
			this.medico = new Medico();
			context.addMessage(null, new FacesMessage("Dados do Médico salvo com sucesso!"));
			trx.commit();
		} catch (NegocioException e) {
			trx.rollback();
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, mensagem);
		} finally {
			manager.close();
		}
	}
	
	public void remover(){
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction trx = manager.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try{
			MedicoRepository repository = new MedicoRepository(manager);
			repository.porId(this.medico.getId()); //= porId(medico.getId());
			manager.remove(this.medico);
			context.addMessage(null, new FacesMessage("Dados do Médico removido com sucesso!"));
			manager.flush();
			}catch(NegocioException e){
				trx.rollback();
				FacesMessage mensagem = new FacesMessage(e.getMessage());
				mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
				context.addMessage(null, mensagem);
			}
		}

	public boolean isEditando(){
		return this.medico.getId() != null;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getTodasMedicos() {
		return todasMedicos;
	}

	public void setTodasMedicos(List<Medico> todasMedicos) {
		this.todasMedicos = todasMedicos;
	}
	
	

}
