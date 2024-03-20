package br.com.fullstack.education.m1s10.controller;

import br.com.fullstack.education.m1s10.dto.UsuarioFiltro;
import br.com.fullstack.education.m1s10.entity.UsuarioEntity;
import br.com.fullstack.education.m1s10.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public ResponseEntity<List<UsuarioEntity>> get(UsuarioFiltro filtro) {
        List<UsuarioEntity> usuarios = service.buscarTodos(filtro);
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping("{id}")
    public UsuarioEntity getId(@PathVariable Long id) throws Exception {
        return service.buscarPorId(id);
    }

    @GetMapping("login/{login}")
    public UsuarioEntity getLogin(@PathVariable String login) throws Exception {
        return service.buscarPorLogin(login);
    }

    @PostMapping
    public ResponseEntity<UsuarioEntity> post(@RequestBody UsuarioEntity usuario) throws Exception {
        UsuarioEntity usuarioCriado = service.criar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
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
