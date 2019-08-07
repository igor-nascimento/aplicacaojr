package com.br.aplicacaojr.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.aplicacaojr.controller.dto.UsuarioDetalhesDto;
import com.br.aplicacaojr.controller.dto.UsuarioDto;
import com.br.aplicacaojr.controller.form.AtualizacaoUsuarioForm;
import com.br.aplicacaojr.controller.form.UsuarioForm;
import com.br.aplicacaojr.modelo.Usuario;
import com.br.aplicacaojr.repository.ProjetoRepository;
import com.br.aplicacaojr.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	@GetMapping
	public List<UsuarioDto> lista(String nomeEmpresa) {
		if (nomeEmpresa == null) {
			List<Usuario> usuarios = usuarioRepository.findAll();
			return UsuarioDto.converter(usuarios);
		} else {
			List<Usuario> usuarios = usuarioRepository.findByEmpresaNome(nomeEmpresa);
			return UsuarioDto.converter(usuarios);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDetalhesDto> detalhar(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return ResponseEntity.ok(new UsuarioDetalhesDto(usuario.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter(usuarioRepository, projetoRepository);
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizacaoUsuarioForm form) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository, projetoRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Deletar o usuario
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
