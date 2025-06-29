package com.perfulandia.productservice.model;

//DTO DATA TRANSFER OBJECT ; OBJETO DE TRANSFERENCIA DE DATOS.
//PARA SIMULAR LA RESPUESTA DESDE EL OTRO MICROSERVICIO
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductoStock {
    private Long id;
    private int stock;
    private String nombre;
}
