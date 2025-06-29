package com.perfulandia.usuarioservice.service;

//import
import com.perfulandia.usuarioservice.model.Usuario;
import com.perfulandia.usuarioservice.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    //Constructor para inyectar el repositorio
    public UsuarioService(UsuarioRepository repo){
        this.repo = repo;
    }

    //metodo de listar
    public List<Usuario> listar(){
        return repo.findAll();
    }

    //Anotaciones o metodos para el crud
    public Usuario guardar(Usuario usuario){
        return repo.save(usuario);
    }

    //Buscar un usuario por su id
    public Usuario buscar(long id){
        return repo.findById(id).orElse(null);
    }

    //Eliminar
    public void eliminar(long id){
        repo.deleteById(id);
    }



}
