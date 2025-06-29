package com.Inventario.Microservicio_Inventario.controller;

import com.Inventario.Microservicio_Inventario.model.ProductoStock;
import com.Inventario.Microservicio_Inventario.service.InventarioService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/inventario")

public class InventarioController {

    private final InventarioService service;

    public InventarioController(InventarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductoStock> listarInventario() {
        return service.obtenerTodos();
    }

    @PostMapping("/stock/{id}")
    public ResponseEntity<ProductoStock> actualizarStock(
            @PathVariable Long id,
            @RequestParam String nombre,
            @RequestParam int stock) {

        ProductoStock actualizado = service.actualizarStock(id, nombre, stock);
        return ResponseEntity.ok(actualizado);
    }

    @PostMapping("/stock/{id}/disminuir")
    public ResponseEntity<?> disminuirStock(
            @PathVariable Long id,
            @RequestParam int stock) {
        boolean result = service.disminuirStock(id,stock);
        if (result) {
            return ResponseEntity.ok().body("Stock actualizado");
        } else {
            return ResponseEntity.badRequest().body("Stock insuficiente o producto no encontrado");
        }
    }

    @PostMapping("/stock/{id}/aumentar")
    public ResponseEntity<ProductoStock> aumentarStock(
            @PathVariable Long id,
            @RequestParam String nombre,
            @RequestParam Integer stock) {

        ProductoStock actualizado = service.aumentarStock(id, nombre, stock);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        boolean eliminado = service.eliminarProducto(id);
        if (eliminado) {
            return ResponseEntity.ok().body("Producto eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //guardar producto
    @PostMapping
    public ProductoStock guardarProducto(@RequestBody ProductoStock productoStock){
        return service.guardarProducto(productoStock);
    }

    @GetMapping("/{id}")
    public ProductoStock obtenerProducto(@PathVariable Long id){
        return service.obtenerStock(id);
    }
}
