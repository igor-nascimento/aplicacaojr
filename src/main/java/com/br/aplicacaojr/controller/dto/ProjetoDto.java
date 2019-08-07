package com.br.aplicacaojr.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.br.aplicacaojr.modelo.Empresa;
import com.br.aplicacaojr.modelo.Projeto;


public class ProjetoDto {
	
	private Long id;
	private String nome;
	private boolean status;
	private LocalDateTime data_ativacao;
	private LocalDateTime data_desativacao;
	private Empresa empresa;

	public ProjetoDto(Projeto projeto) {
		this.id = projeto.getId();
		this.nome = projeto.getNome();
		this.status = projeto.isStatus();
		this.data_ativacao = projeto.getData_ativacao();
		this.data_desativacao = projeto.getData_desativacao();
		this.empresa = projeto.getEmpresa();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}


	public boolean isStatus() {
		return status;
	}

	public LocalDateTime getData_ativacao() {
		return data_ativacao;
	}

	public LocalDateTime getData_desativacao() {
		return data_desativacao;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public static List<ProjetoDto> converter(List<Projeto> projetos) {
		return projetos.stream().map(ProjetoDto::new).collect(Collectors.toList());
	}

	
	
}
