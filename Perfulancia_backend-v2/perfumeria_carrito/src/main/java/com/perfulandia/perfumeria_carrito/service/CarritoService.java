package com.perfulandia.perfumeria_carrito.service;

import com.perfulandia.perfumeria_carrito.model.Carrito;
import com.perfulandia.perfumeria_carrito.repository.CarritoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarritoService {

    private final CarritoRepository repo;
    public CarritoService(CarritoRepository repo){
        this.repo = repo;
    }

    //listar
    public List<Carrito> listar(){
        return repo.findAll();
    }
    //guardar
    public Carrito guardar(Carrito carrito){
        return repo.save(carrito);
    }
    //buscar por id
    public Carrito buscarPorId(Long id){
        return repo.findById(id).orElse(null);
    }
    //eliminar por id
    public void eliminar(Long id){
        repo.deleteById(id);
    }

    public Carrito findById(Long id) {
        return repo.findById(id).orElse(null);
    }
    public Carrito save(Carrito carrito) {
        return repo.save(carrito);
    }

}
