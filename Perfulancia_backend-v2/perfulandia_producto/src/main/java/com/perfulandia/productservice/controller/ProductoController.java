package com.perfulandia.productservice.controller;

import com.perfulandia.productservice.model.*;
import com.perfulandia.productservice.model.ProductoStock;
import com.perfulandia.productservice.service.ProductoService;
import java.util.List;
import org.springframework.web.bind.annotation.*;
//para comunicar mendiante peticiones http con el otro ms
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoService service;
    //Esto funciona asi como esta, no lo toque wons
    private final RestTemplate restTemplate;
    public ProductoController(ProductoService service, RestTemplate restTemplate){
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Producto> listar(){
        return service.listar();
    }

    @PostMapping
    public Producto guardar(@RequestBody Producto producto){
        return service.guardar(producto);
    }

    @GetMapping("/{id}")
    public Producto buscar(@PathVariable long id){
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable long id){
        service.eliminar(id);
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

    @GetMapping("/pedido/{id}")
    public Pedido obtenerPedido(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8089/api/pedido/" + id, Pedido.class);
    }

    @GetMapping("/inventario/{id}")
    public ProductoStock obtenerProductoStock(@PathVariable long id){
        return restTemplate.getForObject("http://localhost:8087/api/inventario/" + id,ProductoStock.class);
    }



}
