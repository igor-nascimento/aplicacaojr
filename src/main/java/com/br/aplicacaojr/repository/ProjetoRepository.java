package com.br.aplicacaojr.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.br.aplicacaojr.modelo.Projeto;


public interface ProjetoRepository extends JpaRepository<Projeto, Long>{

	List<Projeto> findByEmpresaNome(String nomeEmpresa);
	
	
	@Query(value = "SELECT DATEADD('DAY',1, max(data_desativacao))  FROM PROJETO WHERE nome = :nome and status = :status and data_desativacao is not null and empresa_id = :empresa", 
			  nativeQuery = true)
	LocalDateTime findByNomeAndStatusAndEmpresaId(@Param("nome") String nome, @Param("status") boolean status, @Param("empresa") Long empresa);



	Optional<Projeto> findByNomeAndEmpresaId(String nome, Long id);


	
	List<Projeto> findByEmpresaIdAndStatus(Long id, boolean b);

	
}
