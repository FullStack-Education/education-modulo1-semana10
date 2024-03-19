package br.com.fullstack.education.m1s10.service;

import br.com.fullstack.education.m1s10.entity.UsuarioEntity;
import br.com.fullstack.education.m1s10.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsuarioEntity criar(UsuarioEntity usuario) throws Exception {
        usuario.setId(null);
        return repository.save(usuario);
    }

    @Override
    public List<UsuarioEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public UsuarioEntity buscarPorId(Long id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    @Override
    public UsuarioEntity alterar(Long id, UsuarioEntity usuario) throws Exception {
        UsuarioEntity entity = buscarPorId(id);
        entity.setNome(usuario.getNome());
        entity.setLogin(usuario.getLogin());
        entity.setSenha(usuario.getSenha());

        return repository.save(entity);
    }

    @Override
    public void apagar(Long id) throws Exception {
        UsuarioEntity entity = buscarPorId(id);
        repository.delete(entity);
    }
}
