package br.com.fullstack.education.m1s10.service.abstracts;

import java.util.List;

public interface AbstractService<T> {

    List<T> buscarTodos();

    T buscarPorId(Long id) throws Exception;

    T criar(T entity) throws Exception;

    T alterar(Long id, T entity) throws Exception;

    void apagar(Long id) throws Exception;

}
