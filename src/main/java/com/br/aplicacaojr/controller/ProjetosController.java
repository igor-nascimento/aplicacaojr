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

import com.br.aplicacaojr.controller.dto.ProjetoDto;
import com.br.aplicacaojr.controller.form.AtualizacaoProjetoForm;
import com.br.aplicacaojr.controller.form.ProjetoForm;
import com.br.aplicacaojr.modelo.Projeto;
import com.br.aplicacaojr.repository.ProjetoRepository;



@RestController
@RequestMapping("/projetos")
public class ProjetosController {

	@Autowired
	private ProjetoRepository projetoRepository;

	
	@GetMapping
	public List<ProjetoDto> lista(String nomeEmpresa) {
		if (nomeEmpresa == null) {
			List<Projeto> projetos = projetoRepository.findAll();
			return ProjetoDto.converter(projetos);
		} else {
			List<Projeto> projetos = projetoRepository.findByEmpresaNome(nomeEmpresa);
			return ProjetoDto.converter(projetos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjetoDto> detalhar(@PathVariable Long id) {
		Optional<Projeto> projeto = projetoRepository.findById(id);
		if (projeto.isPresent()) {
			return ResponseEntity.ok(new ProjetoDto(projeto.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProjetoDto> cadastrar(@RequestBody @Valid ProjetoForm form, UriComponentsBuilder uriBuilder) {
		Projeto projeto = form.converter(projetoRepository);
		projetoRepository.save(projeto);
		
		URI uri = uriBuilder.path("/projetos/{id}").buildAndExpand(projeto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProjetoDto(projeto));
	}
	
	
	//Desativar o projeto, setando o status para false e a data de desativacao para a hora atual
	//Na url vem o id e no corpo vem o nome do projeto
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProjetoDto> atualizar(@PathVariable Long id, @Valid @RequestBody AtualizacaoProjetoForm form) {
		Optional<Projeto> optional = projetoRepository.findById(id);
		if (optional.isPresent()) {
			Projeto projeto = form.atualizar(id, projetoRepository);
			return ResponseEntity.ok(new ProjetoDto(projeto));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	//Deletar o projeto
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Projeto> optional = projetoRepository.findById(id);
		if (optional.isPresent()) {
			projetoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
		
}
