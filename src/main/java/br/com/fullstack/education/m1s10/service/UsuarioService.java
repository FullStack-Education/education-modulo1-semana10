package br.com.fullstack.education.m1s10.service;

import br.com.fullstack.education.m1s10.dto.UsuarioFiltro;
import br.com.fullstack.education.m1s10.entity.UsuarioEntity;
import br.com.fullstack.education.m1s10.service.abstracts.AbstractService;

import java.util.List;

public interface UsuarioService extends AbstractService<UsuarioEntity> {

    List<UsuarioEntity> buscarTodos(UsuarioFiltro filtro);

    UsuarioEntity buscarPorLogin(String login) throws Exception;

}
