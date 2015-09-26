package com.neuroiff.service;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.neuroiff.model.Medico;
import com.neuroiff.repository.Medicos;
import com.neuroiff.util.jsf.FacesUtil;

@Named
@ViewScoped
public class CadastroMedicoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Medicos medicos;
	
	@Inject
	private Medico medico;
	
	
	public CadastroMedicoBean() {
		limpar();
	}
	
	
	public void inicializar() {
		
		if (FacesUtil.isNotPostback()) {
			
		}
		
	}
	
	private void limpar() {
		medico = new Medico();		
	}
	
	public void salvar() {
		medicos.guardar(medico);		
		FacesUtil.addInfoMessage("Medico salvo com sucesso!");
		limpar();
	}
	
	
	public List<Medico> completarCliente(String nome) {
		return this.medicos.porNome(nome);
	}

	
	

	

	

}
