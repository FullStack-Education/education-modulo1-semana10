package br.com.fullstack.education.m1s10.controller;

import br.com.fullstack.education.m1s10.entity.UsuarioEntity;
import br.com.fullstack.education.m1s10.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioEntity> get() {
        return service.buscarTodos();
    }

    @GetMapping("{id}")
    public UsuarioEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarPorId(id);
    }

    @PostMapping
    public UsuarioEntity post(@RequestBody UsuarioEntity usuario) throws Exception {
        return service.criar(usuario);
    }

    @PutMapping("{id}")
    public UsuarioEntity put(@PathVariable Long id, @RequestBody UsuarioEntity usuario) throws Exception {
        return service.alterar(id, usuario);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws Exception {
        service.apagar(id);
    }

}
