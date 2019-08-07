package com.br.aplicacaojr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.aplicacaojr.modelo.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	Empresa findByNome(String nome);
}
