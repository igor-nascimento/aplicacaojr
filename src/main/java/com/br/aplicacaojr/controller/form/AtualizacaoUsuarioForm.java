package com.br.aplicacaojr.controller.form;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.br.aplicacaojr.modelo.Projeto;
import com.br.aplicacaojr.modelo.Usuario;
import com.br.aplicacaojr.repository.ProjetoRepository;
import com.br.aplicacaojr.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	//dado um e-mail, atualizar os projetos deste usuario.
	
	@NotEmpty @NotNull @Email
	private String email;


	public String getEmail() {
		return email;
	}


	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository, ProjetoRepository projetoRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		List<Projeto> projetos = projetoRepository.findByEmpresaIdAndStatus(usuario.getEmpresa().getId(), true);
		usuario.setProjetos(projetos);
		return usuario;
	}

}
