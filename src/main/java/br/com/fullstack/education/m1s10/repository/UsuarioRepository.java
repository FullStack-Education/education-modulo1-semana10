package br.com.fullstack.education.m1s10.repository;

import br.com.fullstack.education.m1s10.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
