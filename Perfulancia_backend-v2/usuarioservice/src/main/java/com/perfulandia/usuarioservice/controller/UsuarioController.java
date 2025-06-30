package com.perfulandia.usuarioservice.controller;
import com.perfulandia.usuarioservice.assembler.UsuarioModelAssembler;
import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.service.UsuarioService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioModelAssembler assembler;
    public UsuarioController(UsuarioService service){
        this.service = service;
        this.assembler = new UsuarioModelAssembler();
    }

    @GetMapping
    public CollectionModel<EntityModel<Usuario>> listar(){
        List<EntityModel<Usuario>> usuarios = service.listar().stream()
                .map(assembler::toModel).toList();
        return CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public EntityModel<Usuario> buscar(@PathVariable long id){
        return assembler.toModel(service.buscar(id));
    }

    @PostMapping
    public EntityModel<Usuario> guardar(@RequestBody Usuario usuario){
        Usuario guardado = service.guardar(usuario);
        return assembler.toModel(guardado);
    }

    @PutMapping("/{id}")
    public EntityModel<Usuario> actualizar(@PathVariable long id, @RequestBody Usuario usuario){
        Usuario actualizado = service.actualizar(id, usuario);
        return assembler.toModel(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        service.eliminar(id);
    }



}
