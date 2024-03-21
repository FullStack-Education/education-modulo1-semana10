package br.com.fullstack.education.m1s10.service;

import br.com.fullstack.education.m1s10.dto.UsuarioFiltro;
import br.com.fullstack.education.m1s10.entity.UsuarioEntity;
import br.com.fullstack.education.m1s10.exception.error.UsuarioByIdNotFoundException;
import br.com.fullstack.education.m1s10.exception.error.UsuarioByLoginNotFoundException;
import br.com.fullstack.education.m1s10.repository.UsuarioRepository;
import br.com.fullstack.education.m1s10.service.abstracts.AbstractServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends AbstractServiceImpl<UsuarioEntity> implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<UsuarioEntity> buscarTodos(UsuarioFiltro filtro) {
        if (StringUtils.hasText(filtro.getNome()) && StringUtils.hasText(filtro.getLogin())) {
            return repository.findByNomeContainingIgnoreCaseAndLogin(filtro.getNome(), filtro.getLogin());
        } else if (StringUtils.hasText(filtro.getNome())) {
            return repository.findByNomeContainingIgnoreCase(filtro.getNome());
        } else if (StringUtils.hasText(filtro.getLogin())) {
            return repository.findByLogin(filtro.getLogin());
        }
        return repository.findAll();
    }

    @Override
    public UsuarioEntity buscarPorLogin(String login) {
        Optional<UsuarioEntity> opt = repository.findTop1ByLogin(login);
        return opt.orElseThrow(() -> new UsuarioByLoginNotFoundException(login));
    }

}
