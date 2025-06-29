package com.perfulandia.usuarioservice.repository;


import com.perfulandia.usuarioservice.model.Usuario;
//2 importar jpa repository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interfaz hereda  de JpaRepository y gestiona la entidad usuario con ID Long
//findAll()
//findById()
//save() Guardar
//delete() Eliminar
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
