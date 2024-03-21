package br.com.fullstack.education.m1s10.service;

import br.com.fullstack.education.m1s10.entity.LivroEntity;
import br.com.fullstack.education.m1s10.repository.LivroRepository;
import br.com.fullstack.education.m1s10.service.abstracts.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class LivroServiceImpl extends AbstractServiceImpl<LivroEntity> implements LivroService {

    public LivroServiceImpl(LivroRepository repository) {
        super(repository);
    }

}
