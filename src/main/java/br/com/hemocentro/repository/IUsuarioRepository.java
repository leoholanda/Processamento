package br.com.hemocentro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hemocentro.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

}
