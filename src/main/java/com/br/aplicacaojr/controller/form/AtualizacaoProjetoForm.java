package com.br.aplicacaojr.controller.form;

import java.time.LocalDateTime;

import com.br.aplicacaojr.modelo.Projeto;
import com.br.aplicacaojr.repository.ProjetoRepository;

public class AtualizacaoProjetoForm {
	
	
	private String nome;

	public Projeto atualizar(Long id, ProjetoRepository projetoRepository) {
		Projeto projeto = projetoRepository.getOne(id);
		
		if (projeto.isStatus() == true) {
			projeto.setStatus(false);
			projeto.setData_desativacao(LocalDateTime.now());
		}
		
		
		return projeto;
	}

	public String getNome() {
		return nome;
	}
}
