package com.Inventario.Microservicio_Inventario.service;

import com.Inventario.Microservicio_Inventario.model.ProductoStock;
import com.Inventario.Microservicio_Inventario.repository.ProductoStockRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import java.util.Optional;

@Service
public class InventarioService {

    private final ProductoStockRepository repository;

    public InventarioService(ProductoStockRepository repository){
        this.repository = repository;
    }

    public ProductoStock obtenerStock(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProductoStock actualizarStock(Long id, String nombre, int stock) {
        ProductoStock productoStock = repository.findById(id)
                .orElse(new ProductoStock(id, stock, nombre));
        productoStock.setNombre(nombre);
        productoStock.setStock(stock);
        return repository.save(productoStock);
    }

    public ProductoStock aumentarStock(Long id, String nombre, int cantidad) {
        ProductoStock productoStock = repository.findById(id)
                .orElse(new ProductoStock(id, cantidad, nombre));
        productoStock.setNombre(nombre);
        productoStock.setStock(productoStock.getStock() + cantidad);
        return repository.save(productoStock);
    }

    public boolean eliminarProducto(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    public boolean disminuirStock(Long id, Integer cantidad) {
        Optional<ProductoStock> opt = repository.findById(id);
        if (opt.isPresent()) {
            ProductoStock ps = opt.get();
            if (ps.getStock() >= cantidad) {
                ps.setStock(ps.getStock() - cantidad);
                repository.save(ps);
                return true;
            }
        }

        return false;
    }

    public List<ProductoStock> obtenerTodos() {
        return repository.findAll();
    }

    public ProductoStock guardarProducto(ProductoStock productoStock){
        return repository.save(productoStock);
    }
}
