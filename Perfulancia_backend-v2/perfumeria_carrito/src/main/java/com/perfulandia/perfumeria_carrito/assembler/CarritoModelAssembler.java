package com.perfulandia.perfumeria_carrito.assembler;

import com.perfulandia.perfumeria_carrito.controller.CarritoController;
import com.perfulandia.perfumeria_carrito.model.Carrito;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@Component
public class CarritoModelAssembler implements RepresentationModelAssembler<Carrito, EntityModel<Carrito>> {

    @Override
    public EntityModel<Carrito> toModel(Carrito carrito){
        return EntityModel.of(carrito
        , linkTo(methodOn(CarritoController.class).buscar(carrito.getId())).withSelfRel(),
          linkTo(methodOn(CarritoController.class).listar()).withRel("carritos")
        );
    }

}
