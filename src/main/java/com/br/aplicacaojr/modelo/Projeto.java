package com.br.aplicacaojr.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Projeto {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@ManyToOne
	private Empresa empresa;
	
	private boolean status;
	
	private LocalDateTime data_ativacao;
	
	private LocalDateTime data_desativacao;
	
	public Projeto() {
	}
	
	public Projeto(String nome, Empresa empresa, boolean status, LocalDateTime data_ativacao) {
		this.nome = nome;
		this.empresa = empresa;
		this.status = status;
		this.data_ativacao = data_ativacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDateTime getData_ativacao() {
		return data_ativacao;
	}

	public void setData_ativacao(LocalDateTime data_ativacao) {
		this.data_ativacao = data_ativacao;
	}

	public LocalDateTime getData_desativacao() {
		return data_desativacao;
	}

	public void setData_desativacao(LocalDateTime data_desativacao) {
		this.data_desativacao = data_desativacao;
	}

	
	
	
}
