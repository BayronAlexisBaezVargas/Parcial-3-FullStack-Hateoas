package com.perfulandia.perfumeria_carrito.controller;

import com.perfulandia.perfumeria_carrito.model.Carrito;
import com.perfulandia.perfumeria_carrito.service.CarritoService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/v1/carritos")
public class CarritoController {

    private final CarritoService service;
    public CarritoController(CarritoService service){
        this.service = service;
    }
    @GetMapping
    public List<Carrito> listar(){
        return service.listar();
    }
    @PostMapping
    public Carrito guardar(@RequestBody Carrito carrito){
        return service.guardar(carrito);
    }

    @GetMapping("/{id}")
    public Carrito buscar(@PathVariable long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable long id){
        service.eliminar(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizar(@PathVariable long id, @RequestBody Carrito carrito){
        try{
            Carrito car = service.findById(Long.valueOf(id));
            car.setId(id);
            car.setCantidad_productos(carrito.getCantidad_productos());
            car.setTotal(carrito.getTotal());
            car.setUsuario(carrito.getUsuario());

            service.save(car);
            return ResponseEntity.ok(car);
        }catch ( Exception e){
            return ResponseEntity.notFound().build();
        }
    }

}
