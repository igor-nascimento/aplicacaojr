package com.br.aplicacaojr.controller.form;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.aplicacaojr.modelo.Empresa;
import com.br.aplicacaojr.modelo.Projeto;
import com.br.aplicacaojr.modelo.Usuario;
import com.br.aplicacaojr.repository.ProjetoRepository;
import com.br.aplicacaojr.repository.UsuarioRepository;


public class UsuarioForm {
	
	@NotEmpty(message ="{nome.not.empty}") @NotNull(message ="{nome.not.null}")
	private String nome;
	
	@NotEmpty(message ="{email.not.empty}") @NotNull(message ="{email.not.null}") @Email(message ="{email.not.valid}")
	private String email;
	
	@NotNull(message ="{data_nascimento.not.null}")
	private LocalDateTime data_nascimento;
	
	private Empresa empresa;
	private String apelido;
		
	
	public UsuarioForm() {
		this.empresa = new Empresa();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(LocalDateTime data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public Usuario converter(UsuarioRepository usuarioRepository, ProjetoRepository projetoRepository) {

		Optional<Usuario> p = usuarioRepository.findByEmailAndStatus(email, true);
		List<Projeto> projetos = projetoRepository.findByEmpresaIdAndStatus(empresa.getId(), true);		
		
		//System.out.println(p2);
		Usuario usuario = null;
		if (p.isPresent()) {
			//retornar que ja existe um usuario ativo para este email
			//return "ja existe um usuario ativo para este email";
		} else {
			usuario = new Usuario(nome, email, data_nascimento, empresa, true, apelido, projetos);
			
		}
		return usuario;	
	}
}
