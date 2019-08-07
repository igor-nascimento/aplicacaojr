package com.br.aplicacaojr.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.aplicacaojr.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findByEmpresaNome(String nomeEmpresa);

	Optional<Usuario> findByEmailAndStatus(@NotEmpty @NotNull String email, @NotNull boolean status);

	Usuario findByIdAndEmail(Long id, @NotEmpty @NotNull @Email String email);

}
