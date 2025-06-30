package com.perfulandia.productservice.controller;


import com.perfulandia.productservice.model.*;
import com.perfulandia.productservice.model.ProductoStock;
import com.perfulandia.productservice.service.ProductoService;
import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
//para comunicar mendiante peticiones http con el otro ms
import org.springframework.web.client.RestTemplate;
import com.perfulandia.productservice.assembler.ProductoModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService service;
    private final ProductoModelAssembler assembler;
    private final RestTemplate restTemplate;
    public ProductoController(ProductoService service, RestTemplate restTemplate){
        this.service = service;
        this.restTemplate = restTemplate;
        this.assembler = new ProductoModelAssembler();
    }

    @GetMapping
    public CollectionModel<EntityModel<Producto>> listar(){
        List<EntityModel<Producto>> productos = service.listar().stream()
                .map(assembler::toModel).toList();
        return CollectionModel.of(productos,
                linkTo(methodOn(ProductoController.class).listar()).withSelfRel()
        );
    }

    @PostMapping
    public EntityModel<Producto> guardar(@RequestBody Producto producto){
        Producto guardado = service.guardar(producto);
        return assembler.toModel(guardado);
    }

    @GetMapping("/{id}")
    public EntityModel<Producto> buscar(@PathVariable long id){
        return assembler.toModel(service.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable long id){
        service.eliminar(id);
    }

    @PutMapping("/{id}")
    public EntityModel<Producto> actualizar(@PathVariable long id, @RequestBody Producto producto){
        Producto actualizado = service.actualizar(id, producto);
        return assembler.toModel(actualizado);
    }

    //Nuevo metodo para obtener los datos del usuario desde el ms de usuarios
    @GetMapping("/usuario/{id}")
    public Usuario obtenerUsuario(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8081/api/usuarios/" + id, Usuario.class);
    }

    @GetMapping("/carrito/{id}")
    public Carrito obtenerCarrito(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8086/api/v1/carritos/" + id, Carrito.class);
    }


    @GetMapping("/inventario/{id}")
    public ProductoStock obtenerProductoStock(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8087/api/inventario/" + id,ProductoStock.class);
    }



}
