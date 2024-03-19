package br.com.fullstack.education.m1s10.service;

import br.com.fullstack.education.m1s10.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    UsuarioEntity criar(UsuarioEntity usuario) throws Exception;

    List<UsuarioEntity> buscarTodos();

    UsuarioEntity buscarPorId(Long id) throws Exception;

    UsuarioEntity alterar(Long id, UsuarioEntity usuario) throws Exception;

    void apagar(Long id) throws Exception;

}
