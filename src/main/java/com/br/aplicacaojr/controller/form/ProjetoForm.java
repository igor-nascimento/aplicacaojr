package com.br.aplicacaojr.controller.form;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.aplicacaojr.modelo.Empresa;
import com.br.aplicacaojr.modelo.Projeto;
import com.br.aplicacaojr.repository.ProjetoRepository;


public class ProjetoForm {
	
	@NotEmpty @NotNull
	private String nome;
	
	@NotNull
	private Empresa empresa;
	
	@NotNull
	private LocalDateTime data_ativacao; 

	
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public LocalDateTime getData_ativacao() {
		return data_ativacao;
	}


	public void setData_ativacao(LocalDateTime data_ativacao) {
		this.data_ativacao = data_ativacao;
	}


	public ProjetoForm() {
		this.empresa = new Empresa();
	}
	
	
	public Projeto converter(ProjetoRepository projetoRepository) {
		
		
		Optional<Projeto> teste1 = projetoRepository.findByNomeAndEmpresaId(nome, empresa.getId());
		
		//verifica se o projeto existe para esta empresa
		if(teste1.isPresent()) {

			LocalDateTime teste2 = projetoRepository.findByNomeAndStatusAndEmpresaId(nome, false, empresa.getId());
			
			//se retornar a ultima data de desativacao, retorna a data no objeto, somando 1 dia
			if(teste2 !=null) {
						
				return new Projeto(nome, empresa, true, teste2);
				
			} else {
				//nao posso criar porque ja existe um projeto ativo para esta empresa com este nome
				System.out.println("Ja existe um projeto ativo para esta empresa com este nome");
			}
		} 
		//cadastrar sem modificar a data de ativacao
		return new Projeto(nome, empresa, true, data_ativacao);
	}
}
