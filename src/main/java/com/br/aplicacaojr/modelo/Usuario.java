package com.br.aplicacaojr.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private LocalDateTime data_nascimento;
	
	@ManyToOne
	private Empresa empresa;
	
	private boolean status;
	
	private String apelido;
	
	@ManyToMany
	private List<Projeto> projetos;
	
	

	public Usuario(){
	}

	public Usuario(String nome, String email, LocalDateTime data_nascimento, Empresa empresa, boolean status, String apelido, List<Projeto> projetos){
		this.nome = nome;
		this.email = email;
		this.data_nascimento = data_nascimento;
		this.empresa = empresa;
		this.status = status;
		this.apelido = apelido;
		this.projetos = projetos;
	}
	
	public Usuario(String nome, LocalDateTime data_nascimento, String apelido) {
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.apelido = apelido;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public LocalDateTime getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDateTime data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
}
