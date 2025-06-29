package com.perfulandia.productservice.service;

import com.perfulandia.productservice.model.Producto;
import com.perfulandia.productservice.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;
    public ProductoService(ProductoRepository repo){
        this.repo = repo;
    }


    //Listar
    public List<Producto> listar(){
        return repo.findAll();
    }

    //guardar
    public Producto guardar(Producto producto){
        return repo.save(producto);
    }
    //buscar x id
    public Producto buscarPorId(long id){
        return repo.findById(id).orElse(null);
    }
    //eliminar x id
    public void eliminar(long id){
        repo.deleteById(id);
    }


}
