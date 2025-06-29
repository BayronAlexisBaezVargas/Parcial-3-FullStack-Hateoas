package com.perfulandia.productservice.model;



//DTO DATA TRANSFER OBJECT ; OBJETO DE TRANSFERENCIA DE DATOS.
//PARA SIMULAR LA RESPUESTA DESDE EL OTRO MICROSERVICIO
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String correo;
    private String rol; //ADMIN, GERENTE, UN USUARIO







}
