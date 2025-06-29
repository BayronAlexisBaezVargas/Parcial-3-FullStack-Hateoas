package com.perfulandia.resena_service.controller;

import com.perfulandia.resena_service.model.Reseña;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/reseñas")
public class ReseñaController {

    private Map<Long, Reseña> reseñas = new HashMap<>();
    private Long idCounter = 1L;

    @GetMapping("/{id}")
    public EntityModel<Reseña> obtenerPorId(@PathVariable Long id) {
        Reseña reseña = reseñas.get(id);
        if (reseña == null) throw new RuntimeException("No encontrada");

        EntityModel<Reseña> recurso = EntityModel.of(reseña);
        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ReseñaController.class).obtenerPorId(id)).withSelfRel());
        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ReseñaController.class).obtenerTodas()).withRel("todas-las-reseñas"));

        return recurso;
    }

    @GetMapping
    public List<EntityModel<Reseña>> obtenerTodas() {
        List<EntityModel<Reseña>> lista = new ArrayList<>();
        for (Reseña r : reseñas.values()) {
            EntityModel<Reseña> model = EntityModel.of(r);
            model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ReseñaController.class).obtenerPorId(r.getId())).withSelfRel());
            lista.add(model);
        }
        return lista;
    }

    @PostMapping
    public EntityModel<Reseña> crear(@RequestBody Reseña nueva) {
        nueva.setId(idCounter++);
        reseñas.put(nueva.getId(), nueva);

        EntityModel<Reseña> recurso = EntityModel.of(nueva);
        recurso.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ReseñaController.class).obtenerPorId(nueva.getId())).withSelfRel());
        return recurso;
    }
}
