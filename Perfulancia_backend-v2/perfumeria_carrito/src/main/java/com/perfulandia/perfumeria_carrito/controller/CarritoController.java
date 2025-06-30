package com.perfulandia.perfumeria_carrito.controller;

import com.perfulandia.perfumeria_carrito.model.Carrito;
import com.perfulandia.perfumeria_carrito.service.CarritoService;
import com.perfulandia.perfumeria_carrito.assembler.CarritoModelAssembler;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/api/v1/carritos")
public class CarritoController {
    private final CarritoService service;
    private final CarritoModelAssembler assembler;

    public CarritoController(CarritoService service){
        this.service = service;
        this.assembler = new CarritoModelAssembler();
    }

    @GetMapping
    public CollectionModel<EntityModel<Carrito>> listar(){
        List<EntityModel<Carrito>> carritos = service.listar().stream()
                .map(assembler::toModel).toList();
        return CollectionModel.of(carritos,
                linkTo(methodOn(CarritoController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public EntityModel<Carrito> buscar(@PathVariable long id){
        return assembler.toModel(service.buscarPorId(id));
    }

    @PostMapping
    public EntityModel<Carrito> guardar(@RequestBody Carrito carrito){
        Carrito guardado = service.guardar(carrito);
        return assembler.toModel(guardado);
    }

    @PutMapping("/{id}")
    public EntityModel<Carrito> actualizar(@PathVariable long id, @RequestBody Carrito carrito){
        Carrito actualizado = service.actualizar(id, carrito);
        return assembler.toModel(actualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable long id){
        service.eliminar(id);
    }

}
