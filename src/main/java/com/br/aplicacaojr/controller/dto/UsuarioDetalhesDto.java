package com.br.aplicacaojr.controller.dto;

import java.time.LocalDateTime;

import com.br.aplicacaojr.modelo.Empresa;
import com.br.aplicacaojr.modelo.Usuario;



public class UsuarioDetalhesDto {
	private Long id;
	
	private String nome;
	
	private String email;
	
	private LocalDateTime data_nascimento;
	
	private Empresa empresa;
	
	private boolean status;
	
	private String apelido;
	
	
	public UsuarioDetalhesDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.data_nascimento = usuario.getData_nascimento();
		this.empresa = usuario.getEmpresa();
		this.status = usuario.isStatus();
		this.apelido = usuario.getApelido();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public LocalDateTime getData_nascimento() {
		return data_nascimento;
	}


	public Empresa getEmpresa() {
		return empresa;
	}


	public boolean isStatus() {
		return status;
	}


	public String getApelido() {
		return apelido;
	}
}
