package br.com.fullstack.education.m1s10.service.abstracts;

import br.com.fullstack.education.m1s10.entity.AbstractEntity;
import br.com.fullstack.education.m1s10.exception.error.LivroByIdNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T> {

    protected final JpaRepository<T, Long> repository;

    public AbstractServiceImpl(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public T buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new LivroByIdNotFoundException(id));
    }

    @Override
    public T criar(T entity) throws Exception {
        entity.setId(null);
        return repository.save(entity);
    }

    @Override
    public T alterar(Long id, T entity) {
        buscarPorId(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Override
    public void apagar(Long id) {
        T entity = buscarPorId(id);
        repository.delete(entity);
    }
}
