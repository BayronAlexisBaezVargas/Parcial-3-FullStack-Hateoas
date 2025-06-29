package com.Inventario.Microservicio_Inventario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductoStock {

    @Id
    private Long id;
    private int stock;
    private String nombre;


}
